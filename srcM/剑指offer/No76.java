package 剑指offer;

import java.security.Key;
import java.util.HashMap;
import java.util.Map;

/**
 * @author badpoone
 * 最小覆盖子串问题
 */
public class No76 {
    String mingWindow(String s, String t){
        char t1[]= t.toCharArray();
        HashMap<Character,Integer> need = null, window=null;
        for (char c: t1) {
            need.put(c, need.getOrDefault(c, 0) + 1);  //需要凑齐的字符
        }
        //左闭右开
        int left=0, right=0;
        int valid=0; // 窗口计数器
        int start=0,len=Integer.MAX_VALUE;
        while (right<s.length()){
            //c是将移入窗口的字符
            char c = s.charAt(right);
            //右移窗口
            right++;
            //窗口内数据更新
            if(need.containsKey(c)){
                window.put(c,window.getOrDefault(c,0)+1);
                if(window.get(c)==need.get(c)) {
                    valid++;
                }
                }
                //判断左侧窗口是否收缩
                while (valid==need.size()) {
                    //在这里更新最小覆盖子串
                    if (right - left < len) {
                        start = left;
                        len = right - left;
                    }
                    //d 是将移出窗口的字符
                    char d = s.charAt(left);
                    left++;
                    //窗口更新
                    if (need.containsKey(d)) {
                        if (window.get(d) == need.get(d)) {
                            valid--;
                        }
                        window.put(d, window.getOrDefault(c, 0) - 1);
                    }
                }
        }
        return  len==Integer.MAX_VALUE? "":s.substring(start,len);
    }

}

