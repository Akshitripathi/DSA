package ADI.Graph;

import java.util.*;
public class DFS {

    static int v;
    static ArrayList<Integer> al[];

    DFS(int v){
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
        boolean[] visited = new boolean[v];
        DFS g= new DFS(v);

        for (int i = 0; i < e; i++) {
            int src= input.nextInt();
            int des= input.nextInt();
            addEdge(src,des);
        }
        DFS(0,visited);
    }

    static void addEdge(int src, int des){
        al[src].add(des);
        al[des].add(src);
    }

    static void DFS(int start,boolean[] visited){
        visited[start]=true;
        System.out.println(start);

        for (int i = 0; i< al[start].size(); i++) {
            int a= al[start].get(i);
            if(!visited[a]){
                DFS(a,visited);

            }
        }
    }
}
