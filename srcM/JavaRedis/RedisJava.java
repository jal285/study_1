package JavaRedis;

import redis.clients.jedis.Jedis;


import java.util.Iterator;
import java.util.List;
import java.util.Set;

/**
 * spring 中一般使用spring data redis
 * redis 需要开启 redis-server
 */
public class RedisJava {

    public static void main(String[] args) {
        Jedis jedis = new Jedis("localhost");
        jedis.auth("mypass");  //需要配置redis密码  CONFIG SET requirepass "password"
        System.out.printf("success\n");
        jedis.set("runoobkey","ww.runoob.com");
        System.out.printf("redis : "+ jedis.get("runoobkey"));
        //存储到列表
        jedis.lpush("site-list","runoob");
        jedis.lpush("site-list","baidu");
        jedis.lpush("site-list","taobao");
        List<String>list = jedis.lrange("site-list",0,2);
        for (int i=0;i<list.size();i++){
            System.out.printf(" \n: "+list.get(i)+"\n");

        }
        //Keys 实例
        Set<String>keys = jedis.keys("*");
        Iterator<String> it = keys.iterator();
        while (it.hasNext()){
            System.out.printf("key\n");
        }
    }

}
