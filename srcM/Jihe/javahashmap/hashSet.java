package Jihe.javahashmap;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class hashSet {
    public static void main(String[] args) {
        //Set用于存储不重复的key，并不需要存储映射的value，那么就可以使用Set
        Set<String> set = new HashSet<>();  //hash 是无序的
        System.out.println(set.add("abc")); // true
        System.out.println(set.add("xyz")); // true
        System.out.println(set.add("xyz")); // false，添加失败，因为元素已存在
        System.out.println(set.contains("xyz")); // true，元素存在
        System.out.println(set.contains("XYZ")); // false，元素不存在
        System.out.println(set.remove("hello")); // false，删除失败，因为元素不存在
        System.out.println(set.size()); // 2，一共两个元素
        for(String s:set){
            System.out.println(s);  //set集合的输出并不是按照存储顺序

        }
        Set<String> set2 = new TreeSet<>(); //Tree 为元素的存储顺序
        set2.add("apple");
        set2.add("banana");
        set2.add("pera");
        for (String s:set2){
            System.out.println(s);
        }
    }
}
