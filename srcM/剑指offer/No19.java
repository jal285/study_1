package 剑指offer;

/**
 * @author badpoone
 * 剑指 No 19
 */
public class No19 {
    public boolean isMatch(String s, String p){
        int i = 0,j=0;
        while (i<s.length() && j<p.length()){
            //[.] 通配符是万金油
            //匹配
            if(s.charAt(i)==p.charAt(j) || p.charAt(j)=='*'){
                if (j < p.length() - 1 && p.charAt(j+1) == '*') {

                    //有*通配符,可以匹0次或多次
                } else {
                    //无* 通配符, 老老实实匹配1次
                    i++;
                    j++;
                }
            }else  {
                //不匹配
                if(j<p.length()-1 && p.charAt(j+1) == '*'){
                    //有*通配符, 只能匹配0次
                }
                return  false;
            }
        }
        boolean re = (i==j);
        return re;
    }



}
