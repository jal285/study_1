package RPC;

import Netty.HelloServer;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.logging.LogLevel;
import io.netty.handler.logging.LoggingHandler;

/**
 * @author badpoone
 * rpc 服务端
 */
public class Server {
    private final int port;

    public Server(int port) {
        this.port = port;
    }
    private void start() throws InterruptedException {
        //1. bossGroup 用于接收连接, workGroup 用于具体的处理
        EventLoopGroup bossgroup = new NioEventLoopGroup(1);
        EventLoopGroup workerGroup = new NioEventLoopGroup();
        try{
            //2.创建服务端启动引导/辅助类 : ServerBootStrap
            ServerBootstrap b = new ServerBootstrap();
            //3.给引导类配置两大线程组,确定了线程模型
            b.group(bossgroup,workerGroup)
                    //打印日志
                    .handler(new LoggingHandler(LogLevel.INFO))
                    //4指定 IO模型
                    .channel(NioServerSocketChannel.class)
                    .childHandler(new ChannelInitializer<SocketChannel>() {
                        @Override
                        protected void initChannel(SocketChannel ch) throws Exception {
                            ChannelPipeline p = ch.pipeline();
                            //5.可以自定义客户端消息的业务处理逻辑
                            p.addLast(new HelloServerHanlder());
                        }
                    });
            //6.绑定端口, 调用sync 方法阻塞直到绑定完成
            ChannelFuture f = b.bind(port).sync();
            //7. 阻塞等待直到服务器channel关闭(closeFuture()方法获取Channel 的CloseFuture对象,然后调用sync()方法)
            f.channel().closeFuture().sync();
        } finally {
            //优雅关闭相关线程资源
            bossgroup.shutdownGracefully();
            workerGroup.shutdownGracefully() ;
        }
    }

    public static void main(String[] args) throws InterruptedException {
        new Server(8000).start();
    }
}
