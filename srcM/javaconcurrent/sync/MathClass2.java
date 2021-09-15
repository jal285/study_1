package javaconcurrent.sync;

public class MathClass2  {

    //同步方法
    synchronized void printNumbers(int n)throws InterruptedException{
        for(int i=1;i<=n;i++){
            System.out.println(Thread.currentThread().getName()+" : : "+i);
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {              //error实例  在sync方法中不能直接成为
        System.out.println(" main no problem");
        final MathClass2 mathClass2 = new MathClass2();
        Runnable r = new Runnable() {
            @Override
            public void run() {
                System.out.println("run no problem ");

                try {
                    mathClass2.printNumbers(3);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
       new Thread(r,"ONE").start();  //使用线程同步需要start方法将线程加入等待队列，等待run方法调用，否则会造成两个线程同时访问的情况 死锁
       new Thread(r,"TWO").start();
    }

   //如果实现Runnable接口需要另开新方法重写run


}
