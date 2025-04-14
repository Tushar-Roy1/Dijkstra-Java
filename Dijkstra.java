import java.util.*;

class Node {
    int vertex, weight;

    public Node(int v, int w) {
        this.vertex = v;
        this.weight = w;
    }
}

class Graph {
    private int vertices;
    private List<List<Node>> adjList;

    public Graph(int vertices) {
        this.vertices = vertices;
        adjList = new ArrayList<>();
        for (int i = 0; i < vertices; i++) {
            adjList.add(new ArrayList<>());
        }
    }

    public void addEdge(int source, int destination, int weight) {
        adjList.get(source).add(new Node(destination, weight));
        adjList.get(destination).add(new Node(source, weight)); // remove this line if graph is directed
    }

    public void dijkstra(int start) {
        int[] distance = new int[vertices];
        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[start] = 0;

        PriorityQueue<Node> pq = new PriorityQueue<>(Comparator.comparingInt(n -> n.weight));
        pq.offer(new Node(start, 0));

        while (!pq.isEmpty()) {
            Node current = pq.poll();
            int u = current.vertex;

            for (Node neighbor : adjList.get(u)) {
                int v = neighbor.vertex;
                int weight = neighbor.weight;

                if (distance[u] + weight < distance[v]) {
                    distance[v] = distance[u] + weight;
                    pq.offer(new Node(v, distance[v]));
                }
            }
        }

        System.out.println("Shortest distances from node " + start + ":");
        for (int i = 0; i < vertices; i++) {
            System.out.println("To " + i + " => " + distance[i]);
        }
    }
}

public class DijkstraUserInput {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of vertices: ");
        int V = sc.nextInt();

        System.out.print("Enter number of edges: ");
        int E = sc.nextInt();

        Graph graph = new Graph(V);

        System.out.println("Enter edges (source destination weight):");
        for (int i = 0; i < E; i++) {
            int src = sc.nextInt();
            int dest = sc.nextInt();
            int weight = sc.nextInt();
            graph.addEdge(src, dest, weight);
        }

        System.out.print("Enter starting node for Dijkstra's algorithm: ");
        int start = sc.nextInt();

        graph.dijkstra(start);
    }
}