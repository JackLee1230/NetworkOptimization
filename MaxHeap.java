package networkOptimization;

import java.util.ArrayList;
/**
 * Created by jinli on 4/2/17.
 */
public class MaxHeap {
    private static int[] vertices;
    private static int[] values;
    private static int heapSize;

    public MaxHeap(int x){
        vertices = new int[x+1];
        values = new int[x+1];
        heapSize = 0;

    }

    public static int maximum(){
        return vertices[1];
    }

    public static void insert(int vertex, int value){
        heapSize++;
        vertices[heapSize] = vertex;
        values[heapSize] = value;
        heapfy(heapSize);
    }

    public static void delete(int vertex){
        vertices[vertex] = vertices[heapSize];
        values[vertex] = values[heapSize];
        heapSize--;
        heapfy(vertex);
    }

    public static void heapfy(int k){
        int father = k/2;
        int lson = 2*k;
        int rson = 2*k+1;
        int largest = k;
        if(k>1 && values[father] < values[k]){
            largest = father;
        }
        if(lson<= heapSize && values[lson]> values[k]){
            largest = lson;
        }
        if(rson<= heapSize && values[rson]> values[k]){
            largest =rson;
        }
        if(largest != k){
            swap(largest,k);
            heapfy(largest);

        }

    }

    public static void swap(int pos1, int pos2) {
        int tempVertex = vertices[pos1];
        vertices[pos1] = vertices[pos2];
        vertices[pos2] = tempVertex;

        int tempValue = values[pos1];
        values[pos1] = values[pos2];
        values[pos2] = tempValue;
    }

    public static int getHeapSize(){
        return heapSize;
    }

    public static int getIndex(int x){
        return vertices[x];
    }




}
