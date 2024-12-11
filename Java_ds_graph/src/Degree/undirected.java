package Degree;

public class undirected {
    private int[][] adjacencyMatrix;
    private int vertices;

    // Constructor
    public undirected(int vertices) {
        this.vertices = vertices;
        adjacencyMatrix = new int[vertices][vertices];
    }

    // Add an edge to the graph
    public void addEdge(int source, int destination) {
        adjacencyMatrix[source][destination] = 1;
        adjacencyMatrix[destination][source] = 1; // Since it's an undirected graph
    }

    // Calculate Degree of a vertex
    public int getDegree(int vertex) {
        int degree = 0;
        for (int i = 0; i < vertices; i++) {
            if (adjacencyMatrix[vertex][i] == 1) {
                degree++;
            }
        }
        return degree;
    }

    public static void main(String[] args) {
    	undirected graph = new undirected(4);

        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 2);
        graph.addEdge(2, 3);

        for (int i = 0; i < 4; i++) {
            System.out.println("Vertex " + i + " - Degree: " + graph.getDegree(i));
        }
    }
}

