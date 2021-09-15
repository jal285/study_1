package com.boot.demo.config.manager;

import com.boot.demo.config.redis.RedisManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.ReactiveRedisTemplate;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

/**
 * @author badpoone
 * @date 2021/6/18  23:37
 */
@Service
public class RedisAdapte implements SSOManager{


    @Autowired
    ReactiveRedisTemplate reactiveRedisTemplate;
    @Autowired
    private RedisManager redisManager;

    @Override
    public void logout(String key) {
        redisManager.removeSSOKey(key);
    }

    @Override
    public void saveAuthentication(Authentication authentication, String token) {

    }

    @Override
    public Mono<Authentication> getAuthenticationByToken(String token) {
        Mono<Authentication> mono = reactiveRedisTemplate.opsForValue().get(token);
        return null;
    }
}
