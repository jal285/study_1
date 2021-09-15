package JUC;

import java.util.concurrent.atomic.AtomicLong;

/**
 * @author badpoone
 * @date 2021/6/23  9:25
 */
public class AtomicLongTest {

    private static AtomicLong atomicLong = new AtomicLong();
    //创建数据
    private static Integer[]  arrayOne = new Integer[]{0,1,2,0,4,5,6,0,8,9};
    private static Integer[]  arrayTwo = new Integer[]{10,1,2,0,4,5,6,0,8,9};

    public static void main(String[] args) throws InterruptedException {
        //线程One 统计数组arrayOne 中0的个数
        Thread threadOne = new Thread(new Runnable() {
            @Override
            public void run() {
                int size = arrayOne.length;
                for (int i=0;i<size;i++){
                    if(arrayOne[i].intValue()==0){
                        atomicLong.incrementAndGet();
                    }
                }
            }
        });
        //线程Two统计数组arrayTwo中0的个数
        Thread threadTwo = new Thread(new Runnable() {
            @Override
            public void run() {
                int size = arrayTwo.length;
                for (int i=0;i<size;i++){
                    if (arrayTwo[i].intValue()==0){
                        atomicLong.incrementAndGet();
                    }
                }
            }
        });

        //启动子线程
        threadOne.start();
        threadTwo.start();

        //等待线程执行完毕
        threadOne.join();
        threadTwo.join();

        System.out.println("count: 0 "+atomicLong.get());
    }

}
