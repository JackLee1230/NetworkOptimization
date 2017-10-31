package networkOptimization;

import java.util.ArrayList;
/**
 * Created by jinli on 4/3/17.
 */
public class AlgoTwo {
    public static int[] status;
    public static int[] dad;
    public static int[] bw;
    public static MaxHeap heap;

    public static int INTREE = 2;
    public static int FRINGE = 1;
    public static int UNSEEN = 0;

    public static int maxBandwidth(Graph g, int s, int t) {
        status = new int[g.vertices() + 1];
        dad = new int[g.vertices() + 1];
        bw = new int[g.vertices() + 1];
        heap = new MaxHeap(g.vertices()+1);

        for (int i = 1; i <= g.vertices(); i++) {
            status[i] = UNSEEN;
            bw[i] = Integer.MAX_VALUE;
        }

        status[s] = INTREE;
        dad[s] = -1;

        ArrayList<Edge> adjToS = g.getAdj()[s];
        for (Edge e : adjToS) {
            int w = e.getAnotherVertex(s);
            status[w] = FRINGE;
            dad[w] = s;
            bw[w] = e.getWt();
            heap.insert(w,bw[w]);
        }

        while (status[t] != INTREE){
            int index = heap.maximum();
            status[index] = INTREE;
            heap.delete(1);

            ArrayList<Edge> adjToV = g.getAdj()[index];
            for(Edge e: adjToV){
                int w = e.getAnotherVertex(index);
                if (status[w] == UNSEEN) {
                    dad[w] = index;
                    status[w] = FRINGE;
                    bw[w] = Math.min(bw[index], e.getWt());
                    heap.insert(w,bw[w]);
                } else if(status[w] == FRINGE && bw[w] < Math.min(bw[index], e.getWt())) {
                    dad[w] = index;
                    for(int i =1; i <= heap.getHeapSize(); i++){
                        if (heap.getIndex(i) == w){
                            heap.delete(i);
                        }
                    }
                    bw[w] = Math.min(bw[index], e.getWt());
                    heap.insert(w,bw[w]);
                }
            }

        }
        return bw[t];
    }
}
