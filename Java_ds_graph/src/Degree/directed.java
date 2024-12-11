package Degree;


	public class directed {
	    private int[][] adjacencyMatrix;
	    private int vertices;

	    // Constructor
	    public directed(int vertices) {
	        this.vertices = vertices;
	        adjacencyMatrix = new int[vertices][vertices];
	    }

	    // Add an edge to the graph
	    public void addEdge(int source, int destination) {
	        adjacencyMatrix[source][destination] = 1;
	    }

	    // Calculate In-Degree of a vertex
	    public int getInDegree(int vertex) {
	        int inDegree = 0;
	        for (int i = 0; i < vertices; i++) {
	            if (adjacencyMatrix[i][vertex] == 1) {
	                inDegree++;
	            }
	        }
	        return inDegree;
	    }

	    // Calculate Out-Degree of a vertex
	    public int getOutDegree(int vertex) {
	        int outDegree = 0;
	        for (int i = 0; i < vertices; i++) {
	            if (adjacencyMatrix[vertex][i] == 1) {
	                outDegree++;
	            }
	        }
	        return outDegree;
	    }

	    public static void main(String[] args) {
	    	directed graph = new directed(4);

	        graph.addEdge(0, 1);
	        graph.addEdge(0, 2);
	        graph.addEdge(1, 2);
	        graph.addEdge(2, 3);

	        for (int i = 0; i < 4; i++) {
	            System.out.println("Vertex " + i + " - In-Degree: " + graph.getInDegree(i) + ", Out-Degree: " + graph.getOutDegree(i));
	        }
	    }
	}

