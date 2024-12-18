package ADI.DP;

public class LongestCommonSubsequence {
    public static void main(String[] args) {
        String s1= "ABC";
        String s2= "ADC";
        int L1= s1.length();
        int L2= s2.length();
        int[][] dp= new int[L1+1][L2+1];
        for(int i=0;i<=L1;i++){
            for(int j=0;j<=L2;j++){
                dp[i][j]=-1;
            }
        }
        int ans= lcs(s1,s2,L1,L2,dp);
        System.out.println(ans);
    }
    static int lcs(String s1, String s2, int L1, int L2, int dp[][]){
        if(L1==0 ||L2==0){
            return 0;
        }
        if(dp[L1][L2]!=-1){
            return dp[L1][L2];
        }
        if(s1.charAt(L1-1)==s2.charAt(L2-1)){
            dp[L1][L2]= 1+ lcs(s1,s2,L1-1,L2-1,dp);
            return dp[L1][L2];
        }
        dp[L1][L2]= Math.max(lcs(s1,s2,L1-1,L2,dp),lcs(s1,s2,L1,L2-1,dp));
        return dp[L1][L2];
    }
}
