package ADI.DP;

public class KnapsackProblem {
    public static void main(String[] args) {
        int[] profit= {60,100,120};
        int[] weight= {10,20,30};
        int sack= 50;
        int[][] dp= new int[weight.length+1][sack+1];
        for (int i = 0; i <= weight.length; i++) {
            for (int j = 0; j <= sack; j++) {
                dp[i][j] = -1;
            }
        }

        int ans= knapsack(sack, profit, weight, profit.length,dp);
        System.out.println(ans);
    }
    // recursive approach
    /*
    static int knapsack(int sack, int[] profit, int[] weight, int n){
        if(n==0 || sack==0){
            return 0;
        }
        if(weight[n]>sack){
            return knapsack(sack, profit, weight, n-1);
        }
        else{
            return Math.max(knapsack(sack,profit,weight,n-1),profit[n-1]+knapsack(sack-weight[n-1],profit,weight,n-1) );
        }
    }
    */

    // memoization approach
    static int knapsack(int sack, int profit[], int weight[], int n, int dp[][]){
        if(n==0 || sack==0){
            return 0;
        }
        if(dp[n][sack]!=-1){
            return dp[n][sack];
        }
        if(weight[n-1]>sack){
            return dp[n][sack]= knapsack(sack, profit, weight, n-1,dp);
        }else{
            return dp[n][sack]=Math.max(knapsack(sack,profit,weight,n-1,dp),
                                profit[n-1] + knapsack(sack-weight[n-1],profit,weight,n-1,dp) );
        }
    }

}
