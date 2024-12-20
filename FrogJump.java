package ADI.DP;
import java.util.*;
public class FrogJump {
    public static int frogjump(int[] height, int n, int[] dp){
        dp[0]= 0;
        dp[1]= Math.abs(height[1]-height[0]);
        for(int i=2;i<n;i++){
            int j1= dp[i-1]+ Math.abs(height[i]-height[i-1]);
            int j2= dp[i-2]+ Math.abs(height[i]-height[i-2]);
            dp[i]= Math.min(j1,j2);
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
            dp[i]=-1;
        }
        int ans= frogjump(height,n,dp);
        System.out.println(ans);
    }
}
