package ADI.Graph;

import java.util.*;

public class CyclicGraph {
    static int v;
    static ArrayList<Integer> al[];

    CyclicGraph(int v){
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
        boolean iscyclic=false;
        CyclicGraph g= new CyclicGraph(v);

        for (int i = 0; i < e; i++) {
            int src= input.nextInt();
            int des= input.nextInt();
            addEdge(src,des);
        }

        for(int i=0;i<v;i++){
            if(!visited[i]){
                iscyclic=isCyclic(i,visited,-1);
            }
        }
        if(iscyclic){
            System.out.println("Cyclic hai");
        }else{
            System.out.println("Cyclic nhi hai");
        }

    }

    static void addEdge(int src, int des){
        al[src].add(des);
        al[des].add(src);
    }

    static boolean isCyclic(int u, boolean[] visited, int parent){
        visited[u]=true;
        Iterator<Integer> i= al[u].listIterator();
        while(i.hasNext()){
            int temp= i.next();
            if(!visited[temp]){
                if (isCyclic(temp,visited,u)){
                    return true;
                }else if( temp!=parent){
                    return true;
                }
            }
        }
        return false;
    }
}
