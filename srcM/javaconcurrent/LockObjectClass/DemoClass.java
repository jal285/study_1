package javaconcurrent.LockObjectClass;

public class DemoClass {
    private final  Object lock = new Object();
    public   void   demoMehtod(){
        synchronized (lock){
             //other thread safe code
        }
    }

}
