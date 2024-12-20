package ADI.DP;
import java.util.*;
public class HouseRobber1 {
    public static int robbery1(int[] arr, int[] dp){
        int n= arr.length;
        if(arr.length==0) return 0;
        if(arr.length==1) return arr[0];
        dp[0]=arr[0];
        dp[1]= Math.max(arr[0],arr[1]);
        for(int i=2;i<n;i++){
            int incl= dp[i-2]+arr[i];
            int excl= dp[i-1];
            dp[i]= Math.max(incl,excl);
        }
        return dp[n-1];
    }
    public static void main(String[] args) {
        Scanner input= new Scanner(System.in);
        int n= input.nextInt();
        int[] arr= new int[n];
        int[] dp= new int[n];
        for(int i=0;i<n;i++){
            arr[i]= input.nextInt();
        }
        int ans= robbery1(arr,dp);
        System.out.println(ans);
    }
}
