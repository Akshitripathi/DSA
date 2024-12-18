package Sorting;

import java.util.Scanner;

public class InsertionSort {
    public static void insert(int[] arr){

        int n= arr.length;
        for(int i=1;i<n;i++){
            int temp= arr[i];
            int j=i-1;
            while(j>=0 && temp<=arr[j]){
                arr[j+1]= arr[j];
                j--;
            }
            arr[j+1]= temp;
        }
    }

    public static void printArray(int[] arr){
        for(int i:arr){
            System.out.print(i +" ");
        }
    }
    public static void main(String[] args) {
        Scanner input= new Scanner(System.in);
        int n= input.nextInt();
        int[] arr= new int[n];
        for(int i=0;i<n;i++){
            arr[i]=input.nextInt();
        }
        insert(arr);
        printArray(arr);
    }
}
