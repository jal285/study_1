package javaconcurrent.CountDownLatch;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class ApplicationStartupUtil {
    //类是主要的启动类，它将初始化闩锁并等待该闩锁，直到检查所有服务为止。
    //List of sevice checkers
    private static List<BaseHealthChecker> _services;

    //This latch will be used to wait on
    private static CountDownLatch _latch;
    private ApplicationStartupUtil(){
    }

    private static final ApplicationStartupUtil INSTANCE = new ApplicationStartupUtil();


    public static ApplicationStartupUtil getInstance() {
        return INSTANCE;
    }
    public static  boolean checkExternalService() throws Exception{
        //Inititalize the latch with number of service checkers
        _latch = new CountDownLatch(3);
        //All add checker in lists

        _services = new ArrayList<BaseHealthChecker>();
        _services.add(new NetworkHealthChecker(_latch));


        int size = _services.size();

        //手动创建线程池可以更加明确线程池的运行规则
        Executor executor = new ThreadPoolExecutor(_services.size(),size,0L, TimeUnit.MILLISECONDS,new LinkedBlockingQueue<Runnable>());
    for(final BaseHealthChecker v: _services){
            executor.execute(v);
        }
        //Now wait till all Services are checked
        _latch.await();

    //Services are file and now proceed startup
        for(final BaseHealthChecker v: _services){
            if(!v.isServiceUp()){
                return false;
            }
        }

        return  true;
    }

}
