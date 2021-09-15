package LRU;

/**
 * @author badpoone
 */
public class DoubleList {
    //头尾虚节点
    private Node head, tail;
    //链表元素数
    private int size;

    public DoubleList(){
        //初始化双向链表数据
        head = new Node(0,0);
        tail = new Node(0,0);
        head.next = tail;
        tail.prev = head;
        size = 0;
    }



    /**
     *    在链表尾部添加节点x, 时间O(1)
     * @param x 被添加节点
     */
    public  void  addLast(Node x){
        //将被插入位置的节点记录为x的记录
        x.prev = tail.prev;
        //将tail 节点变成x的next 节点
        x.next = tail;
        tail.prev.next = x;
        tail.prev = x;
        size ++ ;
    }

    /**
     * 删除链表种 的x节点(x一定存在)
     * @param x
     * 由于是双链表且给的是目标Node节点, 时间 O(1)
     */
    public void remove(Node x){
        //x的前一个节点
        x.prev.next = x.next;
        //x的后一个节点
        x.next.prev = x.prev;
        size--;
    }

    /**
     * 溢出链表中第一个节点, 并返回该节点, 时间O(1)
     * @return 被删除的第一个节点
     */
    public Node removeFirst(){
        if(head.next==null){
            return null;
        }
        Node first = head.next;
        remove(first);
        return  first;
    }

    /**
     *
     * @return 链表长度
     */
    public  int size(){
        return  size;
    }
}
