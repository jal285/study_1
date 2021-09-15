package 剑指offer;

/**
 * @author badpoone
 */
public class OfferNo14 {
    /** time O(n平方) , 空间O(n)
     * 剪绳子求最大乘积
     * @param n 绳子长度
     * @return 成绩最大值
     */
    public int cuttingRope(int n){
        //无法剪绳子
        int a=2;
        //2-4时, 剪绳子的最大乘积为 n-1
        int b=4;

        if(n<a){
            return 0;
        }
        if(n<b){
            return n-1;
        }

        //res[i] 表示当长度为i时的最大乘积
        int []res = new int[n+1];
//        res[1]=1;
//        res[2]=2;
//        res[3]=3;
        for(int i=4;i<=n;i++){
            int max=0;
            for(int j=1;j<=i/2;++j){
                max=Math.max(max,res[j]*res[i-j]);
            }
            res[i]=max;
        }
        //res[n] 一定是最大值
        return res[n];
    }

    /**
     * 贪心算法 求绳子最大乘积
     * @param length 绳子长度
     * @return 乘积最大值
     */
    public int adjectime(int length){
        if(length<2){
            return 0;
        }
        if(length<4){
            return  length-1;
        }
        // n>=5 时. 多剪长度为 3 的绳子 , 剩下的绳子长度为4时, 把僧子剪成两段长度为2的绳子
        int timesOf3 = length / 3 ;
        if (length%3 == 1 ){
            --timesOf3;
        }
        int timeof2 = (length - timesOf3 * 3 ) >> 1;
        return (int) (Math.pow(3,timesOf3)*Math.pow(2,timeof2));
    }
}
