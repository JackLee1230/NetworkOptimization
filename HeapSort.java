package networkOptimization;

import java.util.ArrayList;

/**
 * Created by jinli on 4/3/17.
 */
public class HeapSort {
    public Edge[] sort(Edge[] edges){
        int n = edges.length;
        for (int i = n-1 ; i>=0; i--){
            Heapfy(edges, n, i);
        }
        for(int i = n-1 ; i>=0; i--){
            Edge temp = edges[0];
            edges[0] = edges[i];
            edges[i] = temp;
            Heapfy(edges, i, 0);
        }
        return edges;
    }

    void Heapfy(Edge[] edges, int n, int i){
        int largest = i;
        int lson = 2*i;
        int rson = 2*i + 1;

        if (lson < n && edges[lson].getWt() > edges[largest].getWt()){
            largest = lson;
        }

        if (rson < n && edges[rson].getWt() > edges[largest].getWt()){
            largest = rson;
        }

        if (largest != i){
            Edge temp = edges[i];
            edges[i] = edges[largest];
            edges[largest] =  temp;
            Heapfy(edges,n,largest);
        }
    }
}
