package javaconcurrent;


//yield()方法 让步
public class YieldExample {
    //优先级 1-10 1最低优先级，5正常优先级  最高优先级的线程将在执行时被赋予优先级，但并不能保证它一开始就处于运行状态
    //与池中等待的线程相比，当前正在执行的线程始终具有更高的优先级
    //t.setPriority()可用于设置线程的优先级 可以使用常量MIN_PRIORITY，MAX_PRIORITY和NORM_PRIORITY设置优先级。
    //应该在调用线程启动方法之前设置优先级
    //
    public static void main(String[] args) {
        Thread producer = new Producer();
        Thread consumer = new Consumer();

        producer.setPriority(Thread.MIN_PRIORITY);
        consumer.setPriority(Thread.MAX_PRIORITY);

        producer.start();
        consumer.start();


    }
}
class Producer extends Thread{
    public void run(){
        for (int i = 0;i<5; i++){
            System.out.println("Producer: Produced Item "+ i);
            Thread.yield();
        }
    }
}
class  Consumer extends Thread{
    public void run(){
        for (int i=0;i<5;i++){
            System.out.println("Consumer: Consumer Item "+ i );
            Thread.yield();
        }
    }
}

