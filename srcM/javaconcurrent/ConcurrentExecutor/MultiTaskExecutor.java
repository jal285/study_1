package javaconcurrent.ConcurrentExecutor;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class MultiTaskExecutor {
    public static void main(String[] args) {
        BlockingQueue<Runnable> worksQueue = new ArrayBlockingQueue<Runnable>(10);
        RejectedExecutionHandler rejectedExecutionHandler = new RejectedExecutionHandler() {
            @Override
            public void rejectedExecution(Runnable runnable, ThreadPoolExecutor executor) {
                System.out.println(runnable.toString() + " : I've been rejected ! ");
            }

        };
        ThreadPoolExecutor executor = new ThreadPoolExecutor(3,3,10, TimeUnit.SECONDS,worksQueue,rejectedExecutionHandler );

        executor.prestartAllCoreThreads();  //启动所有核心线程

        List<Runnable> taskGroup = new ArrayList<Runnable>();
        taskGroup.add(new TestOne());
        taskGroup.add(new TestTwo());
        taskGroup.add(new TeskThree());  //将三个任务添加进List

        worksQueue.add(new MultiRunable(taskGroup));  // 多运行包装器（三个任务）




    }

}

