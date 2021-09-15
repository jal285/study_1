package LRU;

import java.security.interfaces.ECKey;
import java.util.HashMap;

/**
 * @author badpoone
 */
public class LRUCache {

    //key -> Nodde(key,val)
    private HashMap<Integer, Node> map;
    //Node(k1
    // ,v1) <-> Node(k2,v2) ...
    private DoubleList cache ;
    //最大容量
    private  int cap;

    public LRUCache(int capacity){
        this.cap = capacity;
        map = new HashMap<>( );
        cache = new DoubleList();
    }

    /**
     *  将某个key提升为最近使用的   */
    private void  makeRecently(int key){
        Node x=map.get(key);
        //先从链表中删除这个节点
        cache.remove(x);
        //重新插到队尾
        cache.addLast(x);
    }

    /**
     * 添加最近使用的元素
     */
    private void addRecently(int key,int val){
        Node x = new Node(key,val);
        //链表尾就是最近使用的元素
        cache.addLast(x);
        // 在map中添加key 的映射
        map.put(key,x);
    }

    /**
     * @param key  删除某一个key
     */
    private void deleteKey(int key){
        Node x = map.get(key);
        //从链表中删除
        cache.remove(x);
        //从map中删除
        map.remove(x);
    }

    /**
     * 删除最久未使用的元素
     */
    private void removeLeastRecently(){
        //链表头部的第一个元素就是最久未使用的
        Node deleteNode = cache.removeFirst();
        //同时别忘了从高map中 删除它的key
        int deletedKey = deleteNode.key;
        map.remove(deletedKey);
    }

    public  int get(int key){
        if(!map.containsKey(key)){
            return  -1;
        }
        //将该数据提升为最近使用的
        makeRecently(key);
        return  map.get(key).val;
    }

    public void  put(int key, int val){
        if(map.containsKey(key)){
            //删除旧的数据
            deleteKey(key);
            //新插入的数据为最近使用的数据
            addRecently(key,val);
        }

        if(cap == cache.size()){
            //删除最久未使用的元素
            removeLeastRecently();
        }
        //添加为最近使用的元素
        addRecently(key,val);
    }
}
