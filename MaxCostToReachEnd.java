package ADI.DP;

public class MaxCostToReachEnd {
    public static void main(String[] args) {
        int[][] arr={{1,2,3},{4,5,6},{7,8,9}};
        int n= arr.length;;
        int m= arr[0].length;
        int ans= minCost(arr,m,n);
        System.out.println(ans);
    }
    static int maxCost(int[][] arr, int n, int m){
        int dp[][]= new int[n][m];
        dp[0][0]= arr[0][0];
        for(int row=1;row<n;row++){
            dp[row][0]= dp[row-1][0]+arr[row][0];
        }
        for(int col = 1; col <m; col++){
            dp[0][col]= dp[0][col-1]+arr[0][col];
        }
        for(int row=1;row<n;row++){
            for(int col=1;col<m;col++){
                dp[row][col]= arr[row][col]+ Math.max(dp[row-1][col], Math.max(dp[row-1][col-1],dp[row][col-1]));
            }
        }
        return dp[n-1][m-1];
    }

    static int minCost(int cost[][], int m, int n){
        if(n==0 || m==0){
            return 0;
        }
        int[]  prev= new int[n];
        int[] curr= new int[n];
        prev[0]= cost[0][0];
        for(int i=0;i<n;i++){
            curr[0]= prev[0]+cost[i][0];
            for(int j=1;j<n;j++){
                curr[j]= cost[i][j] +Math.min(curr[j-1],Math.min(prev[j],prev[j-1]));
            }
            System.arraycopy(curr,0,prev,0,n);
        }
        return curr[n-1];
    }
}
