package ADI.Graph;
import java.util.*;

public class BFS {

    static int v;
    static ArrayList<Integer> al[];
    BFS(int v){
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
        boolean[] visited= new boolean[v];
        BFS g= new BFS(v);

        for(int i=0;i<e;i++){
            int src= input.nextInt();
            int des= input.nextInt();
            addEdge(src,des);
        }

    }

    static void addEdge(int src, int des){

    }

}
