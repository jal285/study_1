package javaconcurrent.ExecutorThreadPool;

import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

public class ThreadPoolExample {

    public static void main(String[] args) {
        ThreadPoolExecutor executor = (ThreadPoolExecutor) Executors.newFixedThreadPool(2);
        //一次或多次唯一任务时，固定线程池或缓存线程池非常有用
        for (int i=1;i<=5;i++){
            Task task = new Task("Task"+i);
            System.out.println("Creted: "+task.getName());

            executor.execute(task);
        }
        executor.shutdown();

    }
}
