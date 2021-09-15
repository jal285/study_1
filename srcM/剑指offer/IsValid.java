package 剑指offer;

import org.junit.Test;

import java.util.Stack;

/**
 * @author badpoone
 */
public class IsValid {

    public static boolean isvalid(String str){
        Stack<Character> left = new Stack<>();
        for(char c : str.toCharArray()){
            if(c == '('||c=='{'||c=='['){
                left.push(c);
                break;
            }
            if(!left.empty()&&lefof(c)==left.pop()) {left.pop();}
            else
                // 和最近的左括号不匹配
                return false;

        }
        return  left.isEmpty();
    }

    private static Character lefof(char c) {
        if(c=='}')return '{';
        if(c==')')return '(';
        return ']';
    }


    public static void main(String[] args) {
        isvalid("c");
    }




}
