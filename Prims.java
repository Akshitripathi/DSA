package ADI.Graph;
import java.util.*;
//public class Prims {
//    public static class Pair implements Comparable<Pair>{
//        int v;
//        int wt;
//        Pair(int v, int wt){
//            this.v=v;
//            this.wt= wt;
//        }
//
//        @Override
//        public int compareTo(Pair temp){
//            return this.wt- temp.wt;
//        }
//    }
//    static int SpanningTree(int[][] graph, int v, int e){
//        ArrayList<ArrayList<Pair>> al= new ArrayList<>();
//        for (int i = 0; i < v; i++) {
//            al.add(new ArrayList<Pair>());
//        }
//        for(int i=0; i<e;i++){
//            int v1= graph[i][0];
//            int v2= graph[i][1];
//            int wt= graph[i][2];
//            al.get(v1).add(new Pair(v2, wt));
//            al.get(v2).add(new Pair(v1, wt));
//
//        }
//
//        PriorityQueue<Pair> pq= new PriorityQueue<>();
//        pq.add(new Pair(0,0));
//        int[] visited= new int[v];
//        int minCost=0;
//        while(!pq.isEmpty()){
//            Pair temp= pq.poll();
//            int va= temp.v;
//            int wt= temp.wt;
//            if(visited[va]==1){
//                continue;
//            }
//            minCost+=wt;
//            visited[va]=1;
//            for(Pair p: al.get(va)){
//                if(visited[p.v]==0){
//                    pq.add(new Pair(p.v, p.wt));
//                }
//            }
//        }
//        return minCost;
//
//
//    }
//
//    public static void main(String[] args) {
//        int v=3;
//        int e= 3;
//        int graph[][]= {{0,1,5},
//                {1,2,3},
//                {0,2,1}};
//        System.out.println(SpanningTree(graph,v,e));
//    }
//}


public class Prims {
    static class Pair implements Comparable<Pair> {
        int v;  // Vertex
        int wt; // Weight of the edge

        Pair(int v, int wt) {
            this.v = v;
            this.wt = wt;
        }

        @Override
        public int compareTo(Pair temp) {
            return this.wt - temp.wt; // Compare based on weight
        }
    }

    static ArrayList<ArrayList<Pair>> adj; // Adjacency list

    static void spanningTree(int v) {
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        pq.add(new Pair(0, 0)); // Start from vertex 0 with weight 0
        int[] visited = new int[v]; // To track visited vertices
        int minCost = 0; // Total cost of MST

        while (!pq.isEmpty()) {
            Pair temp = pq.poll();
            int v1 = temp.v; // Current vertex
            int w = temp.wt; // Weight of the edge

            if (visited[v1] == 1) {
                continue; // Skip if already visited
            }

            minCost += w; // Add weight to total cost
            visited[v1] = 1; // Mark vertex as visited

            for (Pair i : adj.get(v1)) {
                if (visited[i.v] != 1) { // If adjacent vertex is not visited
                    pq.add(new Pair(i.v, i.wt)); // Add it to the priority queue
                }
            }
        }

        System.out.println(minCost); // Print minimum cost of MST
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int v = input.nextInt(); // Number of vertices
        int e = input.nextInt(); // Number of edges

        adj = new ArrayList<>(); // Initialize adjacency list
        for (int i = 0; i < v; i++) {
            adj.add(new ArrayList<Pair>()); // Create a new list for each vertex
        }

        for (int i = 0; i < e; i++) {
            int src = input.nextInt();
            int des = input.nextInt();
            int wt = input.nextInt();
            addEdge(src, des, wt); // Add edges to the graph
        }

        spanningTree(v); // Call function to find MST
    }

    static void addEdge(int src, int des, int wt) {
        adj.get(src).add(new Pair(des, wt)); // Add edge from src to des
        adj.get(des).add(new Pair(src, wt)); // Add edge from des to src (undirected graph)
    }
}