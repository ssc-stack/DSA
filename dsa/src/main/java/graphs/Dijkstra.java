/*
Problem Description
Given a weighted undirected graph having A nodes and M weighted edges, and a source node C.

You have to find an integer array D of size A such that:

D[i]: Shortest distance from the C node to node i.
If node i is not reachable from C then -1.
Note:

There are no self-loops in the graph.
There are no multiple edges between two pairs of vertices.
The graph may or may not be connected.
Nodes are numbered from 0 to A-1.
Your solution will run on multiple test cases. If you are using global variables, make sure to clear them.
 */
package graphs;

import java.util.*;

public class Dijkstra {
    class Pair {
        int node, dist;
        Pair(int node, int dist) {
            this.node = node;
            this.dist = dist;
        }
    }

    public int[] solve(int A, int[][] B, int C) {
        List<List<Pair>> adj = new ArrayList<>();
        for (int i = 0; i < A; i++) {
            adj.add(new ArrayList<>());
        }

        // Fill the adjacency list with undirected edges
        for (int[] edge : B) {
            int u = edge[0];
            int v = edge[1];
            int w = edge[2];
            adj.get(u).add(new Pair(v, w));
            adj.get(v).add(new Pair(u, w));
        }

        // Step 2: Dijkstra's Algorithm

        // Initialize the distance array with a large value
        int[] dist = new int[A];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[C] = 0; // Distance to the source node C is 0

        // Priority queue to get the node with the smallest distance (min-heap)
        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> a.dist - b.dist);
        pq.offer(new Pair(C, 0)); // Start from the source node

        // Step 3: Process the graph
        while (!pq.isEmpty()) {
            Pair current = pq.poll();
            int node = current.node;
            int currentDist = current.dist;

            // If the current distance is greater than the stored distance, continue
            if (currentDist > dist[node]) continue;

            // Traverse all neighbors of the current node
            for (Pair neighbor : adj.get(node)) {
                int nextNode = neighbor.node;
                int weight = neighbor.dist;

                // Calculate the new distance
                int newDist = currentDist + weight;

                // If a shorter path is found, update the distance and push to the queue
                if (newDist < dist[nextNode]) {
                    dist[nextNode] = newDist;
                    pq.offer(new Pair(nextNode, newDist));
                }
            }
        }

        // Step 4: Replace any unreachable nodes with -1
        for (int i = 0; i < A; i++) {
            if (dist[i] == Integer.MAX_VALUE) {
                dist[i] = -1;
            }
        }

        return dist;
    }
}
