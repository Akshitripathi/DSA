package ADI.Graph;

import java.util.*;

public class GraphCreationUsingMatrix {
    public static void main(String[] args) {
        Scanner input= new Scanner(System.in);
        int v= input.nextInt();
        int e= input.nextInt();
        int[][] matrix= new int[v][v];
        for (int i = 0; i < e; i++) {
            int src= input.nextInt();
            int des= input.nextInt();
            addEdge(matrix,src,des);
        }
        printMatrix(matrix);
    }
    static void addEdge(int[][] matrix, int src, int des){
        matrix[src][des]=1;
        matrix[des][src]=1;
    }
    static void printMatrix(int[][] matrix){
        for(int[] x: matrix){
            for(int a: x){
                System.out.print(a+" ");
            }
            System.out.println();
        }
    }
}
