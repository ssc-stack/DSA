package hashing;

/*
Problem Description
Given an array A of N integers.

Find the count of the subarrays in the array which sums to zero. Since the answer can be very large, return the remainder on dividing the result with 109+7



Problem Constraints
1 <= N <= 105
-109 <= A[i] <= 109



Input Format
Single argument which is an integer array A.



Output Format
Return an integer.
 */

import java.util.*;

public class CountSubarrayWithZeroSum {
    public int solve(ArrayList<Integer> A) {
        int count=0;
        Map<Long,Integer> map=new HashMap<>();
        map.put(0L,1);
        long prefixSum=0;
        for(int num:A) {
            prefixSum+=num;
            if(map.containsKey(prefixSum)) {
                int oldFreq=map.get(prefixSum);
                count+=oldFreq;
                map.put(prefixSum,oldFreq+1);
            }  else {
                map.put(prefixSum,1);
            }
        }

        return count;
    }
}
