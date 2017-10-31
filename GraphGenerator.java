package networkOptimization;

import java.util.ArrayList;
import java.util.Random;
/**
 * Created by jinli on 4/2/17.
 */
public class GraphGenerator {
    private static int NumberOfVertices = 5000;
    private static int Degree = 6;
    private static int Percentage = 20;

    public static Graph graphOneGenerator(int numberOfVertices) {
        Graph graph = new Graph(numberOfVertices);
        Random randomGenerator = new Random();
        int[] degree = new int[numberOfVertices + 1];
        for (int i = 1; i <= numberOfVertices; i++) {
            degree[i] = 0;

        }

        int numberOfEdge = 0;
        while (numberOfEdge < (NumberOfVertices * Degree) / 2) {
            int i = randomGenerator.nextInt(numberOfVertices) + 1;
            int j = randomGenerator.nextInt(numberOfVertices) + 1;
            int wt = randomGenerator.nextInt(100) + 1;
            if (degree[i] < 6 && degree[j] < 6 && i != j) {
                Edge edge = new Edge(i, j, wt);
                if (!graph.adj[i].contains(edge)) {
                    graph.addEdge(i, j, wt);

                    degree[i]++;
                    degree[j]++;
                    numberOfEdge++;
                }

            }
        }
        System.out.println("Graph one generated!");
        return graph;
    }

    public static Graph graphTwoGenerator(int numberOfVertices){
        Graph graph = new Graph(numberOfVertices);
        Random randomGenerator = new Random();
        int numberOfEdge = 0;
        for (int i = 1; i<= numberOfVertices; i++){
            for (int j = i+1; j <= numberOfVertices; j++){
                int randomNumber = randomGenerator.nextInt(100) + 1;
                int wt = randomGenerator.nextInt(100) + 1;
                if (randomNumber <= Percentage){
                    graph.addEdge(i,j,wt);
                    numberOfEdge++;
                }
            }
        }
        System.out.println("Graph two generated!");
        System.out.println("It has total\t"+ numberOfEdge + "\t edges");
        return graph;



    }
    public static void main(String[] args){
        Graph graphOne = graphOneGenerator(NumberOfVertices);
        Graph graphTwo = graphTwoGenerator(NumberOfVertices);
    }

}
