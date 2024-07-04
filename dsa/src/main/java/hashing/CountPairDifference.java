package hashing;

/*
Problem Description
You are given an array A of N integers and an integer B.
Count the number of pairs (i,j) such that A[i] - A[j] = B and i ≠ j.

Since the answer can be very large, return the remainder after dividing the count with 109+7.



Problem Constraints
1 <= N <= 105
1 <= A[i] <= 109
1 <= B <= 109



Input Format
First argument A is an array of integers and second argument B is an integer.



Output Format
Return an integer.
 */

import java.util.*;

public class CountPairDifference {
    public int solve(ArrayList<Integer> A, int B) {
        final int M=(int)1e9+7;
        Map<Integer,Integer> map=new HashMap<>();
        long count=0L;
        for(int el:A) {

            if(map.containsKey(el+B)) {
                int freq=map.get(el+B);
                count+=freq;
            }

            if(map.containsKey(el-B)) {
                int freq=map.get(el-B);
                count+=freq;
            }

            map.put(el,map.getOrDefault(el,0)+1);
        }

        return (int)(count%M);
    }
}
