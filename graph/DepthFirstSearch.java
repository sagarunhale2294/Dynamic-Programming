package graph;

import java.util.ArrayList;
import java.util.List;

public class DepthFirstSearch {
    static boolean visited[] = new boolean[7];
    public static void main(String[] args) {
        int vertex = 7, source = 0;
        List<List<Integer>> adjList = new ArrayList<>();
        for(int i=0; i<vertex; i++) {
            adjList.add(new ArrayList<>());
        }
        addEdge(adjList, 0, 1);
        addEdge(adjList, 0, 2);
        addEdge(adjList, 1, 3);
        addEdge(adjList, 2, 3);
        addEdge(adjList, 4, 5);
        addEdge(adjList, 5, 6);
        printGraph(adjList);
        findDepthFirstSearch(adjList, vertex, source);
    }

    private static void findDepthFirstSearch(List<List<Integer>> adjList, int vertex, int source) {
        
        for (int i=0; i< vertex; i++) {
            visited[i] = false;
        }
        for (int i=0; i<vertex; i++) {
            if(visited[i] == false) {
                findDepthFirstSearchRec(adjList, i, visited);
            }
        }
    }

    private static void findDepthFirstSearchRec(List<List<Integer>> adjList, int source, boolean[] visited) {
        visited[source] = true;
        System.out.print(source+" ");
        for(int elmnt: adjList.get(source)) {
            if(visited[elmnt] == false) {
                findDepthFirstSearchRec(adjList, elmnt, visited);
            }
        }
        
    }

    private static void printGraph(List<List<Integer>> adjList) {
        System.out.println(adjList);
    }

    private static void addEdge(List<List<Integer>> adjList, int i, int j) {
        adjList.get(i).add(j);
        adjList.get(j).add(i);
    }


    
}
