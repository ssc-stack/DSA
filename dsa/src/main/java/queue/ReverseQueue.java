/*
Problem Description

Given an array of integers A and an integer B, we need to reverse the order of the first B elements of the array,
leaving the other elements in the same relative order.

NOTE: You are required to the first insert elements into an auxiliary queue then perform Reversal of first B elements.



Problem Constraints

1 <= B <= length of the array <= 500000
1 <= A[i] <= 100000
 */
package queue;

import java.util.*;

public class ReverseQueue {
    public int[] solve(int[] A, int B) {
        Deque<Integer> q=new ArrayDeque<>();

        for(int i=0;i<B;++i) {
            q.offer(A[i]);
        }

        for(int i=0;i<B;++i) {
            A[i]=q.pollLast();
        }

        return A;

    }
}
