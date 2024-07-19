/*
Problem Description

Given an array of integers A of size N and an integer B.

In a single operation, any one element of the array can be increased by 1. You are allowed to do at most B such operations.

Find the number with the maximum number of occurrences and return an array C of size 2, where C[0] is the number of occurrences, and C[1] is the number with maximum occurrence.
If there are several such numbers, your task is to find the minimum one.



Problem Constraints

1 <= N <= 105

-109 <= A[i] <= 109

0 <= B <= 109
 */

package searching;

import java.util.Arrays;

public class MostFrequentFrequency {
    public int[] solve(int[] A, int B) {

        Arrays.sort(A);
        int[] res=new int[2];
        long total=0;
        int left=0,right=0;
        int n=A.length;

        while(right<n) {
            total+=A[right];
            while((long)A[right]*(right-left+1)>total+B) {
                total-=A[left];
                left++;
            }

            if(right-left+1>res[0]) {
                res[0]=right-left+1;
                res[1]=A[right];
            }

            right++;
        }

        return res;
    }
}
