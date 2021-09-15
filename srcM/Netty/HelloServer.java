package Netty;

import com.sun.org.slf4j.internal.Logger;
import com.sun.org.slf4j.internal.LoggerFactory;
import sun.plugin2.message.Message;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author badpoone
 * socket服务端
 */
public class HelloServer {
    private static final Logger logger  = LoggerFactory.getLogger(HelloServer.class);
    public void start(int port){
        //创建ServerSocker 对象并绑定一个端口
        try(ServerSocket serverSocket = new ServerSocket(port)){
            Socket socket;
            //通过accept() 方法监听客户端请求, 这个方法会一致阻塞到有一个连接建立
            while ((socket=serverSocket.accept())!=null){
                logger.warn("client connect");
                try (ObjectInputStream objectInputStream = new ObjectInputStream(socket.getInputStream()) ;
                     ObjectOutputStream objectOutputStream = new ObjectOutputStream(socket.getOutputStream()))
                {
                    //3 通过输入流读取客户端发送的请求信息
                    Message message = (Message) objectInputStream.readObject();
                    logger.warn("server receive message" + message);

                }
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }


}
