package graph;

import java.util.ArrayList;
import java.util.List;

public class GraphInsert {
    public static void main(String[] args) {
        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0; i<5; i++) {
            adj.add(new ArrayList<>());
        }
        addEdge(adj, 0, 1);
        addEdge(adj, 0, 2);
        addEdge(adj, 2, 3);
        addEdge(adj, 1, 3);
        addEdge(adj, 1, 4);
        addEdge(adj, 3, 4);
        printGraph(adj);
        
    }

    private static void printGraph(List<List<Integer>> adj) {
        System.out.println(adj);
    }

    private static void addEdge(List<List<Integer>> adj, int i, int j) {
        adj.get(i).add(j);
        adj.get(j).add(i);
    }
    
}
