package Adjacency_List;

import java.util.LinkedList;

class DirectedGraph {

    private int vertices; // Number of vertices
    private LinkedList<Integer>[] adjacencyList; // Adjacency list

    // Constructor
    public DirectedGraph(int vertices) {
        this.vertices = vertices;
        adjacencyList = new LinkedList[vertices];
        for (int i = 0; i < vertices; i++) {
            adjacencyList[i] = new LinkedList<>();
        }
    }

    // Add an edge to the directed graph
    public void addEdge(int source, int destination) {
        adjacencyList[source].add(destination);
    }

    // Display the graph
    public void displayGraph() {
        for (int i = 0; i < vertices; i++) {
            System.out.print("Vertex " + i + ": ");
            for (Integer node : adjacencyList[i]) {
                System.out.print(node + " ");
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

        for (int adj : adjacencyList[vertex]) {
            if (!visited[adj]) {
                dfsUtil(adj, visited);
            }
        }
    }

    // Breadth First Search (BFS)
    public void bfs(int start) {
        boolean[] visited = new boolean[vertices];
        LinkedList<Integer> queue = new LinkedList<>();

        visited[start] = true;
        queue.add(start);

        while (!queue.isEmpty()) {
            int vertex = queue.poll();
            System.out.print(vertex + " ");

            for (int adj : adjacencyList[vertex]) {
                if (!visited[adj]) {
                    visited[adj] = true;
                    queue.add(adj);
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

        System.out.println("Directed Graph adjacency list representation:");
        graph.displayGraph();

        System.out.println("\nDepth First Search starting from vertex 0:");
        graph.dfs(0);

        System.out.println("\n\nBreadth First Search starting from vertex 0:");
        graph.bfs(0);
    }
}
