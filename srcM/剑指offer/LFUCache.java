package 剑指offer;

import java.util.HashMap;
import java.util.LinkedHashSet;

/**
 * LFU算法 淘汰访问频次最低的数据
 * @author badpoone
 * @date 2021/6/17  9:28
 */
public class LFUCache {

    /**
     * kv表 ,key 到 val 的映射
     */
    HashMap<Integer,Integer> keyToVal;

    /**
     * kf表, key 到 freq的映射
     */
    HashMap<Integer,Integer> keyToFreq;

    /**
     * fk表, freq 到 key的映射
     */
    HashMap<Integer, LinkedHashSet<Integer>> freqToKeys;

    /**
     * 记录最小频次
     */
    int minFreq;

    /**
     * 记录LFU缓存的最大容量
     */
    int cap;

    /**
     *     构造容量为capacity的缓存
     */
    public LFUCache(int capacity){
        keyToVal=new HashMap<>();
        keyToFreq=new HashMap<>();
        freqToKeys=new HashMap<>();
        this.cap=capacity;
        this.minFreq=0;
    };

    /**
     *
     * @param key 拆线呢缓存中key
     * @return 缓存中key value
     */
    public int get(int key){
        if(!keyToVal.containsKey(key)){
            return -1;
        }
        //增加key对应频次
        increaseFreq(key);
        return keyToVal.get(key);
    }



    ;

    /**
     *
     * @param key 存入缓存中的key
     * @param value   存入缓存中的value
     * @return
     */
    public void put(int key,int value){
        if(this.cap<=0) return ;

        /** key存在,修改对应value*/
        if(keyToVal.containsKey(key)){
            keyToVal.put(key,value);
            //key对应的freq+1
            increaseFreq(key);
            return;
        }
        /** 若key不存在, 需要插入 */
        /* 容量已满的话需要淘汰一个freq 最小的key */
        if(this.cap<=keyToVal.size()){
            removeMinFreqKey();
        }

        /**
         * 插入key和val, 对饮的freq为1
         * 插入kv表
         */
        keyToVal.put(key,value);
        //插入kf表
        keyToFreq.put(key,1);
        //插入fk表
        freqToKeys.putIfAbsent(1,new LinkedHashSet<>());
        freqToKeys.get(1).add(key);
        //插入心key后最小的freq肯定是1
        this.minFreq=1;

    }

    private void removeMinFreqKey() {
        //freq最小的key列表
        LinkedHashSet<Integer>keyList = freqToKeys.get(this.minFreq);
        //其中最新被插入的key就是该被淘汰的key
        int deleteKey = keyList.iterator().next();
        /**
         * 更新fk表
         */
        keyList.remove(deleteKey);
        if(keyList.isEmpty()){
            freqToKeys.remove(this.minFreq);
            //这里不需要更新minFreq的值
        }
        /* 更新kv 表*/
        keyToVal.remove(deleteKey);
        /*更新kf表 */
        keyToFreq.remove(deleteKey);

    }
    private void increaseFreq(int key) {
        int freq = keyToFreq.get(key);
        /* 更细kf表 */
        keyToFreq.put(key,freq+1);
        /*更新fk表 */
        //将key从freq 对应的列表中删除
        freqToKeys.get(freq).remove(key);
        //将key加入freq+1 对应的列表中
        freqToKeys.putIfAbsent(freq+1,new LinkedHashSet<>());
        freqToKeys.get(freq+1).add(key);
        //如果freq对应的列表空了,溢出这个freq
        if(freqToKeys.get(freq+1).isEmpty()){
            freqToKeys.remove(freq);
            //如果这个freq恰好是minFreq,更新minFreq
            if(freq==this.minFreq){
                this.minFreq++;
            }
        }

    }

}
