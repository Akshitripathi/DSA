package HashMAp;

import java.util.*;

public class MaxFreq {
    static int maxFreqCalc(int[] arr, int n){
        if(n==0){
            return -1;
        }
        HashMap<Integer, Integer> hm= new HashMap<>();
        for(int i=0;i<n;i++){
            hm.put(arr[i],hm.getOrDefault(arr[i],0)+1);
        }
        int maxfreq=0;
        int minNumberWithFreq= Integer.MAX_VALUE;
        for(HashMap.Entry<Integer,Integer> x: hm.entrySet()){
            if(x.getValue()>maxfreq){
                maxfreq=x.getValue();
                minNumberWithFreq=x.getKey();
            }else if( maxfreq== x.getValue()){
                if(minNumberWithFreq>x.getKey()){
                    minNumberWithFreq=x.getKey();
                }
            }
        }
        return minNumberWithFreq;
    }
    public static void main(String[] args) {
        Scanner input= new Scanner(System.in);
        int n= input.nextInt();
        int[] arr= new int[n];
        for(int i=0;i<n;i++){
            arr[i]= input.nextInt();
        }
        int maxFreqEle= maxFreqCalc(arr,n);
        System.out.println(maxFreqEle);
    }
}
