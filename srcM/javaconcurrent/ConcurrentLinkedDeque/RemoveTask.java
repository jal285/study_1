package javaconcurrent.ConcurrentLinkedDeque;

import java.util.concurrent.ConcurrentLinkedDeque;

public class RemoveTask implements Runnable{

    private ConcurrentLinkedDeque<String> list;

    public RemoveTask(ConcurrentLinkedDeque<String> list){
        this.list = list ;
    }
    @Override
    public void run() {
        for (int i=0;i<5000;i++){
            list.pollFirst();  //返回列表中的第一个和最后一个元素
            list.pollLast();
        }
    }
}
