package javaconcurrent.JieLiu;

import java.util.concurrent.*;

public class DemoExecutor {
    public static void main(String[] args) {
        Integer threadCounter = 0;
        BlockingQueue<Runnable> blockingQueue = new ArrayBlockingQueue<Runnable>(50);
//        CustomThreadPoolExecutor executor = new CustomThreadPoolExecutor(10,20,5000,
//                TimeUnit.MICROSECONDS,blockingQueue);
        BlockingThreadPoolExecutor executor = new BlockingThreadPoolExecutor(10,20,5000,
                TimeUnit.MICROSECONDS,blockingQueue);

        executor.setRejectedExecutionHandler(new RejectedExecutionHandler() {
            @Override
            public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
                System.out.println("DemoTask Rejected: "+((DemoTask) r).getName());
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("Lets add another time: "+((DemoTask) r).getName() );
                executor.execute(r);
            }
        });

        while (true){
            threadCounter++;
            // Adding threads one by one
            //System.out.println("Adding DemoTask : " + threadCounter);
            executor.execute(new DemoTask(threadCounter.toString()));
            if(threadCounter==1000){
                break;
            }
        }

    }
}
