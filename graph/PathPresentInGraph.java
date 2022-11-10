package graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class PathPresentInGraph {
    public static void main(String[] args) {
        int n = 3, source = 0, destination = 2;
        int[][] edges = {{0,1},{1,2},{2,0}};
        System.out.println("Does path exist in graph: " + isValidPath(n, edges, source, destination));
    }

    public static boolean isValidPath(int n, int[][] edges, int source, int destination) {
        List<List<Integer>> adjList = createAdjList(n, edges);
        boolean visited[] = new boolean[n];
        for(int i=0; i<n; i++) {
            visited[i] = false;
        }
        Queue<Integer> queue = new LinkedList<>();
        queue.add(source);
        visited[source] = true;
        while(!queue.isEmpty()) {
            int currentElement = queue.peek();
            queue.poll();
            for(int elmnt: adjList.get(currentElement)) {
                if(visited[elmnt] == false) {
                    queue.add(elmnt);
                    visited[elmnt] = true;
                }
            }
        }
        return visited[destination] == true;
        
    }

    private static List<List<Integer>> createAdjList(int n, int[][] edges) {
        List<List<Integer>> adjList = new ArrayList<>();
        for(int i=0; i<n; i++) {
            adjList.add(new ArrayList<Integer>());
        }
        for(int a[]:edges) {
            adjList.get(a[0]).add(a[1]);
            adjList.get(a[1]).add(a[0]);
        }
        return adjList;
    }
}
