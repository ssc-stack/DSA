package hashing;

/*
Problem Description

Given an array of positive integers A and an integer B, find and return first continuous subarray which adds to B.

If the answer does not exist return an array with a single integer "-1".

First sub-array means the sub-array for which starting index in minimum.



Problem Constraints

1 <= length of the array <= 100000
1 <= A[i] <= 109
1 <= B <= 109



Input Format

The first argument given is the integer array A.

The second argument given is integer B.



Output Format

Return the first continuous sub-array which adds to B and if the answer does not exist return an array with a single integer "-1".
 */

import java.util.*;

public class FirstContinuousSubArray {
    public ArrayList<Integer> solve(ArrayList<Integer> A, int B) {
        ArrayList<Integer> res=new ArrayList<>();
        ArrayList<Integer> empty=new ArrayList<>();
        empty.add(-1);
        long psum=0;
        Map<Long,Integer> map=new HashMap<>();
        map.put(0L,-1);
        for(int i=0;i<A.size();++i) {
            psum+=A.get(i);
            if(map.containsKey(psum-B)) {
                int startIndex=map.get(psum-B);
                for(int j=startIndex+1;j<=i;j++) res.add(A.get(j));
                break;
            } else {
                map.put(psum,i);
            }
        }

        if(res.size()==0) return empty;
        return res;
    }
}
