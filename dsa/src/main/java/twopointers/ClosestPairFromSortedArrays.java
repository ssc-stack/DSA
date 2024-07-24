/*
Problem Description

Given two sorted arrays of distinct integers, A and B, and an integer C, find and return the pair whose sum is closest to C and the pair has one element from each array.

More formally, find A[i] and B[j] such that abs((A[i] + B[j]) - C) has minimum value.

If there are multiple solutions find the one with minimum i and even if there are multiple values of j for the same i then return the one with minimum j.

Return an array with two elements {A[i], B[j]}.



Problem Constraints

1 <= length of both the arrays <= 105

1 <= A[i], B[i] <= 109

1 <= C <= 109
 */
package twopointers;

public class ClosestPairFromSortedArrays {
    public int[] solve(int[] a, int[] b, int c) {
        int n = a.length, m = b.length;
        int l = 0, r = m-1;
        long dif = (long)(2e9);
        int ans[] = new int[]{-1, -1};
        while(l < n && r >= 0) {
            if(Math.abs(a[l] + b[r] - c) < dif) {
                // update the ans
                dif = Math.abs(a[l] + b[r] - c);
                ans[0] = a[l];  ans[1] = b[r];
            }
            else if(Math.abs(a[l] + b[r] - c) == dif && ans[0] == a[l]){
                // check for the smallest index
                ans[1] = b[r];
            }
            if(a[l] + b[r] >= c)
                r--;
            else
                l++;
        }
        return ans;
    }
}
