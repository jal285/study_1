package com.boot.demo.config.security.handler;

import com.alibaba.fastjson.JSON;
import com.boot.demo.util.enums.AuthEnum;
import com.boot.demo.util.result.CommonResult;
import org.springframework.core.io.buffer.DataBuffer;
import org.springframework.core.io.buffer.DataBufferFactory;
import org.springframework.core.io.buffer.DataBufferUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

/**
 * spring security 已登陆, 但无权限用户,会使用此处理器
 * @author badpoone
 * @date 2021/6/15  21:28
 */
@Component
public class ServerAuthenticationEntryPoint implements org.springframework.security.web.server.ServerAuthenticationEntryPoint {

    @Override
    public Mono<Void> commence(ServerWebExchange exchange, AuthenticationException ex) {
        return Mono.defer(()-> Mono.just(exchange.getResponse()))
                .flatMap(reponse->{
                    reponse.setStatusCode(HttpStatus.OK);
                    reponse.getHeaders().setContentType(MediaType.APPLICATION_JSON);
                    DataBufferFactory dataBufferFactory = reponse.bufferFactory();
                    CommonResult<Object> failed=CommonResult.failed(AuthEnum.NO_AUTH);

                    DataBuffer buffer =dataBufferFactory.wrap(JSON.toJSONBytes(failed));
                    return reponse.writeWith(Mono.just(buffer))
                            .doOnError(Error-> DataBufferUtils.release(buffer));
                });
    }

}
