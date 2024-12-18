package ADI.DP;
import java.util.*;
public class MinimumSubsetSum {
    public static void main(String[] args) {
        int[] arr= {1,6,11,5};
        int ans= minSubsetSumDifference(arr);
        System.out.println(ans);
    }

    static int subsetSum(int[] arr){
        int n= arr.length;
        int totalSum=0;
        for(int num:arr){
            totalSum+=num;
        }
        boolean[][] dp= new boolean[n+1][totalSum/2+1];
        for(int i=0;i<=n;i++){
            dp[i][0]= true;
        }
        for(int i=1;i<=n;i++){
            for(int j=1;j<=totalSum/2;j++){
                if(arr[i-1]<=j){
                    dp[i][j]= dp[i-1][j] || dp[i-1][j- arr[i-1]];
                }else{
                    dp[i][j]= dp[i-1][j];
                }
            }
        }

        int subsetSum=0;
        for(int j= totalSum/2;j>=0;j--){
            if(dp[n][j]){
                subsetSum=j;
                break;
            }
        }

        return totalSum-2*subsetSum;
    }

    static int minSubsetSumDifference(int[] arr) {
        int n = arr.length;
        int totalSum = Arrays.stream(arr).sum();
        int[][] dp = new int[n+1][totalSum + 1];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        return findMinDifference(arr, n, 0, 0, totalSum, dp);
    }
    static int findMinDifference(int[] arr, int n, int currentIndex, int currentSum, int totalSum, int[][] dp) {
        if (currentIndex == n) {
            return Math.abs((totalSum - currentSum) - currentSum);
        }
        if (dp[currentIndex][currentSum] != -1) {
            return dp[currentIndex][currentSum];
        }
        int include = findMinDifference(arr, n, currentIndex + 1, currentSum + arr[currentIndex], totalSum, dp);
        int exclude = findMinDifference(arr, n, currentIndex + 1, currentSum, totalSum, dp);
        dp[currentIndex][currentSum] = Math.min(include, exclude);
        return dp[currentIndex][currentSum];
    }



}
