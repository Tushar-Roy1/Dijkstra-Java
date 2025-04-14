# Dijkstra's Algorithm in Java

This project contains a Java implementation of **Dijkstra’s shortest path algorithm** that takes user input for the number of vertices, edges, and weights.

## Features

- User can enter graph data from console
- Uses adjacency list for graph representation
- Calculates shortest distances from the source node

## How to Run

1. Save the file as `DijkstraUserInput.java`
2. Compile the code:
java DijkstraUserInput:
Enter number of vertices: 5
Enter number of edges: 6
Enter edges (source destination weight):
0 1 2
0 2 4
1 2 1
1 3 7
2 4 3
3 4 1
Enter starting node for Dijkstra's algorithm: 0

Output:
Shortest distances from node 0:
To 0 => 0
To 1 => 2
To 2 => 3
To 3 => 8
To 4 => 6
