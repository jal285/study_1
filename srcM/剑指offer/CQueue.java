package 剑指offer;

import java.util.LinkedList;
import java.util.Stack;

/**
 * @author badpoone
 * 剑指No.09 用两个stack实现队列
 */
public class CQueue {


    private  Stack<Integer>  s1,s2;

    public  CQueue(){
        s1 = new Stack<>();
        s2 = new Stack<>();
    }

    public void appendTail(int x){
        s1.push(x);

    }

    public  int deleteHead(){
        if(s2.isEmpty()){
            // s1队尾 内也无元素 那这个队列就是空队列
            if(s1.isEmpty()){
                return -1;
            }
            // s1 元素 压入 s2
            while (!s1.isEmpty()){
                s2.push(s1.pop());
            }
        }
        return s2.pop();
    }



}
