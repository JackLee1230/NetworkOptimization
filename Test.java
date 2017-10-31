package networkOptimization;

import java.util.Random;
/**
 * Created by jinli on 4/3/17.
 */
public class Test {
    private static int NumberOfVertices = 5000;
    private static int NumberOfPairs = 5;

    public static void main(String[] args)throws Exception{



            System.out.println("Test Case for Graph one " );
            long startTime1 = System.currentTimeMillis();
            Graph graph1 = GraphGenerator.graphOneGenerator(NumberOfVertices);
            long graphGeneratedTime1 = System.currentTimeMillis();
            System.out.println("The first graph generation time: " + (graphGeneratedTime1 - startTime1));
            System.out.println(" ");
            for (int j = 1; j <= NumberOfPairs; j++) {
                System.out.println("Test Case for Pair: " + j);

                long startTimeNew = System.currentTimeMillis();
                Random randomGenerator = new Random();
                int source = randomGenerator.nextInt(NumberOfVertices)+1;
                int destination = -1;
                while (true) {
                    destination = randomGenerator.nextInt(NumberOfVertices)+1;
                    if (source != destination) break;
                }
                System.out.println("Source: " + source + " Destination: " + destination);
                int bw1 = AlgoOne.maxBandwidth(graph1, source, destination);
                System.out.println("The Max Bandwidth: " + bw1 + "\n");
                long maxBandwidthTime1 = System.currentTimeMillis();
                System.out.println("Algorithm 1 execution time: " + (maxBandwidthTime1 - startTimeNew));
                int bw2 = AlgoTwo.maxBandwidth(graph1, source, destination);
                long maxBandwidthTime2 = System.currentTimeMillis();
                System.out.println("Algorithm 2 execution time: " + (maxBandwidthTime2 - maxBandwidthTime1));
                int bw3 = AlgoThree.maxBandwidth(graph1, source, destination);
                long maxBandwidthTime3 = System.currentTimeMillis();
                System.out.println("Algorithm 3 execution time: " + (maxBandwidthTime3 - maxBandwidthTime2));
                System.out.println(" ");
            }
        System.out.println("Test Case for Graph two");



            long startTime2 = System.currentTimeMillis();
            Graph graph2 = GraphGenerator.graphTwoGenerator(NumberOfVertices);
            long graphGeneratedTime2 = System.currentTimeMillis();
            System.out.println("The second graph generation time: " + (graphGeneratedTime2 - startTime2));
            System.out.println(" ");
            for (int j = 1; j <= NumberOfPairs; j++) {
                System.out.println("Test Case for Pair: " + j);

                long startTimeNew = System.currentTimeMillis();
                Random randomGenerator = new Random();
                int source = randomGenerator.nextInt(NumberOfVertices)+1;
                int destination = -1;
                while (true) {
                    destination = randomGenerator.nextInt(NumberOfVertices)+1;
                    if (source != destination) break;
                }
                System.out.println("Source: " + source + " Destination: " + destination);
                int bw1 = AlgoOne.maxBandwidth(graph2, source, destination);
                System.out.println("The Max Bandwidth: " + bw1 + "\n");
                long maxBandwidthTime1 = System.currentTimeMillis();
                System.out.println("Algorithm 1 execution time: " + (maxBandwidthTime1 - startTimeNew));
                int bw2 = AlgoTwo.maxBandwidth(graph2, source, destination);
                long maxBandwidthTime2 = System.currentTimeMillis();
                System.out.println("Algorithm 2 execution time: " + (maxBandwidthTime2 - maxBandwidthTime1));
                int bw3 = AlgoThree.maxBandwidth(graph2, source, destination);
                long maxBandwidthTime3 = System.currentTimeMillis();
                System.out.println("Algorithm 3 execution time: " + (maxBandwidthTime3 - maxBandwidthTime2));
                System.out.println(" ");
            }

    }


}
