package ADI.Graph;

import java.util.*;

public class GraphcreationUsingArraylist {
    static int v;
    static ArrayList<Integer> al[];

    GraphcreationUsingArraylist(int v){
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

        GraphcreationUsingArraylist g= new GraphcreationUsingArraylist(v);

        for (int i = 0; i < e; i++) {
            int src= input.nextInt();
            int des= input.nextInt();
            addEdge(src,des);
        }
        printList();
    }

    static void addEdge(int src, int des){
        al[src].add(des);
        al[des].add(src);
    }
    static void printList(){
        for(int i=0;i<v;i++){
            System.out.print(i+"--->");
            for( int j=0;j<al[i].size();j++){
                System.out.print(al[i].get(j)+" ");
            }
            System.out.println();
        }
    }

}
