package javaconcurrent.lock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class PrinterQueue {
    private final Lock queueLock = new ReentrantLock();

    public void printJob(Object document){
        queueLock.lock();
        try {
            Long duration=(long)(Math.random() *1000);
            System.out.println(Thread.currentThread().getName()+": PrintQueue: Printing a job during "+(duration));
            Thread.sleep(duration);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            System.out.printf("%s:  Thre document has been printed\n",Thread.currentThread().getName());
            queueLock.unlock();

//
//  该示例的关键在于PrinterQueue类的printJob()方法  。当
//  我们想使用锁来实现关键部分并确保只有一个执行线程运行代码块时，我们必须创建一个ReentrantLock对象
//   。在关键部分的开始，我们必须使用该lock()方法来控制锁。
//   在关键部分的末尾，我们必须使用该unlock()方法来释放锁的控制权，
//   并允许其他线程运行该关键部分导。如果没有unlock()在关键部分的末尾调用该方法，
////   则正在等待该块的其他线程将永远等待，从而致死锁情况。如果您在关键部分中使用try-catch块，
//   请不要忘记将包含该unlock()方法的句子放在finally部分中。
        }
    }
}
