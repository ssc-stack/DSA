/*
Problem Description
There are A islands and there are M bridges connecting them. Each bridge has some cost attached to it.

We need to find bridges with minimal cost such that all islands are connected.

It is guaranteed that input data will contain at least one possible scenario in which all islands are connected with each other.



Problem Constraints
1 <= A, M <= 6*104

1 <= B[i][0], B[i][1] <= A

1 <= B[i][2] <= 103


 */
package graphs;

import java.util.Arrays;

public class CommutableIslands {
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
                return false;
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
        // Step 1: Sort edges by cost
        Arrays.sort(B, (a, b) -> Integer.compare(a[2], b[2]));

        // Step 2: Initialize Union-Find for A islands (0-indexed, so size A + 1)
        UnionFind uf = new UnionFind(A);

        int totalCost = 0;
        int edgesUsed = 0;

        // Step 3: Kruskal's Algorithm to form the MST
        for (int[] edge : B) {
            int island1 = edge[0] - 1;  // Convert to 0-indexed
            int island2 = edge[1] - 1;  // Convert to 0-indexed
            int cost = edge[2];

            // If these two islands are not connected, connect them
            if (uf.union(island1, island2)) {
                totalCost += cost;
                edgesUsed++;
                // If we used A-1 edges, we have a valid MST
                if (edgesUsed == A - 1) {
                    break;
                }
            }
        }

        return totalCost;
    }
}
