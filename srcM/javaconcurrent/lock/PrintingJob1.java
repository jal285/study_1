package javaconcurrent.lock;
//锁和同步块之间的主要区别是：
//
//        1）synchronized无法尝试访问某个块的超时。使用Lock.tryLock（long timeout，TimeUnit timeUnit），这是可能的。
//        2）该synchronized块必须完全包含在一个方法中。一个锁可以拥有它的调用lock()，并unlock()在不同的方法。


//Lock lock = new ReentrantLock();
//
//        lock.lock();
//
////critical section
//
//        lock.unlock();

public class PrintingJob1 implements Runnable{
    private PrinterQueue printerQueue;

    public PrintingJob1(PrinterQueue printerQueue){
        this.printerQueue = printerQueue;
    }


    @Override
    public void run() {
        System.out.printf("%s: Going to print a document",Thread.currentThread().getName());
        printerQueue.printJob(new Object());
    }
}

