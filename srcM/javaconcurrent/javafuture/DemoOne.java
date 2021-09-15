package javaconcurrent.javafuture;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

/**
 * @author badpoone
 * @date 2021/6/22  13:39
 */
public class DemoOne {

    public static CompletableFuture<Integer> compute() {
        final CompletableFuture<Integer> future = new CompletableFuture<>();
        return future;

    }

    public static void main(String[] args) throws Exception {
        final CompletableFuture<Integer> f = compute();
        /**
         * 内部类创建thread
         */
        class Client extends Thread {
            CompletableFuture<Integer> f;
            Client(String threadName, CompletableFuture<Integer> f) {
                super(threadName);
                this.f = f;
            }
            @Override
            public void run() {
                try {
                    System.out.println(this.getName() + ": " + f.get());
                } catch (InterruptedException | ExecutionException e) {
                    e.printStackTrace();
                }
            }
        }
        new Client("Client1", f).start();
        new Client("Client2", f).start();
        System.out.println("waiting");
        //添加异步完成的任务
        f.complete(100);
        //f.completeExceptionally(new Exception());
        System.in.read();
    }
}
