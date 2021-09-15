package javaconcurrent.sync;

public class Main {
    public static void main(String[] args) {
        final MathClass2 mathClass = new MathClass2();
        //first thread
        Runnable r = new Runnable(){ //内部类？ 调用并实现
            @Override
            public void run() {
                try {
                    mathClass.printNumbers(3);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        new Thread(r, "ONE").start(); //public Thread(Runnable target, String name)
        new Thread(r, "TWO").start();
    }

}
