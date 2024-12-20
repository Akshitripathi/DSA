package ADI.DP;

import java.util.Scanner;

public class FrogJumpWithKDistance {
    public static int frogjumpk(int[] height, int k, int[] dp){
        int n= height.length;
        dp[0]=0;
        for(int i=1;i<n;i++){
            for(int j= Math.max(0,i-k);j<i;j++){
                dp[i]= Math.min(dp[i],dp[j]+Math.abs(height[i]-height[j]));
            }
        }
        return dp[n-1];
    }
    public static void main(String[] args) {
        Scanner input= new Scanner(System.in);
        int n= input.nextInt();
        int[] height= new int[n];

        int[] dp= new int[n];
        for(int i=0;i<n;i++){
            height[i]= input.nextInt();
            dp[i]=Integer.MAX_VALUE;
        }
        int k= input.nextInt();
        int ans= frogjumpk(height,k,dp);
        System.out.println(ans);
    }
}
