package com.boot.demo.config.redis;

import com.boot.demo.config.redis.constant.RediskeyConstant;
import com.boot.demo.pojo.Login_info;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.ReactiveRedisTemplate;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;
import java.time.Duration;
import java.util.Objects;
import java.util.function.Consumer;

/**
 * @author badpoone
 */
@Component
public class RedisManager {

    @Autowired
    ReactiveRedisTemplate reactiveRedisTemplate;

    /**
     *
     * @param token
     * @param info
     * @param expirationSecond
     */
    public void saveSSOUserInfo(String token, Login_info info,Long expirationSecond ){
        if(Objects.isNull(info)){
            return;
        }
        if(token==null){
            return;
        }
        String redisKey = RediskeyConstant.SSO_KEY_PREF + token;
        reactiveRedisTemplate.opsForValue().set(redisKey,info).subscribe();
        reactiveRedisTemplate.expire(redisKey, Duration.ofSeconds(expirationSecond)).subscribe();
    }

    public Mono<Login_info> getSSOUserInfo(String token,Long expirationSecond){
        Mono mono =reactiveRedisTemplate.opsForValue().get(token);
        Mono<Login_info> map = mono.map(o->{
            if(o==null) {
                return null;
            }
            String redisKey = RediskeyConstant.SSO_KEY_PREF + token;
            reactiveRedisTemplate.expire(redisKey,Duration.ofSeconds(expirationSecond)).subscribe();
            return o;
        });
        return map;
    }

    public void hasSSOKey(String token, Consumer<Boolean>consumer ){
        String redisKey = RediskeyConstant.SSO_KEY_PREF+token;
        reactiveRedisTemplate.hasKey(redisKey).subscribe(b->{
            consumer.accept((boolean)b);
        });
    }


    /**
     * 删除 sso key
     * @param key
     */
    public void removeSSOKey(String key){
        reactiveRedisTemplate.delete(key).subscribe();
    }

}
