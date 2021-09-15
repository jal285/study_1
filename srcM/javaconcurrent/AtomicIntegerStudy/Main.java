package javaconcurrent.AtomicIntegerStudy;


import java.util.concurrent.atomic.AtomicInteger;

////Initial value is 0
//AtomicInteger atomicInteger = new AtomicInteger();
//
////Initial value is 100
//        AtomicInteger atomicInteger = new AtomicInteger(100);
//
//        int currentValue = atomicInteger.get();         //100
//
//        atomicInteger.set(1234);
public class Main {
    public static void main(String[] args) {
        AtomicInteger atomicInteger = new AtomicInteger(100); //原子计数器


        //以原子方式将给定值添加到当前值，并在添加后返回新值
        System.out.println(atomicInteger.addAndGet(2)); //102
        System.out.println(atomicInteger); //102
        //以原子方式将给定值添加到当前值并返回旧值
        System.out.println(atomicInteger.getAndAdd(2)); //102
        System.out.println(atomicInteger);
        //以原子方式将当前值加1，并在增加后返回新值。它等效于++ i操作。
        System.out.println(atomicInteger.incrementAndGet());
        System.out.println(atomicInteger);
        //以原子方式增加当前值并返回旧值。它等效于i ++操作
        System.out.println(atomicInteger.getAndIncrement());
        System.out.println(atomicInteger);
        //以原子方式将当前值减1，并在减后返回新值。它等效于i-操作。
        System.out.println(atomicInteger.decrementAndGet());
        System.out.println(atomicInteger);
        //以原子方式递减当前值并返回旧值。它等效于– -i操作。
        System.out.println(atomicInteger.getAndDecrement());
        System.out.println(atomicInteger);


        //boolean compareAndSet(int expect,int update)
        //比较和交换操作

        AtomicInteger atomicInteger1 = new AtomicInteger(100);

        boolean isSucces = atomicInteger1.compareAndSet(100,110); //current value 100
        System.out.println(isSucces); // true

        isSucces = atomicInteger1.compareAndSet(100,120);//current value 110
        System.out.println(isSucces);


    }
}
