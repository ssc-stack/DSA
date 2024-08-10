/*
Problem Description

Given an array A, find the nearest smaller element G[i] for every element A[i] in the array such that the element has an index smaller than i.

More formally,

G[i] for an element A[i] = an element A[j] such that

j is maximum possible AND

j < i AND

A[j] < A[i]

Elements for which no smaller element exist, consider the next smaller element as -1.
 */
package stack;

import java.util.*;

public class NextSmallerElement {
    public ArrayList<Integer> prevSmaller(ArrayList<Integer> A) {
        Deque<Integer> stack=new ArrayDeque<>();
        ArrayList<Integer> res=new ArrayList<>();

        for(int i=0;i<A.size();++i) {
            while(!stack.isEmpty() && stack.peek()>=A.get(i)) {
                stack.pop();
            }
            if(stack.size()==0) res.add(-1);
            else res.add(stack.peek());
            stack.push(A.get(i));
        }

        return res;

    }
}
