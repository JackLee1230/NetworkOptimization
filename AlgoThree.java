package networkOptimization;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.Stack;
import java.util.Queue;
/**
 * Created by jinli on 4/3/17.
 */
public class AlgoThree {
    private static int[] dad;
    private static int[] rank;

    private static int[] color;
    private static int[] BFS;
    private static int[] bw;

    private static int BLACK = 2;
    private static int GREY = 1;
    private static int WHITE = 0;

    public static int find(int vertex) {
        int v = vertex;
        while (dad[v] != v) {
            v = dad[v];
        }
        return v;
    }

    public static void union(int r1, int r2) {
        if (rank[r1] > rank[r2]) {
            dad[r2] = r1;
        } else if (rank[r1] < rank[r2]) {
            dad[r1] = r2;
        } else {
            dad[r1] = r2;
            rank[r1]++;
        }
    }

    public static int maxBandwidth(Graph g, int s, int t) throws Exception{
        dad = new int[g.vertices()+1];
        rank = new int[g.vertices()+1];
        for (int i = 1; i <= g.vertices(); i++) {
            dad[i] = i;
            rank[i] = 1;
        }
        Graph g1 = new Graph(g.vertices());

//		heap sort the edges increasingly
        List<Edge> temp = new ArrayList<Edge>();
        for(int v = 1; v <= g.vertices(); v++){
            ArrayList<Edge> adjToV = g.getAdj()[v];
            for(Edge e: adjToV){
                int w = e.getAnotherVertex(v);
                if(w > v){
                    temp.add(e);
                }

            }
        }
        Set<Edge> hs = new HashSet<Edge>();
        hs.addAll(temp);
        Edge[] edges = hs.toArray(new Edge[hs.size()]);


        HeapSort a = new HeapSort();
        Edge[] sorted_edges = a.sort(edges);

        for(int i = g.edge()-1; i >= 0; i --){
            Edge edge = sorted_edges[i];
            int U = edge.getA();
            int V = edge.getB();
            int R1 = find(U);
            int R2 = find(V);
            if (R1 != R2) {
                g1.addEdge(edge.getA(), edge.getB(), edge.getWt());
                union(R1, R2);
            }

        }
        color = new int[g1.vertices()+1];
        BFS = new int[g1.vertices()+1];
        bw = new int[g1.vertices()+1];
        for (int v = 1; v <= g1.vertices(); v++) {
            color[v] = WHITE;
            BFS[v] = -1;
            bw[v] = Integer.MAX_VALUE;
        }
        color[s] = GREY;
        dad[s] = -1;
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(s);

        while (color[t] != BLACK && !queue.isEmpty()) {
            int u = queue.poll();
            ArrayList<Edge> uEdgeList = g1.getAdj()[u];
            for (Edge edge : uEdgeList) {
                int v = edge.getAnotherVertex(u);
                if (color[v] == WHITE) {
                    color[v] = GREY;
                    bw[v] = Math.min(bw[u], edge.getWt());
                    BFS[v] = u;
                    queue.offer(v);
                } else if (color[v] == GREY && bw[v] < Math.min(bw[u], edge.getWt())) {
                    BFS[v] = u;
                    bw[v] = Math.min(bw[u], edge.getWt());
                }
            }
            color[u] = BLACK;
        }
        return bw[t];



    }


}
