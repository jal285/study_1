package 剑指offer;

/**
 * 掷骰子
 * @author badpoone
 */
public class numRollsToTarget {

    private static final int MOD=1000000007;

    public static int numRollsToTarget (int d,int f,int target){
        // dp[i][j]  i代表 i个骰子 和 为 j
        int [][]dp = new int[31][1001];
        int min = Math.min(f,target);
        for(int i =1;i<=min;i++){
            dp[1][i]=1;
        }
        int targetMax = d*f;
        for(int i=2;i<=d;i++){
            for(int j=i;j<=targetMax;j++){
                for(int k=1;j-k>=0 && k<=f; k++){
                    dp[i][j] = (dp[i][j]+dp[i-1][j-k]%MOD);
                }
            }

        }
        return  dp[d][target];
    }

    public static void main(String[] args) {
        System.out.println(numRollsToTarget(1,6,3));;
    }

}
