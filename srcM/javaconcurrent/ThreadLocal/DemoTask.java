package javaconcurrent.ThreadLocal;


import java.util.Date;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

//为了解决这个问题，您可以在此处使用ThreadLocal变量。
//        您可以在控制器或任何预处理器拦截器中生成事务ID。并在中设置该交易ID JavaBingfaApplication.ThreadLocal。此后，
//        无论此控制器调用什么方法，它们都可以从threadlocal访问此事务ID。还要注意，应用程序控制器一次将处理一个以上的请求，并且由于每个请求都是在框架级别在单独的线程中处理的，因
//        此事务ID对于每个线程都是唯一的，并且可以从该线程的整个执行路径进行访问。
public class DemoTask implements Runnable{
    //JavaBingfaApplication.ThreadLocal  get()返回此线程局部变量的当前线程副本的值
    // remove（）：为此线程局部变量删除当前线程的值。
    //set（T value）：将此线程局部变量的当前线程副本设置为指定值。
    //initialValue（）：为此线程局部变量返回当前线程的“初始值”。

    private static  final AtomicInteger nextId = new AtomicInteger(0);
// Atomic integer containing the next thread ID to be assigned
    private static ThreadLocal<Integer> thredId = new ThreadLocal<Integer>(){
        //Thread local variable containing each thread's ID
        protected Integer initalValue()
        {
            return nextId.getAndIncrement();
        }
};
    //Returns the current thread's unique ID, assigning it if necessary

    public int getThreadId(){
        return thredId.get();
    }
    //Returns the current thread's starting timestamp
    private static final ThreadLocal<Date> startDate = new ThreadLocal<Date>(){
        protected Date initialValue(){
            return new Date();
        }
    };

    @Override
    public void run() {
        System.out.printf("Starting Thread: %s : %s\n",getThreadId(),startDate.get());
        try {
            TimeUnit.SECONDS.sleep((int)Math.rint(Math.random()*10));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.printf("Thread Finished: %s : %s\n",getThreadId(),startDate.get());

    }
}
