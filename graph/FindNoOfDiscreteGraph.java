package graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class FindNoOfDiscreteGraph {
    static char visited[] = new char[7];

    public static void main(String[] args) {
        int vertex = 7;
        List<List<Integer>> adjList = new ArrayList<>();
        for(int i=0; i< vertex; i++) {
            adjList.add(new ArrayList<>());
        }
        for(int i=0; i< vertex; i++) {
            visited[i] = 'F';
        }
        addEdge(adjList, 0, 1);
        addEdge(adjList, 0, 2);
        addEdge(adjList, 1, 3);
        addEdge(adjList, 2, 3);
        addEdge(adjList, 4, 5);
        addEdge(adjList, 5, 6);
        printList(adjList);
        int count = 0;
        for(int i=0; i<vertex; i++) {
            if(visited[i] == 'F') {
                count++;
                findBFS(adjList, i, vertex);
            }
        }
        System.out.println("\nNumber of discrete graphs are: " + count);
    }

    private static void findBFS(List<List<Integer>> adjList, int source, int vertex) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(source);
        visited[source] = 'T';
        while(!queue.isEmpty()) {
            int currentElement = queue.peek();
            System.out.print(currentElement + " ");
            queue.poll();
            for(int adjElement: adjList.get(currentElement)) {
                if(visited[adjElement] == 'F') {
                    queue.add(adjElement);
                    visited[adjElement] = 'T';
                }
            }
        }

    }

    private static void addEdge(List<List<Integer>> adjList, int i, int j) {
        adjList.get(i).add(j);
        adjList.get(j).add(i);
    }

    public static void printList(List<List<Integer>> adjList) {
        System.out.println(adjList);
    }

    
}
