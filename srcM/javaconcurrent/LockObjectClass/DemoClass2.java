package javaconcurrent.LockObjectClass;


public class DemoClass2 {
    //Method is stati
    public synchronized  static  void demoMethod(){
    }
}
//or
//public class DemoClass2{
//    public void demoMethod(){
//        synchronized (this){
//
//        }
//    }
//}
////or
//public  class DemoClass2{
//    private final Object lock = new Object();
//    public void demoMehod(){
//        synchronized (lock){
//            //other thread safe code
//        }
//    }
//}
