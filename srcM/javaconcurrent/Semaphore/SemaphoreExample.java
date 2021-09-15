package javaconcurrent.Semaphore;


public class SemaphoreExample {
    public static void main(String[] args) {
        PrinteQueue printerQueue = new PrinteQueue();
        Thread thread[]=new Thread[10];
        for (int i=0; i<10;i++){
            thread[i] = new Thread(new PrintingJob(printerQueue),"Thread"+i);
        }
        for (int i=0;i<10;i++){
            thread[i].start();
        }
    }
}
