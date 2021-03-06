package javaconcurrent.sync;


import org.junit.Test;

/**
 * @author badpoone
 * 前线程调用共享变量的wait()方法后只会释放当前共享变量上的锁, 如果当前线程还持有其它共享变量的锁, 则这些锁是不会被释放的
 */
public class ManyLock {
    //创建资源
    private static volatile Object resourceA = new Object() ;
    private static volatile Object resourceB = new Object() ;

    static Object obj = new Object();


    public static void main(String[] args) throws InterruptedException{
        //创建线程
        Thread threadA = new Thread(new Runnable(){
            @Override
            public void run() {
                try{
                    //获取resourceA 共享资源的监视器锁
                    synchronized(resourceA){
                        System.out.println("threadA get resourceA");
                        //获取resourceB共享资源的监视器
                        synchronized(resourceB){
                            System.out.println("threadA get resourceB to lock");
                            //线程A阻塞, 并释放获取到的resourceA的锁
                            System.out.println("threadA release resourceA lock");
                            resourceA.wait();
                        }
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        });
        //创建线程
        Thread threadB = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    //休眠1s
                    Thread.sleep(1000);

                    //获取resourceA共享资源的监视器锁
                    synchronized (resourceA){
                        System.out.println("threadB get resourceA lock");
                        System.out.println("threadB try get resourceB lock...");
                        //获取resouceB共享资源监视器锁
                        synchronized (resourceB){
                            System.out.println("threadB get resouceB lock");
                            //线程B阻塞, 并示范获取到resourceA的锁
                            System.out.println("threadB release resourceA lock");
                            resourceA.wait();
                        }
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        threadA.start();
        threadB.start();
        //等待两个线程结束
        threadA.join();
        threadB.join();
        System.out.println("main over");
    }


    @Test
    public void  Interrupte() throws InterruptedException {

        //创建线程
        Thread threadA = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    System.out.println("-------begin------");
                    //阻塞当前线程
                    synchronized (obj){
                        obj.wait();
                    }
                    System.out.println("------end-------");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        threadA.start();
        //避免直接中断threada
        Thread.sleep(1000);
        System.out.println("-----begin interrupt threadA----");
        threadA.interrupt();
        System.out.println("-----end interrupt threadA");
    }



}
