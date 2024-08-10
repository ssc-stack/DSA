/*
Problem Description

Given an array A, find the next greater element G[i] for every element A[i] in the array.
The next greater element for an element A[i] is the first greater element on the right side of A[i] in the array, A.

More formally:

G[i] for an element A[i] = an element A[j] such that
    j is minimum possible AND
    j > i AND
    A[j] > A[i]

Elements for which no greater element exists, consider the next greater element as -1.



Problem Constraints

1 <= |A| <= 105

1 <= A[i] <= 107
 */
package stack;

import java.util.*;

public class NextGreaterElement {
    public int[] nextGreater(int[] A) {
        int[] res=new int[A.length];
        Deque<Integer> stack=new ArrayDeque<>();

        for(int i=A.length-1;i>=0;--i) {
            while(!stack.isEmpty() && stack.peek()<=A[i]) {
                stack.pop();
            }

            if(stack.size()==0) res[i]=-1;
            else res[i]=stack.peek();
            stack.push(A[i]);
        }

        return res;
    }
}
