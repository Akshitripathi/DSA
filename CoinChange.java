package ADI.DP;
import java.util.*;
public class CoinChange {
    public static int coinchange(int[] coins, int amount, int[] dp){
        dp[0]=0;
        for(int i=1;i<=amount;i++){
            for(int j=0;j<coins.length;j++){
                if(i-coins[j]>=0 && dp[i-coins[j]]!=Integer.MAX_VALUE){
                    dp[i]= Math.min(dp[i],1+dp[i-coins[j]]);
                }
            }
        }
        if(dp[amount]==Integer.MAX_VALUE){
            return -1;
        }
        return dp[amount];
    }
    public static void main(String[] args) {
        Scanner input= new Scanner(System.in);
        int n= input.nextInt();
        int[] coins= new int[n];
        for(int i=0;i<n;i++){
            coins[i]= input.nextInt();
        }
        int amount= input.nextInt();
        int[] dp= new int[amount+1];
        for(int i=0;i<=amount;i++){
            dp[i]= Integer.MAX_VALUE;
        }
        int ans= coinchange(coins,amount,dp);
        System.out.println(ans);
    }
}
