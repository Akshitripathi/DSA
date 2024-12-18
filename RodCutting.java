package ADI.DP;

public class RodCutting {
    public static void main(String[] args) {
        int n= 8;
        int[] arr= {3,5,8,9,10,17,17,20};
        int ans= rodCutting(arr,n-1,n);
        System.out.println(ans);
    }
    static int rodCutting(int[] arr, int index, int n){
        if(index==0){
            return n*arr[0];
        }
        int notCut= rodCutting(arr,index-1,n);
        int cut= Integer.MIN_VALUE;
        int rodLength=index+1;
        if(rodLength<=n){
            cut= arr[index]+ rodCutting(arr,index,n-rodLength);
        }
        return Math.max(cut, notCut);
    }
}
