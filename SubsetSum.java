package ADI.DP;

public class SubsetSum {
    public static void main(String[] args) {
        int n= 5;
        int[] arr= {1,2,3,4,5};
        int sum=5;
        int count= subsetSum(arr,n,sum);
        System.out.println(count);
    }
    static int subsetSum(int[] arr, int n, int sum){
        int count=0;
        boolean[] dp= new boolean[sum+1];
        dp[0]=true;
            for(int i=0;i<n;i++){
                for(int j=sum;j>=arr[i];j--){
                    dp[j]= dp[j] || dp[j- arr[i]];
                }

                if(dp[sum]){
                    count++;
                    dp[sum]=false;
                }
            }
            return count;
    }
}
