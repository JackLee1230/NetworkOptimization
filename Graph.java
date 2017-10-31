package networkOptimization;

import java.util.ArrayList;
/**
 * Created by jinli on 4/2/17.
 */
public class Graph {
    int vertices;
    int edge;
    ArrayList<Edge>[] adj;

    public Graph(int vertices){
        this.vertices = vertices;
        this.edge = 0;
        adj = (ArrayList<Edge>[])new ArrayList[vertices+1];
        for (int i = 1; i <= vertices; i++){
            adj[i] = new ArrayList<Edge>();

        }

    }

    public ArrayList<Edge>[] getAdj(){
        return adj;
    }

    public void setAdj(ArrayList<Edge>[] adj){
        this.adj = adj;

    }

    public Iterable<Edge> adj (int x){
        return adj[x];
    }

    public void addEdge(int a, int b, int wt){
        Edge e = new Edge(a,b,wt);
        if (!this.adj[a].contains(e)){
            this.adj[a].add(e);
            this.adj[b].add(e);
            edge++;
        }
    }

    public int vertices(){
        return vertices;
    }

    public int edge(){
        return edge;
    }
}
