/*
Problem Description

Given a stack of integers A, sort it using another stack.

Return the array of integers after sorting the stack using another stack.



Problem Constraints

1 <= |A| <= 5000

0 <= A[i] <= 109



Input Format

The only argument is a stack given as an integer array A.
 */
package stack;

import java.util.*;

public class SortStackUsingStack {
    public int[] solve(int[] A) {
        Deque<Integer> stack=new ArrayDeque<>();
        Deque<Integer> temp=new ArrayDeque<>();

        for(int i=0;i<A.length;++i) {
            stack.push(A[i]);
        }

        while(!stack.isEmpty()) {
            int topElement=stack.pop();

            while(!temp.isEmpty() && topElement<temp.peek()) {
                stack.push(temp.pop());
            }

            temp.push(topElement);
        }

        int[] res=new int[temp.size()];
        for(int i=temp.size()-1;i>=0;i--) {
            res[i]=temp.pop();
        }
        return res;
    }
}
