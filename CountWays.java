package ADI.DP;

public class CountWays {
    public static void main(String[] args) {
        int d= 6;
        int k=3;
        System.out.println(countWays(d,k));

    }
    static int countWays(int d, int k){
        if(d==1){
            return 1;
        }
        if(k==0){
            return 0;
        }
        int[] dp= new int[d+1];
        dp[0]=1;
        int total= dp[0];
        for(int i=1;i<=d;i++){
            dp[i]= total;
            if(i<k){
                total+= dp[i];
            }else{
                total+= dp[i]-dp[i-k];
            }
        }
        return dp[d];
    }
}
