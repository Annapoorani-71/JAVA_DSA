package Adjacency_Matrix;

import java.util.LinkedList;
import java.util.Queue;

class DirectedGraph {

    private int vertices; // Number of vertices
    private int[][] adjacencyMatrix; // Adjacency matrix

    // Constructor
    public DirectedGraph(int vertices) {
        this.vertices = vertices;
        adjacencyMatrix = new int[vertices][vertices];
    }

    // Add an edge to the directed graph
    public void addEdge(int source, int destination) {
        adjacencyMatrix[source][destination] = 1;
    }

    // Display the graph
    public void displayGraph() {
        System.out.println("Adjacency Matrix:");
        for (int i = 0; i < vertices; i++) {
            for (int j = 0; j < vertices; j++) {
                System.out.print(adjacencyMatrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    // Depth First Search (DFS)
    public void dfs(int start) {
        boolean[] visited = new boolean[vertices];
        dfsUtil(start, visited);
    }

    // DFS utility function
    private void dfsUtil(int vertex, boolean[] visited) {
        visited[vertex] = true;
        System.out.print(vertex + " ");

        for (int i = 0; i < vertices; i++) {
            if (adjacencyMatrix[vertex][i] == 1 && !visited[i]) {
                dfsUtil(i, visited);
            }
        }
    }

    // Breadth First Search (BFS)
    public void bfs(int start) {
        boolean[] visited = new boolean[vertices];
        Queue<Integer> queue = new LinkedList<>();

        visited[start] = true;
        queue.add(start);

        while (!queue.isEmpty()) {
            int vertex = queue.poll();
            System.out.print(vertex + " ");

            for (int i = 0; i < vertices; i++) {
                if (adjacencyMatrix[vertex][i] == 1 && !visited[i]) {
                    visited[i] = true;
                    queue.add(i);
                }
            }
        }
    }
}

// Testing the Directed Graph
public class directed_bfs_dfs {
    public static void main(String[] args) {
        DirectedGraph graph = new DirectedGraph(5);

        graph.addEdge(0, 1);
        graph.addEdge(0, 4);
        graph.addEdge(1, 2);
        graph.addEdge(1, 3);
        graph.addEdge(1, 4);
        graph.addEdge(2, 3);
        graph.addEdge(3, 4);

        System.out.println("Directed Graph adjacency matrix representation:");
        graph.displayGraph();

        System.out.println("\nDepth First Search starting from vertex 0:");
        graph.dfs(0);

        System.out.println("\n\nBreadth First Search starting from vertex 0:");
        graph.bfs(0);
    }
}
