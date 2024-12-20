package ADI.DP;
import java.util.*;
public class ClimbingStairs {
    public static int climbstairs(int n, int[] dp){
        dp[0]=1;
        dp[1]=1;
        for(int i=2;i<=n;i++){
            dp[i]= dp[i-1]+dp[i-2];
        }
        return dp[n];
    }
    public static void main(String[] args) {
        Scanner input= new Scanner(System.in);
        int n= input.nextInt();
        int[] dp= new int[n+1];
        int ans= climbstairs(n,dp);
        System.out.println(ans);
    }
}
