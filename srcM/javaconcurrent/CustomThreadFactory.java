package javaconcurrent;

import java.util.Date;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ThreadFactory;

public class CustomThreadFactory implements ThreadFactory { // 线程工厂
    private int  counter;
    private String name;
    private List<String> stats;

    public CustomThreadFactory(String name){
        counter = 1;
        this.name = name;
        stats = new ArrayList<String>();

    }

    @Override
    public Thread newThread(Runnable r) {
        Thread t = new Thread(r,name+"-Thread--"+counter);
        stats.add(String.format("created thread %d with name %s on %s ",t.getId(),t.getName(),new Date()));
        return t;
    }

    public  String getStats(){  //get 数据
        StringBuffer buffer = new StringBuffer();
        Iterator<String> it = stats.iterator(); //迭代器，用于遍历集合的对象

        while(it.hasNext()){//判断当前对象下一处地址是否有内容
            buffer.append(it.next());
        }
        return  buffer.toString();
    }


    public static void main(String[] args) {
        CustomThreadFactory factory = new CustomThreadFactory("CustomThreadFactory");
        Task task = new Task();
        Thread thread;
        System.out.println("Starting the Thread!\n");
        for(int i=0;i<=10;i++){
            thread = factory.newThread(task); //task 为启动器实例
            thread.start();  //使用start放法会将线程放到等待队列
        }
        System.out.println("All Threads creatd now\n");
        System.out.println("Give me CusotmFactory stats:\n"+ factory.getStats());

    }
}


