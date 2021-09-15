package Jihe.javahashmap;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class HashUse1 {
    public static void main(String[] args) {
        //HashMap是基于hashing原理
        //哈希表
        HashMap<String,String> hashMap = new HashMap<String,String>();
        hashMap.put("cn","中国");
        hashMap.put("en","英国");
        hashMap.put("us","美国");
        System.out.println(hashMap);
        System.out.println("cn"+hashMap.get("cn"));
        System.out.println(hashMap.keySet());
        System.out.println("===============");
        Iterator iterator = hashMap.keySet().iterator();
        while (iterator.hasNext()){
            String key  =   iterator.next().toString();
            System.out.println("key:"+key);
            System.out.println("value："+hashMap.get(key));
        }
        /**
         * 使用entry 遍历hashMao
         */
        System.out.println("==========");
        Set<Map.Entry<String,String>> sets=hashMap.entrySet();
        for(Map.Entry<String,String>entry : sets){
            System.out.println(entry.getKey()+",") ;
            System.out.println(entry.getValue());
        }
        System.out.println(hashMap.size());
        hashMap.clear();
        System.out.println(hashMap.size());
    }




}
