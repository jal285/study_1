package javaconcurrent.callFuture;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.*;

public class CallableExample {

    public static void main(String[] args) {
        ThreadPoolExecutor executor = (ThreadPoolExecutor) Executors.newFixedThreadPool(2);

        List<Future<Integer>> resultlist = new ArrayList<>();
        Random random = new Random();
        for(int i=0;i<4;i++){
            Integer number = random.nextInt(10);
            FactorialCaluator calcuator  = new FactorialCaluator(number);
            Future<Integer> result = executor.submit(calcuator); //发送了要在程序中执行的对象
            //返回一个Future 可以用于两个主要目标的对象
            resultlist.add(result);
        }
        for(Future<Integer> future :resultlist ){
            try{
                System.out.println("Future result is -"+ " "+ future.get()+ "; And Task done is " + future.isDone());
                //Future提供了get()方法的另一个版本，get(longtimeout,TimeUnitunit) 如果没有任务的结果
                // 等待超时，则不应引发TimeoutException
            } catch (InterruptedException e) {  //isDine（）检查任务是否已完成
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        }
        executor.shutdown();
    }
}
