/*
Problem Description

Given an one-dimensional integer array A of size N and an integer B.

Count all distinct pairs with difference equal to B.

Here a pair is defined as an integer pair (x, y), where x and y are both numbers in the array and their absolute difference is B.



Problem Constraints

1 <= N <= 104

0 <= A[i], B <= 105
 */
package twopointers;

import java.util.Arrays;

public class PairDiff {
    public int solve(int[] A, int B) {
        Arrays.sort(A);

        int l=0,r=1;
        int n=A.length;
        int count=0;
        int sum=Integer.MIN_VALUE;

        while(r<n) {
            int diff=A[r]-A[l];
            if(diff==B && (A[l]+A[r])!=sum) {
                sum=A[l]+A[r];
                count++;
                l++;
                r++;
            } else if(diff>B) {
                l++;
            }  else {
                r++;
            }

            if(l==r) r++;
        }

        return count;
    }
}
