/*
Problem Description

You are given 3 sorted arrays A, B and C.

Find i, j, k such that : max(abs(A[i] - B[j]), abs(B[j] - C[k]), abs(C[k] - A[i])) is minimized.

Return the minimum max(abs(A[i] - B[j]), abs(B[j] - C[k]), abs(C[k] - A[i])).



Problem Constraints

1 <= len(A), len(B), len(c) <= 106

0 <= A[i], B[i], C[i] <= 107
 */
package twopointers;

public class Array3Pointers {
    public class Solution {
        // DO NOT MODIFY THE ARGUMENTS WITH "final" PREFIX. IT IS READ ONLY
        public int minimize(final int[] A, final int[] B, final int[] C) {
            int p1 = 0;
            int p2 = 0;
            int p3 = 0;
            int min_max = Integer.MAX_VALUE;
            while(p1<A.length && p2<B.length && p3<C.length)
            {
                int min = Math.min(Math.min(A[p1],B[p2]),C[p3]);
                int max = Math.max(Math.max(A[p1],B[p2]),C[p3]);

                min_max = Math.min(min_max,max-min);

                if(A[p1]==min)
                {
                    p1++;
                }
                else if(B[p2]==min)
                {
                    p2++;
                }
                else
                {
                    p3++;
                }
            }
            return min_max;
        }
    }

}
