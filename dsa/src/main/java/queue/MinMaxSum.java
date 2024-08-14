/*
Problem Description

Given an array A of both positive and negative integers.

Your task is to compute the sum of minimum and maximum elements of all sub-array of size B.

NOTE: Since the answer can be very large, you are required to return the sum modulo 109 + 7.



Problem Constraints

1 <= size of array A <= 105

-109 <= A[i] <= 109

1 <= B <= size of array



Input Format

The first argument denotes the integer array A.
The second argument denotes the value B
 */
package queue;

import java.util.*;

public class MinMaxSum {
    private static final long M=(long)1e9+7;
    public int solve(int[] A, int B) {
        Deque<Integer> q=new ArrayDeque<>();
        long ans=0;

        for(int i=0;i<A.length;++i) {
            if(!q.isEmpty() && q.peekFirst()<=i-B) q.pollFirst();
            while(!q.isEmpty() && A[q.peekLast()]<=A[i]) q.pollLast();
            q.offer(i);
            if(i>=B-1) ans+=A[q.peekFirst()];
        }

        q.clear();
        for(int i=0;i<A.length;++i) {
            if(!q.isEmpty() && q.peekFirst()<=i-B) q.pollFirst();
            while(!q.isEmpty() && A[q.peekLast()]>=A[i]) q.pollLast();
            q.offer(i);
            if(i>=B-1) ans+=A[q.peekFirst()];
        }

        return (int)((((ans)%M)+M)%M);
    }
}
