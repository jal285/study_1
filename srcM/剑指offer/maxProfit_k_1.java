package 剑指offer;

/**
 * @author badpoone
 */

public class maxProfit_k_1 {
    /**
     *
     */


    /**
     *  k 为1 时
     * @param prices 股票每天价格
     * @return 最大利润
     */
    public int maxProfit_k_1(int[] prices){
        int n = prices.length;
        int [][]dp = new int[n][2];
        //base case:
        int dp_i_0=0,dp_i_1=Integer.MIN_VALUE;
        for(int i=0;i<n;i++){
            dp_i_0= Math.max(dp_i_0,dp_i_1+prices[i]);
            dp_i_1=Math.max(dp_i_1,-prices[i]);

        }
        return dp_i_0;
    }
}
