package javaconcurrent.javafuture;

import JavaUtil.Main;

import java.util.Random;
import java.util.concurrent.CompletableFuture;

import java.util.concurrent.Future;
import java.util.function.Supplier;

/**
 * @author badpoone
 * @date 2021/6/22  13:38
 */
public class CompletableFutureTest {

    private static Random rand = new Random();
    private static long t =  System.currentTimeMillis();
    static int getMoreData(){
        System.out.println("begin to test");
        try{
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
            throw new RuntimeException();
        }
        System.out.println("end to test. passed "+(System.currentTimeMillis()-t)/1000 + " seconds");
        rand.setSeed(100);
        return rand.nextInt(1000);
    }

    public static void main(String[] args) throws Exception{
        //异步执行getMoreData方法
        CompletableFuture<Integer> future = CompletableFuture.supplyAsync(CompletableFutureTest::getMoreData);
        Future<Integer>f=future.whenComplete((v,e)->{
            System.out.println("输出随机数: ");
            System.out.println(v);
            //e为空, e不调用getMoreData 方法
            System.out.println(e);
        });
        //获得future 结果
        System.out.println("fafaf is : "+f.get());
        System.in.read();

    }


}
