package demo;

/**
 * @author badpoone
 * @date 2021/7/6  22:29
 * 构建队列的链式存储
 */
public class Queue {

    //头指针
    private  Node head;

    //尾指针
    private  Node rear;


    private class Node{
        Object element; //数据域
        Node next;  //指针域

        //无参构造器
        public Node(){ }
        public Node(Object element){this.element=element;}
    }

    public void add(){
        head.next = null;
    }
}
