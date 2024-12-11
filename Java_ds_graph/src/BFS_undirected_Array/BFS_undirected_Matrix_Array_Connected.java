package BFS_undirected_Array;
import java.util.*;

class BFS_undirected_Matrix_Array_Connected {

    // BFS from given source s using adjacency matrix
    static void bfs(int[][] adjMatrix, int s) {

        Queue<Integer> q = new LinkedList<>();

        // Initially mark all the vertices as not visited
        boolean[] visited = new boolean[adjMatrix.length];

        // Mark the source node as visited and enqueue it
        visited[s] = true;
        q.add(s);

        // Iterate over the queue
        while (!q.isEmpty()) {

            // Dequeue a vertex and print it
            int curr = q.poll();
            System.out.print(curr + " ");

            // Get all adjacent vertices of the dequeued vertex
            for (int i = 0; i < adjMatrix.length; i++) {
                // If there's an edge and it's not visited yet
                if (adjMatrix[curr][i] == 1 && !visited[i]) {
                    visited[i] = true;
                    q.add(i);
                }
            }
        }
    }

    // Function to add an edge to the graph
    static void addEdge(int[][] adjMatrix, int u, int v) {
        adjMatrix[u][v] = 1;
        adjMatrix[v][u] = 1; // Undirected graph
    }

    public static void main(String[] args) {

        // Number of vertices in the graph
        int V = 6;

        // Adjacency matrix representation of the graph
        int[][] adjMatrix = new int[V][V]; // Initializes to 0 by default

        // Add edges to the graph
        addEdge(adjMatrix, 0, 1);
        addEdge(adjMatrix, 0, 2);
        addEdge(adjMatrix, 1, 3);
        addEdge(adjMatrix, 1, 4);
        addEdge(adjMatrix, 2, 4);
        addEdge(adjMatrix, 3, 4);
        addEdge(adjMatrix, 3, 5);
        addEdge(adjMatrix, 4, 5);

        // Perform BFS traversal starting from vertex 0
        System.out.println("BFS starting from 0:");
        bfs(adjMatrix, 0);
    }
}

