package javaconcurrent.ExecutorThreadPool;

import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

public class FixedThreadPoolExecutorExample {
    public static void main(String[] args) {
        ThreadPoolExecutor executor = (ThreadPoolExecutor) Executors.newFixedThreadPool(4) ;
        for(int i = 0;i < 10;i++){
            TaskFixedSizeThreadPoolExecutor task = new TaskFixedSizeThreadPoolExecutor("Task"+i);
            System.out.println("A new task has benn added: "+task.getName());
            executor.execute(task);
        }

        System.out.println("Maximum threads inside pool "+executor.getMaximumPoolSize());
        executor.shutdown();
    }
}
