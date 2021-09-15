package javaconcurrent.CountDownLatch;

import java.util.concurrent.CountDownLatch;

public class NetworkHealthChecker extends BaseHealthChecker{
    public NetworkHealthChecker(CountDownLatch latch) {

        super("Network Service ",latch);
    }

    @Override
    public void verfityService() { //服务已经启动
        System.out.println("Checking : "+this.get_serviceName());
        try {
            Thread.sleep(7000);
//            TimeUnit.SECONDS.sleep(7);
//            TimeUnit.MILLISECONDS.sleep(7000);   两种新型线程休眠写法


        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(this.get_serviceName()+"is Up");

    }

}
