package javaconcurrent.lock;

public class lockExample {

    public static void main(String[] args) {
        PrinterQueue  printerQueue = new PrinterQueue();
        Thread thread[]=new Thread[10];
        for (int i = 0; i < 10; i++){
            thread[i] = new Thread(new PrintingJob1(printerQueue),"Thread"+i);
        }
        for (int i=0;i<10;i++){
            thread[i].start();
        }

    }
}
