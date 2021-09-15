package com.boot.demo.config.redis;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.Channel;
import io.netty.channel.ChannelFutureListener;

import java.net.InetSocketAddress;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

/**
 * @author badpoone
 */
public class doConnect {

    //  通过 Bootstrap 的 connect 方法连接到服务端

    public Channel doConnect(InetSocketAddress inetSocketAddress) throws ExecutionException, InterruptedException {
        CompletableFuture<Channel> completableFuture = new CompletableFuture<>();
        Bootstrap bootstrap = new Bootstrap();
        bootstrap.connect(inetSocketAddress).addListener((ChannelFutureListener)future->{
            if(future.isSuccess()){
                completableFuture.complete(future.channel());
            }else{
                throw  new IllegalStateException();
            }
        });
        return completableFuture.get();
    }


}
