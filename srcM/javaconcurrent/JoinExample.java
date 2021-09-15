package javaconcurrent;


//如果在Thread实例上调用join()将堵塞当前正在运行线程，直到Thread实例完成执行为止
//join（）中设置超时，将在特定的超时后join()效果无效
public class JoinExample {
    public static void main(String[] args) throws InterruptedException {
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("First task started");
                System.out.println("Sleeping for 2 seconds");
                try{
                    Thread.sleep(2000);

                }catch (InterruptedException e){
                    e.printStackTrace();
                }
                System.out.printf("First task completed\n");
            }
        });
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Second task completed");
            }
        });
        t.start();
        t.join();  //使t1 不会在t休眠时间运行
        t1.start();
    }

}
