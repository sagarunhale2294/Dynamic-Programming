package graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BreadthFirstSearch {

    public static void main(String[] args) {
     List<List<Integer>> adjList = new ArrayList<>();
     for (int i = 0; i < 5; i++)
        adjList.add(new ArrayList<Integer>());
     addEdge(adjList,0,2);
     addEdge(adjList,0,1);
     addEdge(adjList,2,3);
     addEdge(adjList,1,3);
     addEdge(adjList,1,4);
     addEdge(adjList,3,4);
     findBFS(adjList, 5, 0);
     printGraph(adjList);
    }

    private static void findBFS(List<List<Integer>> adjList, int vertex, int source) {
        char visited[] = {'F','F','F','F','F'};
        Queue<Integer> queue = new LinkedList<>();
        queue.add(source);
        visited[source] = 'T';
        while(!queue.isEmpty()) {
            int currentElement = queue.peek();
            System.out.print(currentElement + " ");
            queue.poll();
            for(int adjElement:adjList.get(currentElement)) {
                if(visited[adjElement] == 'F') {
                    visited[adjElement] = 'T';
                    queue.add(adjElement);
                }
            }
        }
        System.out.println();
    }

    private static void printGraph(List<List<Integer>> graph) {
        System.out.println(graph);
    }

    public static void addEdge(List<List<Integer>> adj, int u, int v) {
        adj.get(u).add(v);
        adj.get(v).add(u);
    }  
}
