package javaconcurrent.ConcurrentExecutor;

public class TestTwo implements Runnable{
    @Override
    public void run() {
        while (true){
            System.out.println("Executing task one");
            try{
                Thread.sleep(2000);
                //TimeUnit.SECONDS.sleep(2); 线程延时2 s

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}
