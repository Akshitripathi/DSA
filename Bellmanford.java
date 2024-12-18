package ADI.Graph;
import java.util.*;
//public class Bellmanford {
//    static int[] bellmanford(int v, int edges[][], int src){
//        int dist[]= new int[v];
//        Arrays.fill(dist,(int)1e8 );
//        dist[src]=0;
//
//        for(int i=0;i<v;i++){
//            for(int edge[]: edges){
//                int v1= edge[0];
//                int v2= edge[1];
//                int w= edge[2];
//
//                if(dist[v1]!= (int)1e8 && dist[v1]+w<dist[v2]){
////                    if(i==v-1){
////                        return new int[] {-1};
////                    }
//                    dist[v2]= dist[v1]+w;
//                }
//            }
//        }
//        return dist;
//    }
//
//    public static void main(String[] args) {
//        int V=5;
//        int[][] edges = {{1,3,2},
//                {4,3,-1},
//                {2,4,1},
//                {1,2,1},
//                {0,1,5}};
//
//        int src = 0;
//        int res[] = bellmanford(V, edges, src);
//        for(int i: res){
//            System.out.println(i);
//        }
//    }
//}


public class Bellmanford{
    static int v;
    static ArrayList<ArrayList<Pair>> al;
    Bellmanford(int v){
        this.v=v;
        al= new ArrayList<>(v);
        for(int i=0;i<v;i++){
            al.add(new ArrayList<Pair>());
        }
    }

    static class Pair{
        int first, second;
        Pair(int v2, int w){
            this.first=v2;
            this.second= w;
        }
    }


    static int[] findPath(int v, ArrayList<ArrayList<Pair>> al, int src){
        int[] dist= new int[v];
        Arrays.fill(dist, (int)1e8);
        dist[src]=0;
        for (int i = 0; i < v; i++) {
            for(Pair a: al.get(i)){
                int v1=i;
                int v2= a.first;
                int w= a.second;
                if(dist[v1] != (int)1e8 && dist[v1]+w<dist[v2]){
                    if(i==v-1){
                        return new int[]{-1};
                    }
                    dist[v2]= dist[v1]+w;
                }
            }
        }
        return dist;
    }

    public static void main(String[] args) {
        Scanner input= new Scanner(System.in);
        int v= input.nextInt();
        int e= input.nextInt();
        Bellmanford g= new Bellmanford(v);
        for(int i=0;i<e;i++){
            int src= input.nextInt();
            int des= input.nextInt();
            int w= input.nextInt();
            addEdge(src,des,w);
        }
        int[] ans= findPath(v,al,0);
        for(int i=0;i<v;i++){
            System.out.println(ans[i]);
        }
    }
    static void addEdge(int src, int des, int w){
        al.get(src).add(new Pair(des,w));
    }
}