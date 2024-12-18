package ADI.Graph;
import java.util.*;
public class Krushkal {

    static class Edge{
        int src, des, weight;
        Edge(int src, int des, int weight) {
            this.src = src;
            this.des = des;
            this.weight = weight;
        }
    }

     static class subset{
        int parent, rank;
        subset(int parent, int rank){
            this.parent= parent;
            this.rank= rank;
        }
     }

    public static void main(String[] args) {
        int v= 4;
        List<Edge> graph= new ArrayList<Edge>();
        graph.add(new Edge(0,1,10));
        graph.add(new Edge(0,2,6));
        graph.add(new Edge(0,3,5));
        graph.add(new Edge(2,3,4));

        graph.sort(new Comparator<Edge>() {
            @Override
            public int compare(Edge o1, Edge o2) {
                return o1.weight - o2.weight;
            }
        });

        Krushkal(v, graph);
    }

    static void Krushkal(int v, List<Edge> edges){
        int j=0, totalVertex=0;
        subset subsets[]= new subset[v];
        Edge[] res= new Edge[v];

        for (int i = 0; i < v; i++) {
            subsets[i]= new subset(i,0);
        }
        while(totalVertex <v-1) {
            Edge next = edges.get(j);
            int x = findroot(subsets, next.src);
            int y = findroot(subsets, next.des);

            if (x != y) {
                res[totalVertex] = next;
                union(subsets, x, y);
                totalVertex++;
            }
            j++;
        }
        int minCost=0;
        for( int i=0;i<totalVertex;i++){
            System.out.print(res[i].src+"--"+res[i].des+"--"+res[i].weight);
            minCost+=res[i].weight;
            System.out.println();
        }
        System.out.println("Minimum Cost: "+ minCost);
    }

    static int findroot(subset[] subsets, int i){
        if(subsets[i].parent ==i){
            return subsets[i].parent;
        }
        subsets[i].parent= findroot(subsets,subsets[i].parent);
        return subsets[i].parent;
    }

    static void union(subset[] subsets, int x , int y){
        int rootX= findroot(subsets, x);
        int rootY= findroot(subsets, y);

        if(subsets[rootY].rank < subsets[rootX].rank){
            subsets[rootY].parent= rootX;
        }else if(subsets[rootX].rank < subsets[rootY].rank){
            subsets[rootX].parent= rootY;
        }else{
            subsets[rootY].parent= rootX;
            subsets[rootX].rank++;
        }
    }


}
