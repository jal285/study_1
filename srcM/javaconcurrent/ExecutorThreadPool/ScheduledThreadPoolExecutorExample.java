package javaconcurrent.ExecutorThreadPool;

import java.util.Date;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author 2233451206
 */
public class ScheduledThreadPoolExecutorExample {

    public static void main(String[] args) {
        ScheduledThreadPoolExecutor executor = (ScheduledThreadPoolExecutor) Executors.newScheduledThreadPool(2);

        Task1 task= new Task1("Repeat Task");
        System.out.println("Created: "+task.getName());

        executor.scheduleWithFixedDelay(task ,2,2, TimeUnit.SECONDS);
        //定期任务 首次执行任务为止的时间延迟 两次处决之间的时间间隔 第二第三参数的时间单位
    };

}
class Task1 implements Runnable{
    private String name;

    public Task1(String repeat_task) {
        this.name = repeat_task;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        System.out.println("Executing: "+name+", Current Seconds :"+ new Date().getSeconds());


    }
}
