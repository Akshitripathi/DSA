package ADI.Graph;
import java.util.*;

//public class ShortestPath {
//    static int v;
//    static ArrayList<ArrayList<Pair>> al;
//
//    ShortestPath(int v) {
//        this.v = v;
//        al = new ArrayList<>();
//        for (int i = 0; i < v; i++) {
//            al.add(new ArrayList<>());
//        }
//    }
//
//    static class Pair {
//        int first, second; // first is the destination, second is the weight
//        Pair(int des, int w) {
//            first = des;
//            second = w;
//        }
//    }
//
//    public static void main(String[] args) {
//        Scanner input = new Scanner(System.in);
//        int v = input.nextInt();
//        int e = input.nextInt();
//
//        ShortestPath g = new ShortestPath(v);
//
//        for (int i = 0; i < e; i++) {
//            int src = input.nextInt();
//            int des = input.nextInt();
//            int w = input.nextInt();
//            addEdge(src, des, w);
//        }
//
//        // Start Dijkstra's algorithm from source node 0
//        shortestPath(0);
//    }
//
//    static void shortestPath(int src) {
//        PriorityQueue<Pair> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o.first));
//        int dist[] = new int[v];
//        Arrays.fill(dist, Integer.MAX_VALUE);
//        pq.add(new Pair(src, 0));
//        dist[src] = 0;
//
//        while (!pq.isEmpty()) {
//            int temp = pq.poll().first;
//            for (Pair a : al.get(temp)) {
//                if (dist[a.first] > dist[temp] + a.second) {
//                    dist[a.first] = dist[temp] + a.second;
//                    pq.add(new Pair(a.first, dist[a.first]));
//                }
//            }
//        }
//        for (int i = 1; i < v; i++) { // Start from 1 to match your output format
//            if (dist[i] == Integer.MAX_VALUE) {
//                System.out.println("Shortest path from " + src + " to " + i + " - Infinity");
//            } else {
//                System.out.println("Shortest path from " + src + " to " + i + " - " + dist[i]);
//            }
//        }
//    }
//
//    static void addEdge(int src, int des, int w) {
//        al.get(src).add(new Pair(des, w));
//        al.get(des).add(new Pair(src, w)); // Uncomment this line if your graph is undirected
//    }
//}


public class ShortestPath{
    static int v;
    static ArrayList<ArrayList<Pair>> al;

    static class Pair{
        int first, second;
        Pair(int v, int w){
            first=v;
            second=w;
        }
    }
    ShortestPath(int v){
        this.v=v;
        al= new ArrayList<>(v);
        for(int i=0;i<v;i++){
            al.add(new ArrayList<>());
        }
    }

    public static void main(String[] args) {
        Scanner input= new Scanner(System.in);
        int v= input.nextInt();
        int e= input.nextInt();
        ShortestPath g= new ShortestPath(v);
        for(int i=0;i<e;i++){
            int src= input.nextInt();
            int des= input.nextInt();
            int w= input.nextInt();
            addEdge(src,des,w);
        }
        shortestPath(0);
    }

    static void addEdge(int src, int des, int w){
        al.get(src).add(new Pair(des,w));
        al.get(des).add(new Pair(src,w));
    }

    static void shortestPath(int src){
        PriorityQueue<Pair> pq= new PriorityQueue<>(Comparator.comparingInt(o->o.first));
        int[] dist= new int[v];
        Arrays.fill(dist, Integer.MAX_VALUE);
        pq.add(new Pair(src,0));
        dist[src]=0;
        while(!pq.isEmpty()){
            int temp= pq.poll().first;
            for(Pair a: al.get(temp)){
                if(dist[a.first]> dist[temp]+a.second){
                    dist[a.first]= dist[temp]+a.second;
                    pq.add(new Pair(a.first, dist[a.first]));
                }
            }
        }

        for(int i=1;i<v;i++){
            if(dist[i]== Integer.MAX_VALUE){
                System.out.println(src+" --> "+i+" = Infinity");
            }else{
                System.out.println(src+" --> "+i+" = "+ dist[i]);
            }
        }

    }
}










