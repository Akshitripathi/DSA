package ADI.Graph;

import java.util.*;
public class TransposeUsingArrayList {
    static int v;
    static ArrayList<Integer> al[];

    TransposeUsingArrayList(int v){
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

        TransposeUsingArrayList g= new TransposeUsingArrayList(v);

        for (int i = 0; i < e; i++) {
            int src= input.nextInt();
            int des= input.nextInt();
            addEdge(src,des);
        }
        ArrayList<Integer> ans[] = new ArrayList[v];
        for (int i = 0; i < v; i++) {
            ans[i] = new ArrayList<>();
        }
        transpose(al,ans);
    }

    static void addEdge(int src, int des){
        al[src].add(des);
//        al[des].add(src);
    }

    static void transpose(ArrayList<Integer> al[], ArrayList<Integer> ans[]){
        for(int i=0;i<al.length;i++){
            for(int x:al[i]){
                ans[x].add(i);
            }
        }
        printList(ans);
    }
    static void printList(ArrayList<Integer> ans[]){
        for(int i=0;i<v;i++){
            System.out.print(i+"--->");
            for( int j=0;j<ans[i].size();j++){
                System.out.print(ans[i].get(j)+" ");
            }
            System.out.println();
        }
    }
}
