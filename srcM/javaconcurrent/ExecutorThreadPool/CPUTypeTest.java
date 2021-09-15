package javaconcurrent.ExecutorThreadPool;

import java.util.List;

/**
 * @author badpoone
 * @date 2021/6/23  22:47
 */
public class CPUTypeTest implements Runnable{
    //整体执行时间, 包括在队列中等待的时间
    List<Long> wholeTimeList;
    //真正执行时间
    List<Long> runTimeList;

    private long  initStartTime=0 ;

    public CPUTypeTest(List<Long> wholeTimeList, List<Long> runTimeList, long initStartTime) {
        initStartTime = System.currentTimeMillis();
        this.runTimeList = runTimeList;
        this.wholeTimeList = wholeTimeList;
    }

    /**
     * 判断素数
     * @param number
     * @return
     */
    public boolean isPrime(final int number){
        if(number<=1){
            return false;
        }
        for(int i=2;i<=Math.sqrt(number);i++){
            if(number%i==0) {
                return false;
            }
        }
        return true ;
    }

    public int countPrimes(final int lower,final int upper){
        int total = 0;
        for(int i=lower;i<=upper;i++){
            if(isPrime(i)){
                total++;
            }
        }
        return  total;
    }

    @Override
    public void run() {
        long start=System.currentTimeMillis();
        countPrimes(1,1000000);
        //获得运行后时间
        long end=System.currentTimeMillis();

        //全部时间
        long wholeTime = end-initStartTime;
        long runTime = end - start;
        wholeTimeList.add(wholeTime);
        runTimeList.add(runTime);
        System.out.println("单个线程花费时间: "+(end-start));

    }



}
