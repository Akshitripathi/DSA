package Sorting;

import java.util.Scanner;

public class MergeSort {

    public static void merge(int[] a, int beg, int mid, int end){
        int n1= mid-beg+1;
        int n2= end-mid;
        int[] leftArray= new int[n1];
        int[] rightArray= new int[n2];
        for(int i=0;i<n1;i++)
            leftArray[i]= a[beg+i];
        for(int j=0;j<n2;j++)
            rightArray[j]=a[mid+1+j];
        int i=0;
        int j=0;
        int k=beg;
        while(i<n1 && j<n2){
            if(leftArray[i]<=rightArray[j]){
                a[k]= leftArray[i];
                i++;
            }else{
                a[k]= rightArray[j];
                j++;
            }
            k++;
        }
        while(i<n1){
            a[k]= leftArray[i];
            i++;
            k++;
        }
        while(j<n2){
            a[k]= rightArray[j];
            j++;
            k++;
        }
    }

    public static void mergeSort(int[] a, int beg, int end){
        if(beg<end){
            int mid= beg+ (end-beg)/2;
            mergeSort(a,beg,mid);
            mergeSort(a,mid+1,end);
            merge(a, beg, mid, end);
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
        int[] a= new int[n];
        for(int i=0;i<n;i++){
            a[i]=input.nextInt();
        }
        int beg= 0, end= n-1;
        mergeSort(a,beg,end);
        printArray(a);
    }
}
