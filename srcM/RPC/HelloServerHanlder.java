package RPC;

import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.util.CharsetUtil;
import io.netty.util.ReferenceCountUtil;
import io.netty.util.concurrent.EventExecutorGroup;

import java.nio.ByteBuffer;

import static io.netty.util.CharsetUtil.UTF_8;

/**
 * @author badpoone
 */
public class HelloServerHanlder extends ChannelInboundHandlerAdapter {

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg)throws Exception{
        try {
            ByteBuffer in = (ByteBuffer) msg;
           // System.out.println("message from client:" + in.toString(CharsetUtil.UTF_8));
            // 发送消息给客户端
         //   ctx.writeAndFlush(Unpooled.copiedBuffer("你也好！", UTF_8));
        }finally {
            ReferenceCountUtil.release(msg);
        }
    }
    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) {
        // Close the connection when an exception is raised.
        cause.printStackTrace();
        ctx.close();
    }

}
