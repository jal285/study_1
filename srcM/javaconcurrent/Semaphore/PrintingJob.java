package javaconcurrent.Semaphore;

class PrintingJob implements Runnable {

    private PrinteQueue printerQueue;

    public PrintingJob(PrinteQueue printerQueue){
        this.printerQueue = printerQueue;
    }
    @Override
    public void run() {
        System.out.printf("%s: Going to print a document\n",Thread.currentThread().getName());
        printerQueue.printJob(new Object());
    }
}
