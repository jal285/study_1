package 剑指offer;
public class No921{

    /**
     * 使括号有效的最小添加
     * @param s  需要添加括号的字符串
     * @return 添加次数
     */
    public int minAddToMakeValid(String s){
        //res 记录插入次数
        int res = 0;
        //need 变量记录右括号需求量
        int need = 0;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='('){
                //need+1
                need ++;
            }

            if(s.charAt(i)==')'){
                need--;
                if(need==-1){
                    need = 0;
                    //需插入一个左括号
                    res++;
                }
            }

        }

        return res+need;
    }
}
