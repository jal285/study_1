package Jihe.javahashmap;

import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ListIter {

    //List遍历通常用Iterator迭代器迭代进行  使用get(int)方法对ArryList是高效的
    public static void main(String[] args) {
        List<String> list = Stream.of("apple", "pear", "banana").collect(Collectors.toList());
        for (Iterator<String> it = list.iterator(); it.hasNext(); ) {
            String s = it.next();
            System.out.println(s);
        }
    }
}
