/*
Problem Description

Given a sorted array of distinct integers A and an integer B, find and return how many rectangles with distinct configurations can be created using elements of this array as length and breadth whose area is lesser than B.

(Note that a rectangle of 2 x 3 is different from 3 x 2 if we take configuration into view)



Problem Constraints

1 <= |A| <= 100000
1 <= A[i] <= 109
1 <= B <= 109
 */
package twopointers;

import java.util.ArrayList;

public class RectanglesCount {
    public int solve(ArrayList< Integer > A, int B) {
        long ans = 0, mod = (long)(1000000000 + 7);
        int l = 0, r = A.size() - 1;
        while (l < A.size() && r >= 0) {
            if ((long) A.get(l) * A.get(r) < B) {
                // A[l] can form rectangles with any of A[0..r]
                ans = (ans + r + 1) % mod;
                l++;
            } else r--;
        }
        return (int) ans;
    }
}
