package com.boot.demo.config.redis;

import com.alibaba.fastjson.support.spring.GenericFastJsonRedisSerializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ResourceLoader;
import org.springframework.data.redis.connection.ReactiveRedisConnection;
import org.springframework.data.redis.connection.ReactiveRedisConnectionFactory;
import org.springframework.data.redis.core.ReactiveRedisTemplate;
import org.springframework.data.redis.serializer.JdkSerializationRedisSerializer;
import org.springframework.data.redis.serializer.RedisSerializationContext;

/**
 * @author badpoone
 * @date 2021/6/19  9:38
 */
@Configuration
public class RedisConfig {

    @Bean
    public JdkSerializationRedisSerializer jdkSerializationRedisSerializer(ResourceLoader resourceLoader){
        return new JdkSerializationRedisSerializer(
                resourceLoader.getClassLoader());
    }

    @Bean
    public GenericFastJsonRedisSerializer genericFastJsonRedisSerializer(){
        return new GenericFastJsonRedisSerializer();
    }

//    public ReactiveRedisTemplate<Object,Object> reactiveRedisTemplate(
//            ReactiveRedisConnectionFactory reactiveRedisConnectionFactory,
//            GenericFastJsonRedisSerializer genericFastJsonRedisSerializer,
//            JdkSerializationRedisSerializer jdkSerializationRedisSerializer){
//
//        RedisSerializationContext<Object,Object>serializationContext=
//            RedisSerializationContext
//                .newSerializationContext()
//                .key(jdkSerializationRedisSerializer)
//                .value(genericFastJsonRedisSerializer)
//                .hashKey(jdkSerializationRedisSerializer)
//                .hashValue(jdkSerializationRedisSerializer)
//                .build();
//        return new ReactiveRedisTemplate<>(reactiveRedisConnectionFactory,serializationContext);
//    }


}
