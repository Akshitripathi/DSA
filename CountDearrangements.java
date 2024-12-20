package ADI.DP;
import java.util.*;
public class CountDearrangements {
    static long mod= 1000000007;
    public static void main(String[] args) {
        Scanner input= new Scanner(System.in);
        int n= input.nextInt();
        long[] dp= new long[n+1];
        Arrays.fill(dp,0);
        dp[1]=0;
         dp[2]=1;
         for(int i=3;i<=n;i++){
             long first =dp[i-1]%mod;
             long second =dp[i-2]%mod;
             long sum= (first+second)%mod;
             dp[i]= ((i-1)*sum)%mod;
         }
        System.out.println(dp[n]);
    }
}
