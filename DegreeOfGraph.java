package ADI.Graph;

import java.util.*;

public class DegreeOfGraph {
    static int v;
    static ArrayList<Integer> al[];

    DegreeOfGraph(int v){
        this.v= v;
        al= new ArrayList[v];
        for(int i=0;i<v;i++){
            al[i]= new ArrayList<>();
        }
    }

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
        System.out.println("Enter the element: ");
        int ele= input.nextInt();
        for(int i=0;i<v;i++){
            if(i==ele){
                System.out.println(al[i].size());
                for(int j=0;j< al[i].size();j++){
                    System.out.print(al[i].get(j)+" ");
                }
                System.out.println();
            }
        }
    }

    static void addEdge(int[][] matrix, int src, int des){
        matrix[src][des]=1;
        matrix[des][src]=1;
    }

    static int inDegree(int v, int[][] matrix){
        int count=0;
        for(int i=0;i<v;i++){
            if(matrix[v][i] ==1){
                count++;
            }
        }
        return count;
    }
    static int outDegree(int v, int[][] matrix){
        int count=0;
        for(int i=0;i<v;i++){
            if(matrix[i][v] ==1){
                count++;
            }
        }
        return count;
    }

}
