/*
Problem Description

Given an array of positive integers A and an integer B, find and return first continuous subarray which adds to B.

If the answer does not exist return an array with a single integer "-1".

First sub-array means the sub-array for which starting index in minimum.



Problem Constraints

1 <= length of the array <= 100000
1 <= A[i] <= 109
1 <= B <= 109
 */
package twopointers;

import java.util.Arrays;

public class SubarrayWithGivenSum {
    public int[] solve(int[] A, int B) {

        int l=0;
        int r=0;
        int n=A.length;
        int sum=A[0];
        while(r<n) {
            if(sum==B) {
                return Arrays.copyOfRange(A,l,r+1);
            } else if(sum<B) {
                r++;
                if(r<n)
                    sum+=A[r];
            } else {
                sum-=A[l];
                l++;
            }
        }

        return new int[]{-1};
    }
}
