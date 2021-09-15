package com.boot.demo.util;

import com.boot.demo.util.net.NetWorkUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.SetOperations;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

/**
 * @author chunyang.leng
 * @date 2021-05-21 8:08 下午
 */
@Component
public class SnowFlakeId {
    private static final String REDIS_KEY = "snowflakeId";
    private static final Logger logger = LoggerFactory.getLogger(SnowFlakeId.class);
    @Autowired
    private RedisTemplate<String,String> redisTemplate;
    @Value("${server.port:8080}")
    private int tomcatPort;
    @Autowired
    private ThreadPoolTaskExecutor otherExecutor;
    /**
     * 起始的时间戳
     */
    private final static long START_STMP = 1480166465631L;

    /**
     * 每一部分占用的位数
     */
    private final static long SEQUENCE_BIT = 12; //序列号占用的位数
    private final static long MACHINE_BIT = 5;   //机器标识占用的位数
    private final static long DATACENTER_BIT = 5;//数据中心占用的位数

    /**
     * 每一部分的最大值
     */
    private final static long MAX_DATACENTER_NUM = -1L ^ (-1L << DATACENTER_BIT);
    private final static long MAX_MACHINE_NUM = -1L ^ (-1L << MACHINE_BIT);
    private final static long MAX_SEQUENCE = -1L ^ (-1L << SEQUENCE_BIT);

    /**
     * 每一部分向左的位移
     */
    private final static long MACHINE_LEFT = SEQUENCE_BIT;
    private final static long DATACENTER_LEFT = SEQUENCE_BIT + MACHINE_BIT;
    private final static long TIMESTMP_LEFT = DATACENTER_LEFT + DATACENTER_BIT;

    /**
     * 数据中心
     */
    private long datacenterId;
    /**
     * 机器标识
     */
    private long machineId;
    /**
     * 序列号
     */
    private long sequence = 0L;
    /**
     * 上一次时间戳
     */
    private long lastStmp = -1L;

    /**
     * 每分钟更新一次雪花id机器号和数据中心号
     */
    @PostConstruct
    private void post(){

        otherExecutor.execute(()->{
            for (;;){
                String localInterAddress = NetWorkUtils.getLocalInterAddress();
                String value = localInterAddress + ":" + tomcatPort;

                SetOperations<String, String> setOperations = redisTemplate.opsForSet();
                setOperations.add(REDIS_KEY,value);
                Set<String> members = setOperations.members(REDIS_KEY);
                if(!CollectionUtils.isEmpty(members)){
                    TreeSet<String> treeSet = new TreeSet<>(members);
                    List<String> list = new ArrayList<>(treeSet);
                    // 机器编码0~15
                    long workerId = 0;
                    // 数据中心编码 0~3
                    long datacenterId = 0;

                    for (int i = 0; i < list.size(); i++) {
                        workerId = i % 16;
                        if(i!=0 && workerId == 0 && datacenterId < 3){
                            datacenterId ++;
                        }
                        if(value.equals(list.get(i))){
                            break;
                        }
                    }
                    if (datacenterId > MAX_DATACENTER_NUM || datacenterId < 0) {
                        throw new IllegalArgumentException("datacenterId can't be greater than MAX_DATACENTER_NUM or less than 0");
                    }
                    this.datacenterId = datacenterId;
                    this.machineId = workerId;
                    logger.info("更新雪花id，数据中心:{},机器id:{}",datacenterId,workerId);

                    try {
                        Thread.sleep(60 * 1000);
                    } catch (InterruptedException e) {
                        logger.error("更新雪花id出现异常",e);
                    }
                }
            }
        });

    }

    /**
     * 产生下一个ID
     *
     * @return
     */
    public synchronized long nextId() {
        long currStmp = getNewstmp();
        if (currStmp < lastStmp) {
            throw new RuntimeException("Clock moved backwards.  Refusing to generate id");
        }

        if (currStmp == lastStmp) {
            //相同毫秒内，序列号自增
            sequence = (sequence + 1) & MAX_SEQUENCE;
            //同一毫秒的序列数已经达到最大
            if (sequence == 0L) {
                currStmp = getNextMill();
            }
        } else {
            //不同毫秒内，序列号置为0
            sequence = 0L;
        }

        lastStmp = currStmp;

        return (currStmp - START_STMP) << TIMESTMP_LEFT //时间戳部分
                | datacenterId << DATACENTER_LEFT       //数据中心部分
                | machineId << MACHINE_LEFT             //机器标识部分
                | sequence;                             //序列号部分
    }

    private long getNextMill() {
        long mill = getNewstmp();
        while (mill <= lastStmp) {
            mill = getNewstmp();
        }
        return mill;
    }

    private long getNewstmp() {
        return System.currentTimeMillis();
    }

}
