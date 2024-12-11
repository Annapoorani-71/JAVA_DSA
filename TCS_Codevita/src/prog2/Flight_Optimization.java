package prog2;

import java.util.*;

class Flight {
    String from;
    String to;
    int takeOff;
    int landing;
    int cost;

    Flight(String from, String to, String takeOff, String landing, int cost) {
        this.from = from;
        this.to = to;
        this.takeOff = convertToMinutes(takeOff);
        this.landing = convertToMinutes(landing);
        this.cost = cost;
    }

    private int convertToMinutes(String time) {
        int hours = Integer.parseInt(time.substring(0, 2));
        int minutes = Integer.parseInt(time.substring(3, 5));
        if (time.endsWith("PM") && hours != 12) hours += 12;
        if (time.endsWith("AM") && hours == 12) hours = 0;
        return hours * 60 + minutes;
    }
}

// A custom class to store the state of a city during the priority queue processing
class State {
    int time;   // The current time
    int cost;   // The accumulated cost to reach the city
    String city; // The current city

    State(int time, int cost, String city) {
        this.time = time;
        this.cost = cost;
        this.city = city;
    }
}

public class Flight_Optimization {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        scanner.nextLine(); // Consume the remaining newline character
    
        Map<String, List<Flight>> graph = new HashMap<>();
    
        for (int i = 0; i < N; i++) {
            String inp[]=scanner.nextLine().split(" "); 
            String from = inp[0];  // Read departure city
            String to = inp[1];    // Read destination city
            String takeOff = inp[2].toUpperCase();  // Read departure time (12-hour format)
            String landing = inp[3].toUpperCase();  // Read landing time (12-hour format)
            int cost = Integer.parseInt(inp[4]);  // Read the cost
    
            graph.computeIfAbsent(from, k -> new ArrayList<>()).add(new Flight(from, to, takeOff, landing, cost));
        }
    
        String pref[]=scanner.nextLine().split(" "); 
        // Read the preferred start and end times
        String startCity = pref[0];  // Read start city
        String endCity = pref[1];    // Read end city
        String preferredStart = pref[2];  // Read preferred start time
        String preferredEnd = pref[3];    // Read preferred end time
        scanner.close();
    
        int preferredStartTime = convertToMinutes(preferredStart);
        int preferredEndTime = convertToMinutes(preferredEnd);
    
        int result = findMinimumCost(graph, startCity, endCity, preferredStartTime, preferredEndTime);
        if (result == Integer.MAX_VALUE) {
            System.out.println("Impossible");
        } else {
            System.out.println(result);
        }
    }
    
    private static int findMinimumCost(Map<String, List<Flight>> graph, String start, String end, int preferredStart, int preferredEnd) {
        // Priority queue for Dijkstra's algorithm
        PriorityQueue<State> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a.cost)); // Sort by cost
        pq.offer(new State(preferredStart, 0, start)); // [time, current city, cost]
        
        Map<String, Integer> minCost = new HashMap<>();
        minCost.put(start, 0);

        while (!pq.isEmpty()) {
            State current = pq.poll();
            int currentTime = current.time;
            int currentCost = current.cost;
            String city = current.city;
            if (city.equals(end) && currentTime <= preferredEnd) {
                return currentCost;
            }
            if (graph.containsKey(city)) {
                for (Flight flight : graph.get(city)) {
                    if (flight.takeOff >= currentTime && flight.takeOff >= preferredStart && flight.landing <= preferredEnd) {
                        int newCost = currentCost + flight.cost;
                        if (newCost < minCost.getOrDefault(flight.to, Integer.MAX_VALUE)) {
                            minCost.put(flight.to, newCost);
                            pq.offer(new State(flight.landing, newCost, flight.to)); // [landing time, new cost, city]
                        }
                    }
                }
            }
        }

        return Integer.MAX_VALUE; // Return "Impossible" if no valid path is found
    }

    private static int convertToMinutes(String time) {
        int hours = Integer.parseInt(time.substring(0, 2));
        int minutes = Integer.parseInt(time.substring(3, 5));
        if (time.endsWith("PM") && hours != 12) hours += 12;
        if (time.endsWith("AM") && hours == 12) hours = 0;
        return hours * 60 + minutes;
    }
}