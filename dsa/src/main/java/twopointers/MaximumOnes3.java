/*
Problem Description

Given a binary array A, find the maximum sequence of continuous 1's that can be formed by replacing at-most B zeroes.

For this problem, return the indices of maximum continuous series of 1s in order.

If there are multiple possible solutions, return the sequence which has the minimum start index.



Problem Constraints

0 <= B <= 105

1 <= size(A) <= 105

0 <= A[i] <= 1
 */

package twopointers;

import java.util.stream.IntStream;

public class MaximumOnes3 {
    public int[] maxone(int[] A, int B) {
        int n = A.length;

        int i=0;
        int j=0;
        int zeros = 0;

        int maxLen = Integer.MIN_VALUE;
        int s=i, e=i;

        while(j<n) {
            //Calculate the zeros in the window
            if(A[j] == 0) {
                zeros++;
            }

            //If current value overshoots the target, shrink the window to achieve the target.
            while(i<n && zeros > B) {
                if(A[i] == 0) {
                    zeros--;
                }
                i++;
            }

            //if it satisfies the max condition update ans.
            int currLen = j-i+1;
            if(currLen > maxLen) {
                maxLen = currLen;
                s=i;
                e=j;
            }

            j++;
        }

        //this will generate stream from s to e(inclusive).
        return IntStream.rangeClosed(s,e).toArray();
    }
}
