package Adjacency_Matrix;

import java.util.*;

class Graph {
    private int[][] adjacencyMatrix;
    private int vertices;

    public Graph(int initialCapacity) {
        this.vertices = initialCapacity;
        adjacencyMatrix = new int[vertices][vertices];
    }

    // Add a vertex to the graph
    public void addVertex() {
        int newSize = vertices + 1;
        int[][] newMatrix = new int[newSize][newSize];

        // Copy old matrix to new matrix
        for (int i = 0; i < vertices; i++) {
            for (int j = 0; j < vertices; j++) {
                newMatrix[i][j] = adjacencyMatrix[i][j];
            }
        }

        adjacencyMatrix = newMatrix;
        vertices = newSize;
        System.out.println("Vertex " + (vertices - 1) + " added.");
    }

    // Remove a vertex from the graph
    public void removeVertex(int vertex) {
        if (vertex >= vertices || vertex < 0) {
            System.out.println("Vertex " + vertex + " does not exist.");
            return;
        }

        int newSize = vertices - 1;
        int[][] newMatrix = new int[newSize][newSize];

        for (int i = 0, newI = 0; i < vertices; i++) {
            if (i == vertex) continue;
            for (int j = 0, newJ = 0; j < vertices; j++) {
                if (j == vertex) continue;
                newMatrix[newI][newJ++] = adjacencyMatrix[i][j];
            }
            newI++;
        }

        adjacencyMatrix = newMatrix;
        vertices = newSize;
        System.out.println("Vertex " + vertex + " removed.");
    }

    // Add an edge between two vertices
    public void addEdge(int source, int destination) {
        if (source >= vertices || destination >= vertices || source < 0 || destination < 0) {
            System.out.println("Invalid vertices.");
            return;
        }
        adjacencyMatrix[source][destination] = 1;
        adjacencyMatrix[destination][source] = 1; // Comment this line for directed graph
        System.out.println("Edge added between " + source + " and " + destination + ".");
    }

    // Remove an edge between two vertices
    public void removeEdge(int source, int destination) {
        if (source >= vertices || destination >= vertices || source < 0 || destination < 0) {
            System.out.println("Invalid vertices.");
            return;
        }
        adjacencyMatrix[source][destination] = 0;
        adjacencyMatrix[destination][source] = 0; // Comment this line for directed graph
        System.out.println("Edge removed between " + source + " and " + destination + ".");
    }

    // Check if the graph contains a vertex
    public boolean containsVertex(int vertex) {
        return vertex >= 0 && vertex < vertices;
    }

    // Check if the graph contains an edge
    public boolean containsEdge(int source, int destination) {
        return source >= 0 && destination >= 0 && source < vertices && destination < vertices
               && adjacencyMatrix[source][destination] == 1;
    }

    // Find the path from one vertex to another using BFS
    public List<Integer> findPath(int start, int end) {
        if (!containsVertex(start) || !containsVertex(end)) {
            System.out.println("One or both vertices not found.");
            return null;
        }

        boolean[] visited = new boolean[vertices];
        int[] parent = new int[vertices];
        Arrays.fill(parent, -1);
        Queue<Integer> queue = new LinkedList<>();
        List<Integer> path = new ArrayList<>();

        visited[start] = true;
        queue.add(start);

        while (!queue.isEmpty()) {
            int current = queue.poll();

            if (current == end) {
                // Reconstruct the path from end to start
                for (int at = end; at != -1; at = parent[at]) {
                    path.add(at);
                }
                Collections.reverse(path);
                return path;
            }

            for (int i = 0; i < vertices; i++) {
                if (adjacencyMatrix[current][i] == 1 && !visited[i]) {
                    visited[i] = true;
                    parent[i] = current;
                    queue.add(i);
                }
            }
        }
        return null; // No path found
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

    public static void main(String[] args) {
        Graph graph = new Graph(5);

        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 3);
        graph.addEdge(1, 4);
        graph.addEdge(2, 4);

        // Display graph
        System.out.println("Initial graph:");
        graph.displayGraph();

        // Add a vertex
        graph.addVertex();

        // Add edges to the new vertex
        graph.addEdge(5, 2);
        graph.addEdge(5, 3);

        // Display graph after adding new vertex and edges
        System.out.println("\nGraph after adding vertex 5 and new edges:");
        graph.displayGraph();

        // Remove an edge
        graph.removeEdge(1, 4);

        // Remove a vertex
        graph.removeVertex(4);

        // Display graph after modifications
        System.out.println("\nGraph after removing edge and vertex:");
        graph.displayGraph();

        // Check if vertex and edge exist
        System.out.println("\nContains vertex 3: " + graph.containsVertex(3));
        System.out.println("Contains vertex 4: " + graph.containsVertex(4));
        System.out.println("Contains edge between 1 and 3: " + graph.containsEdge(1, 3));
        System.out.println("Contains edge between 1 and 4: " + graph.containsEdge(1, 4));

        // Find path from 0 to 5
        System.out.println("\nPath from 0 to 5: " + graph.findPath(0, 5));
    }
}

