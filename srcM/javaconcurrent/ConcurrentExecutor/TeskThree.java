package javaconcurrent.ConcurrentExecutor;

public class TeskThree implements Runnable {

    @Override
    public void run() {
        System.out.println("Executing Task Three");
        try{
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
