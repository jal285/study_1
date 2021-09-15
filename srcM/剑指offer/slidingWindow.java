package 剑指offer;

import java.util.Map;

/**
 * @author badpoone
 */
public class slidingWindow {

    public void slidingWindow(String s, String t){
        //unordered_map<char,int>
        Map<Character, Integer> need,window;   //HashMap
        int left=0 ,right= 0;
        int valid=0;

//        while (right < s.size()) {   C++
//            // c 是将移入窗口的字符
//            char c = s[right];
//            // 右移窗口
//            right++;
//            // 进行窗口内数据的一系列更新
//        ...
//
//            /*** debug 输出的位置 ***/
//            printf("window: [%d, %d)\n", left, right);
//            /********************/
//
//            // 判断左侧窗口是否要收缩
//            while (window needs shrink) {
//                // d 是将移出窗口的字符
//                char d = s[left];
//                // 左移窗口
//                left++;
//                // 进行窗口内数据的一系列更新
//            ...
//            }
//        }
    }
}
