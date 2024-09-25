/*
Problem Description
Given a graph with A nodes and C weighted edges. Cost of constructing the graph is the sum of weights of all the edges in the graph.

Find the minimum cost of constructing the graph by selecting some given edges such that we can reach every other node from the 1st node.

NOTE: Return the answer modulo 109+7 as the answer can be large.



Problem Constraints
1 <= A <= 100000
0 <= C <= 100000
1 <= B[i][0], B[i][1] <= N
1 <= B[i][2] <= 109
 */
package graphs;

import java.util.Arrays;

public class ConstructionCost {

    // Constant for modulo operation
    private static final int MOD = 1000000007;

    // Union-Find (Disjoint Set Union) class
    class UnionFind {
        int[] parent, rank;

        UnionFind(int n) {
            parent = new int[n];
            rank = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
                rank[i] = 1;
            }
        }

        int find(int x) {
            if (parent[x] != x) {
                parent[x] = find(parent[x]);  // Path compression
            }
            return parent[x];
        }

        boolean union(int x, int y) {
            int rootX = find(x);
            int rootY = find(y);
            if (rootX == rootY) {
                return false;  // x and y are already in the same set
            }

            // Union by rank
            if (rank[rootX] > rank[rootY]) {
                parent[rootY] = rootX;
            } else if (rank[rootX] < rank[rootY]) {
                parent[rootX] = rootY;
            } else {
                parent[rootY] = rootX;
                rank[rootX]++;
            }
            return true;
        }
    }

    public int solve(int A, int[][] B) {
        // Step 1: Sort edges by weight
        Arrays.sort(B, (a, b) -> Integer.compare(a[2], b[2]));

        // Step 2: Initialize Union-Find for A nodes (1-indexed, so size A + 1)
        UnionFind uf = new UnionFind(A + 1);

        long totalCost = 0;
        int edgesUsed = 0;

        // Step 3: Process edges in sorted order
        for (int[] edge : B) {
            int u = edge[0];  // 1st node
            int v = edge[1];  // 2nd node
            int cost = edge[2];  // Cost of the edge

            // If adding this edge does not form a cycle, include it in the MST
            if (uf.union(u, v)) {
                totalCost = (totalCost + cost) % MOD;
                edgesUsed++;

                // We need exactly A-1 edges to form the MST
                if (edgesUsed == A - 1) {
                    break;
                }
            }
        }

        // Step 4: Return the total cost modulo 10^9 + 7
        return (int) totalCost;
    }
}
