package ScientistEat;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

//破坏死锁的循环等待条件。
//        不再按左手边右手边顺序拿起筷子。选择一个固定的全局顺序获取，
//        此处给筷子添加id，根据id从小到大获取，(不用关心编号的具体规则，
//        只要保证编号是全局唯一并且有序的)，不会出现死锁情况

public class Test {
    public static void main(String[] args) {
        ExecutorService exec = Executors.newCachedThreadPool(); //线程池
        int sum = 5;
        Chopstick[] chopsticks = new Chopstick[sum];
        for(int i = 0;i < sum;  i++){
            chopsticks[i]=new Chopstick(i);
        }
        for (int i = 0;i<sum;i++){
            exec.execute(new Philosopher(chopsticks[i],chopsticks[(i+1)%sum]));
        }
    }
}


class   Chopstick{
    //状态
    private  int id;

    public  Chopstick(int id){
        this.id = id;

    }
    public int getId() {
        return id;
    }

    public void setId(int id){
        this.id = id;
    }

}

//哲学家
class Philosopher implements Runnable{ //Runnable是一个接口，只包含了一个抽象方法 run
    private Chopstick left;
    private Chopstick right;
    public Philosopher(Chopstick left,Chopstick riht){
        if(left.getId()<riht.getId()){
            this.left = left;this.right=right;

        }else{
            this.left = right;this.right = left;
        }
    }

    @Override
    public void run() {
        try {
            while (true){
                Thread.sleep(1000); //思考一段时间
                synchronized (left){
                    synchronized (right){
                        Thread.sleep(10000);//进餐一段时间
                    }
                }
            }
        } catch (InterruptedException e) {
            //TODO Auto-generated  catch block
            e.printStackTrace();
        }

    }
}
