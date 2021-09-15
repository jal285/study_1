package LRU;

import java.util.LinkedHashMap;

/**
 * @author badpoone
 * 使用java内置类型LinkedHashMap实现
 */
public class LRU {
    int cap;
    LinkedHashMap<Integer,Integer> cache = new LinkedHashMap<>();
    public LRU(int captity){
        this.cap = captity;
    }
    public int get(int key){
        if(!cache.containsKey(key)){
            return  -1;
        }
        //将key 变为最近使用
        makeRecently(key);
        return cache.get(key);
    }
    public  void put(int key,int val){
        if(cache.containsKey(key)){
            //修改key 值
            cache.put(key,val);
            //将key 变为最近使用
            makeRecently(key);
            return;
        }
        if (cache.size() >= this.cap){
            //链表头部为最久未使用的key
            int oldestKey = cache.keySet().iterator().next();
            cache.remove(oldestKey);
        }
        //将新的key 添加到 链表尾部
        cache.put(key,val);

    }

    private void makeRecently(int key) {
        int val = cache.get(key);
        //删除key ,重新插入队尾
        cache.remove(key);
        cache.put(key,val);
    }
}
