package Adjacency_List;
import java.util.*;

public class basic_operation {

	

	    private Map<Integer, List<Integer>> adjacencyList;

	    public basic_operation() {
	        adjacencyList = new HashMap<>();
	    }

	    // Add a vertex to the graph
	    public void addVertex(int vertex) {
	        if (!adjacencyList.containsKey(vertex)) {
	            adjacencyList.put(vertex, new ArrayList<>());
	            System.out.println("Vertex " + vertex + " added.");
	        } else {
	            System.out.println("Vertex " + vertex + " already exists.");
	        }
	    }

	    // Remove a vertex from the graph
	    public void removeVertex(int vertex) {
	        if (adjacencyList.containsKey(vertex)) {
	            adjacencyList.remove(vertex);
	            for (List<Integer> neighbors : adjacencyList.values()) {
	                neighbors.remove(Integer.valueOf(vertex));
	            }
	            System.out.println("Vertex " + vertex + " removed.");
	        } else {
	            System.out.println("Vertex " + vertex + " does not exist.");
	        }
	    }

	    // Add an edge between two vertices
	    public void addEdge(int source, int destination) {
	        if (!adjacencyList.containsKey(source) || !adjacencyList.containsKey(destination)) {
	            System.out.println("One or both vertices not found.");
	            return;
	        }
	        adjacencyList.get(source).add(destination);
	        adjacencyList.get(destination).add(source); // Comment this line for directed graph
	        System.out.println("Edge added between " + source + " and " + destination + ".");
	    }

	    // Remove an edge between two vertices
	    public void removeEdge(int source, int destination) {
	        if (!adjacencyList.containsKey(source) || !adjacencyList.containsKey(destination)) {
	            System.out.println("One or both vertices not found.");
	            return;
	        }
	        if (adjacencyList.get(source).remove(Integer.valueOf(destination)) &&
	            adjacencyList.get(destination).remove(Integer.valueOf(source))) { // Comment this line for directed graph
	            System.out.println("Edge removed between " + source + " and " + destination + ".");
	        } else {
	            System.out.println("Edge does not exist.");
	        }
	    }

	    // Check if the graph contains a vertex
	    public boolean containsVertex(int vertex) {
	        return adjacencyList.containsKey(vertex);
	    }

	    // Check if the graph contains an edge
	    public boolean containsEdge(int source, int destination) {
	        return adjacencyList.containsKey(source) && adjacencyList.get(source).contains(destination);
	    }

	    // Find the path from one vertex to another using BFS
	    public List<Integer> findPath(int start, int end) {
	        if (!adjacencyList.containsKey(start) || !adjacencyList.containsKey(end)) {
	            System.out.println("One or both vertices not found.");
	            return null;
	        }

	        Queue<List<Integer>> queue = new LinkedList<>();
	        Set<Integer> visited = new HashSet<>();
	        queue.add(Collections.singletonList(start));
	        visited.add(start);

	        while (!queue.isEmpty()) {
	            List<Integer> path = queue.poll();
	            int lastVertex = path.get(path.size() - 1);

	            if (lastVertex == end) {
	                return path;
	            }

	            for (int neighbor : adjacencyList.get(lastVertex)) {
	                if (!visited.contains(neighbor)) {
	                    visited.add(neighbor);
	                    List<Integer> newPath = new ArrayList<>(path);
	                    newPath.add(neighbor);
	                    queue.add(newPath);
	                }
	            }
	        }
	        return null;
	    }

	    // Display the graph
	    public void displayGraph() {
	        for (Map.Entry<Integer, List<Integer>> entry : adjacencyList.entrySet()) {
	            System.out.println("Vertex " + entry.getKey() + ": " + entry.getValue());
	        }
	    }

	    public static void main(String[] args) {
	    	basic_operation graph = new basic_operation();

	        // Adding vertices
	        graph.addVertex(1);
	        graph.addVertex(2);
	        graph.addVertex(3);
	        graph.addVertex(4);
	        graph.addVertex(5);

	        // Adding edges
	        graph.addEdge(1, 2);
	        graph.addEdge(1, 3);
	        graph.addEdge(2, 4);
	        graph.addEdge(3, 4);
	        graph.addEdge(4, 5);

	        // Display graph
	        System.out.println("\nGraph:");
	        graph.displayGraph();

	        // Check if vertex exists
	        System.out.println("\nContains vertex 3: " + graph.containsVertex(3));
	        System.out.println("Contains vertex 6: " + graph.containsVertex(6));

	        // Check if edge exists
	        System.out.println("Contains edge between 1 and 2: " + graph.containsEdge(1, 2));
	        System.out.println("Contains edge between 1 and 5: " + graph.containsEdge(1, 5));

	        // Find path from 1 to 5
	        System.out.println("\nPath from 1 to 5: " + graph.findPath(1, 5));

	        // Remove an edge
	        graph.removeEdge(1, 2);

	        // Remove a vertex
	        graph.removeVertex(3);

	        // Display graph after modifications
	        System.out.println("\nGraph after modifications:");
	        graph.displayGraph();
	    }
	}


