package javaconcurrent.ExecutorThreadPool;

import java.util.concurrent.TimeUnit;

public class TaskFixedSizeThreadPoolExecutor implements Runnable{

    public String name;
    public TaskFixedSizeThreadPoolExecutor(String name ){
        this.name = name;
    }

    public String getName() {
        return name;
    }



    @Override
    public void run() {
        //设定线程需要执行的任务
        try {
            Long duration = (long)(Math.random()*10);
            System.out.println("Doing a task during: "+name);
            TimeUnit.SECONDS.sleep(duration);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
