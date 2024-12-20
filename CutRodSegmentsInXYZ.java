package ADI.DP;
import java.util.*;
public class CutRodSegmentsInXYZ {
    public static void main(String[] args) {
        Scanner input= new Scanner(System.in);
        int n= input.nextInt();
        int x= input.nextInt();
        int y= input.nextInt();
        int z= input.nextInt();
        int[] dp= new int[n+1];
        Arrays.fill(dp,-1);
        dp[0]=0;
        for(int i=1;i<=n;i++){
            if(i-x>=0 && dp[i-x]!=-1){
                dp[i]= Math.max(dp[i],1+dp[i-x]);
            }
            if(i-y>=0 && dp[i-y]!=-1){
                dp[i]= Math.max(dp[i],1+dp[i-y]);
            }
            if(i-z>=0 && dp[i-z]!=-1){
                dp[i]= Math.max(dp[i],1+dp[i-z]);
            }
        }
        if(dp[n]<0){
            System.out.println(0);
        }else{
            System.out.println(dp[n]);
        }
    }
}

