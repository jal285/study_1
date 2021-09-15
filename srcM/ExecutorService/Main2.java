package ExecutorService;

import java.util.concurrent.*;

public class Main2 {
    //ExecutorService是一个接口，它的实现可以异步方式执行Runnable或Callable类
    // 需要注意的是调用run()一个方法Runnable接口以同步的方式被简单地调用个方法

    //Executes only one thread
//    ExecutorService es = Executors.newSingleThreadExecutor();
//
//    //Internally manages thread pool of 2 threads
//    ExecutorService es = Executors.newFixedThreadPool(2);
//
//    //Internally manages thread pool of 10 threads to run scheduled tasks
//    ExecutorService es = Executors.newScheduledThreadPool(10);

    public static void main(String[] args) {
        //Demo task
        Runnable runnabletask = () ->{
            try {
                TimeUnit.MILLISECONDS.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };

        //Executor service instance
        ExecutorService executorService = Executors.newFixedThreadPool(10);

        //1. execute task using execute() method
        executorService.execute(runnabletask);

        //2.execute task using submit() method
        Future<String > result = executorService.submit(runnabletask,"DONE");
        while(result.isDone()==false){
            try {
                System.out.println("The method return value : " + result.get());
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
            //sleep for 1 second
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        //Shut down the executor service
        executorService.shutdownNow();
    }
//    void execute（Runnable task） –在将来的某个时间执行给定命令。
//    将来的commit（可运行任务） –提交可运行任务以执行并返回Future代表该任务的任务。成功完成后，get()将返回Future的方法null。
//    将来的提交（可运行任务，T结果） –提交可运行任务以执行并返回Future代表该任务的信息。Future的get()方法将result在成功完成后返回给定的方法。
}
