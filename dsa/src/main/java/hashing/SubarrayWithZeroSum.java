package hashing;

/*
Problem Description

Given an array of integers A, find and return whether the given array contains a non-empty subarray with a sum equal to 0.

If the given array contains a sub-array with sum zero return 1, else return 0.



Problem Constraints

1 <= |A| <= 100000

-10^9 <= A[i] <= 10^9



Input Format

The only argument given is the integer array A.



Output Format

Return whether the given array contains a subarray with a sum equal to 0.
 */

import java.util.*;

public class SubarrayWithZeroSum {
    public int solve(ArrayList<Integer> A) {
        Set<Long> set=new HashSet<>();
        set.add(new Long(0));
        long prefixSum=0;

        for(int num:A) {
            prefixSum+=num;
            if(set.contains(prefixSum)) return 1;
            set.add(prefixSum);
        }

        return 0;
    }
}
