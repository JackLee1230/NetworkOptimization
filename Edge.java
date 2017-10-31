package networkOptimization;

/**
 * Created by jinli on 4/2/17.
 */
public class Edge {
    private int a;
    private int b;
    private int wt;

    public Edge(int a, int b, int wt){
        if (a<0 || a==0) throw new IndexOutOfBoundsException(" Vertex name must be a positive integer ");
        if (b<0 || b==0) throw new IndexOutOfBoundsException(" Vertex name must be a positive integer ");

        this.a = a;
        this.b = b;
        this.wt = wt;
    }

    public int getA(){
        return a;
    }

    public int getB(){
        return b;
    }

    public int getWt(){
        return wt;
    }

    public int getOneVertex(){
        return a;
    }

    public int getAnotherVertex(int x){
        if(x == a){
            return b;
        }else if (x == b){
            return a;
        }else throw new IllegalArgumentException("Illegal point");

    }






}
