package ADI.DP;
import java.util.*;
public class HouseRobber2 {
    public static int robbery2(int[] arr){
        int n= arr.length;
        if(arr.length==0) return 0;
        if(arr.length==1) return arr[0];
        int[] dp= new int[n];
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
        for(int i=0;i<n;i++){
            arr[i]= input.nextInt();
        }
        int[] arr1=new int[n-1];
        int[] arr2=new int[n-1];
        int k=0, m=0;
        for(int i=0;i<n;i++){
            if(i!=0){
                arr1[k++]=arr[i];
            }
            if(i!=n-1){
                arr2[m++]=arr[i];
            }
        }
        int ans= Math.max(robbery2(arr1),robbery2(arr2));
        System.out.println(ans);
    }
}
