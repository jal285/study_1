package com.boot.demo.service;

import com.boot.demo.pojo.Login_info;
import com.boot.demo.pojo.User;
import com.boot.demo.service.LoginInfoHandler;
import com.boot.demo.util.Password;
import com.boot.demo.util.SnowFlakeId;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.Date;

/**
 * @author badpoone
 */
@Service
@Slf4j
public class LoginHandle {

    @Autowired
    LoginInfoHandler loginInfoHandler;
    @Autowired
    SnowFlakeId snowFlakeId;

    /**
     * Twitter_Snowflake<br>
     * SnowFlake的结构如下(每部分用-分开):<br>
     * 0 - 0000000000 0000000000 0000000000 0000000000 0 - 00000 - 00000 - 000000000000 <br>
     * 1位标识，由于long基本类型在Java中是带符号的，最高位是符号位，正数是0，负数是1，所以id一般是正数，最高位是0<br>
     * 41位时间截(毫秒级)，注意，41位时间截不是存储当前时间的时间截，而是存储时间截的差值（当前时间截 - 开始时间截)
     * 得到的值），这里的的开始时间截，一般是我们的id生成器开始使用的时间，由我们程序来指定的（如下下面程序IdWorker类的startTime属性）。41位的时间截，可以使用69年，年T = (1L << 41) / (1000L * 60 * 60 * 24 * 365) = 69<br>
     * 10位的数据机器位，可以部署在1024个节点，包括5位datacenterId和5位workerId<br>
     * 12位序列，毫秒内的计数，12位的计数顺序号支持每个节点每毫秒(同一机器，同一时间截)产生4096个ID序号<br>
     * 加起来刚好64位，为一个Long型。<br>
     * SnowFlake的优点是，整体上按照时间自增排序，并且整个分布式系统内不会产生ID碰撞(由数据中心ID和机器ID作区分)，并且效率较高，经测试，SnowFlake每秒能够产生26万ID左右。
     */

    @Autowired
    private Login_info loginInfo;

    Password password = new Password();

    /**
     *
     * @param user 通过类名和方法名+ uuid 签发token
     * @return
     */
    public String getToken(String user,String uuid){
        StringBuilder stringBuffer = new StringBuilder();
        StringBuilder token = stringBuffer.append(user.getClass().getName()).append(uuid);
        return token.toString();
    }

    public void  registerHandler(User user){
        String salt = password.getsalt();
        String pass ;
        Date date = new Date();
        loginInfo.setSalt(salt);
        pass = password.toMD5(user.getPassword()+salt);
        loginInfo.setPassword(pass);
        loginInfo.setName(user.getName());
        // 这里出现连续调用生成id函数得到id一致情况
        loginInfo.setId(snowFlakeId.nextId());
        loginInfo.setUserId(snowFlakeId.nextId());
        loginInfo.setStatus(1);
        loginInfo.setCreative(new java.sql.Date(date.getYear(),date.getMonth(),date.getDay()));
        if(loginInfoHandler.selectByName(loginInfo.getName())!=null){
            log.debug("the account is registed,please reinput ");
            return;
        }
       loginInfoHandler.insertIntoTable(loginInfo);
    }



}
