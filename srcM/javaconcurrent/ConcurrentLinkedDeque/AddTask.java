package javaconcurrent.ConcurrentLinkedDeque;

import java.util.concurrent.ConcurrentLinkedDeque;

public class AddTask implements Runnable{
    private ConcurrentLinkedDeque<String> list;

    public AddTask(ConcurrentLinkedDeque<String> list  ){
        this.list = list;
    }


    @Override
    public void run() {
        String name = Thread.currentThread().getName();
        for(int i=0;i<1000;i++){
            list.add(name+": Element"+i);

        }
    }
}
