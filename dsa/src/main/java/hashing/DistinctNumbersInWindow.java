package hashing;

/*
Problem Description

You are given an array of N integers, A1, A2 ,..., AN and an integer B. Return the of count of distinct numbers in all windows of size B.

Formally, return an array of size N-B+1 where i'th element in this array contains number of distinct elements in sequence Ai, Ai+1 ,..., Ai+B-1.

NOTE: if B > N, return an empty array.



Problem Constraints
1 <= N <= 106

1 <= A[i] <= 109



Input Format

First argument is an integer array A
Second argument is an integer B.



Output Format

Return an integer array.
 */

import java.util.*;

public class DistinctNumbersInWindow {
    public ArrayList<Integer> dNums(ArrayList<Integer> A, int B) {

        ArrayList<Integer> res=new ArrayList<>();

        Map<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<B;++i) map.put(A.get(i),map.getOrDefault(A.get(i),0)+1);
        res.add(map.size());
        int start=0,end=B-1;
        while(end<A.size()-1) {
            int L=A.get(start++);
            int frequencyOfL=map.get(L);
            if(frequencyOfL==1) map.remove(L);
            else map.put(L,frequencyOfL-1);
            int R=A.get(++end);
            map.put(R,map.getOrDefault(R,0)+1);
            res.add(map.size());
        }

        return res;
    }
}
