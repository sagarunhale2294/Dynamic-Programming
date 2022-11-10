package graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BFSOnDiscreteGraph {
    static char visited[] = new char[9];
    
    public static void main(String[] args) {
        int vertex = 9;
        List<List<Integer>> adjList = new ArrayList<>();
        for(int i=0; i<vertex; i++) {
            adjList.add(new ArrayList<>());
        }
        for(int i=0; i<vertex; i++) {
            visited[i] = 'F';
        }
        addEdge(adjList, 0, 1);
        addEdge(adjList, 0, 2);
        addEdge(adjList, 1, 3);
        addEdge(adjList, 2, 3);
        addEdge(adjList, 4, 5);
        addEdge(adjList, 5, 6);
        addEdge(adjList, 8, 7);
        printList(adjList);
        for (int i=0; i<vertex; i++) {
            if(visited[i] == 'F') {
                printBFS(adjList, i, vertex);
            }
        }
        System.out.println();
    }

    private static void printBFS(List<List<Integer>> adjList, int source, int vertex) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(source);
        visited[source] = 'T';
        while(!queue.isEmpty()) {
            int u = queue.peek();
            System.out.print(u + " ");
            queue.poll();
            for(int i: adjList.get(u)) {
                if(visited[i] == 'F') {
                    visited[i] = 'T';
                    queue.add(i);
                }
            }
        }
    }

    private static void printList(List<List<Integer>> adjList) {
        System.out.println(adjList);
    }

    private static void addEdge(List<List<Integer>> adjList, int i, int j) {
        adjList.get(i).add(j);
        adjList.get(j).add(i);
    }
    
}
