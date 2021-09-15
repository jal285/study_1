package ExecutorService;

import java.sql.Time;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.*;

public class Main {
//    将来的commit（callableTask） –提交一个执行返回值的任务，并返回一个代表任务的未决结果的未来。
//    List <Future> invokeAll（Collection task） –执行给定的任务，并在所有完成时返回保存其状态和结果的Future列表。请注意，仅当所有任务完成时结果才可用。
//    请注意，已完成的任务可能已正常终止，也可能会引发异常而终止。
//    List <Future> invokeAll（Collection task，timeOut，timeUnit） –执行给定的任务，当所有任务完成或超时到期时，返回保存其状态和结果的Future列表。
public static void main(String[] args) throws ExecutionException {
    Callable<String>callableTask = ()->{
        TimeUnit.MILLISECONDS.sleep(1000);
        return "Current time: : "+ LocalDateTime.now();
    };

    //Executor service instance
    List<Callable<String>> tasksList = Arrays.asList(callableTask,callableTask,callableTask);
    ExecutorService executor = Executors.newFixedThreadPool(1);

    //1. execute tasks list using invokeAll() method
    try {
        List<Future<String>> results = executor.invokeAll(tasksList);
        for (Future<String>result:results)
        {
            System.out.println(result.get());
        }
    } catch (InterruptedException e) {
        e.printStackTrace();
    }

    //2. execute individual tasks using submit() method
    Future<String> result = executor.submit(callableTask);

    while (result.isDone()==false){
        try {
            System.out.println("The method return value: "+ result.get());
            break;
        } catch (InterruptedException e ) {
            e.printStackTrace();
        }

        //sleep 1 second
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    executor.shutdownNow();
}
}
