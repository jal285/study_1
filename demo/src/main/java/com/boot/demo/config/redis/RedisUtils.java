package com.boot.demo.config.redis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

/**
 * @author badpoone
 */
@Component
public class RedisUtils {

    @Autowired
    private RedisTemplate<String,String> redisTemplate;

    /**
     * 读取缓存
     * @param key  参数
     * @return
     */
    public String get(final String key){
        return redisTemplate.opsForValue().get(key);
    }

    /**
     * 设置缓存
     * @param key
     * @param value
     * @return
     */
    public boolean set(final String key,String value){
        boolean result=false;
        try {
            redisTemplate.opsForValue().set(key,value);
            result = true;
        }catch (Exception e){
            e.printStackTrace();
        }
        return result;
    }

    /**
     * 更新缓存
     * @return 结果
     */
    public boolean getAndset(final String key,String value){
        boolean result = false;
        try {
            redisTemplate.opsForValue().getAndSet(key,value);
            result = true;
        }catch (Exception e){
            e.printStackTrace();
        }
        return result;
    }

    public boolean delete(final String key){
        boolean result = false;
        try {
            redisTemplate.delete(key);
            result = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }


}
