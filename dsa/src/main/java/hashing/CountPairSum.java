package hashing;

import java.util.*;

/*
Problem Description
You are given an array A of N integers and an integer B. Count the number of pairs (i,j) such that A[i] + A[j] = B and i ≠ j.

Since the answer can be very large, return the remainder after dividing the count with 109+7.

Note - The pair (i,j) is same as the pair (j,i) and we need to count it only once.



Problem Constraints
1 <= N <= 105
1 <= A[i] <= 109
1 <= B <= 109



Input Format
First argument A is an array of integers and second argument B is an integer.



Output Format
Return an integer.



 */


public class CountPairSum {
    public int solve(ArrayList<Integer> A, int B) {
        HashMap<Integer,Integer> map=new HashMap<>();
        long count=0L;
        int m=(int)1e9+7;

        for(int el:A) {
            if(map.containsKey(B-el)) {
                int freq=map.get(B-el);
                count+=freq;
            }
            map.put(el,map.getOrDefault(el,0)+1);
        }

        return (int)count%m;

    }
}
