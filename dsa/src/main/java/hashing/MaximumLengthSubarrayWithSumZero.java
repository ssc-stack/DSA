package hashing;

import java.util.*;

/*
Problem Description

Given an array A of N integers.
Find the length of the longest subarray in the array which sums to zero.

If there is no subarray which sums to zero then return 0.



Problem Constraints
1 <= N <= 105
-109 <= A[i] <= 109



Input Format
Single argument which is an integer array A.



Output Format
Return an integer.
 */

public class MaximumLengthSubarrayWithSumZero {
    public int solve(ArrayList<Integer> A) {
        int ans=0;
        Map<Long,Integer> map=new HashMap<>();
        long psum=0L;
        map.put(0L,0);
        for(int i=0;i<A.size();++i) {
            psum+=A.get(i);
            if(map.containsKey(psum)) {
                int len=i+1-map.get(psum);
                ans=Math.max(ans,len);
            } else {
                map.put(psum,i+1);
            }

        }

        return ans;
    }
}
