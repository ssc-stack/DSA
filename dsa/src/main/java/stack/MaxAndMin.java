/*
Problem Description

Given an array of integers A.

The value of an array is computed as the difference between the maximum element in the array and the minimum element in the array A.

Calculate and return the sum of values of all possible subarrays of A modulo 109+7.



Problem Constraints

1 <= |A| <= 100000

1 <= A[i] <= 1000000
 */
package stack;

import java.util.*;

public class MaxAndMin {
    private static final long M=(long)1e9+7;

    private static int[] nextSmallerLeft(int[] A) {

        int[] res=new int[A.length];
        Deque<Integer> stack=new ArrayDeque<>();

        for(int i=0;i<A.length;++i) {
            while(!stack.isEmpty() && A[stack.peek()]>=A[i]) {
                stack.pop();
            }

            if(stack.size()==0) res[i]=-1;
            else res[i]=stack.peek();
            stack.push(i);
        }

        return res;

    }

    private static int[] nextSmallerRight(int[] A) {
        int[] res=new int[A.length];
        Deque<Integer> stack=new ArrayDeque<>();

        for(int i=A.length-1;i>=0;--i) {
            while(!stack.isEmpty() && A[stack.peek()]>=A[i]) {
                stack.pop();
            }

            if(stack.size()==0) res[i]=res.length;
            else res[i]=stack.peek();
            stack.push(i);
        }

        return res;
    }

    private static int[] nextGreaterLeft(int[] A) {

        int[] res=new int[A.length];
        Deque<Integer> stack=new ArrayDeque<>();

        for(int i=0;i<A.length;++i) {
            while(!stack.isEmpty() && A[stack.peek()]<=A[i]) {
                stack.pop();
            }

            if(stack.size()==0) res[i]=-1;
            else res[i]=stack.peek();
            stack.push(i);
        }

        return res;

    }

    private static int[] nextGreaterRight(int[] A) {
        int[] res=new int[A.length];
        Deque<Integer> stack=new ArrayDeque<>();

        for(int i=A.length-1;i>=0;--i) {
            while(!stack.isEmpty() && A[stack.peek()]<=A[i]) {
                stack.pop();
            }

            if(stack.size()==0) res[i]=res.length;
            else res[i]=stack.peek();
            stack.push(i);
        }

        return res;
    }


    public int solve(int[] A) {

        long ans=0;
        int[] nsl=nextSmallerLeft(A); // Storing Index to calculate Length
        int[] nsr=nextSmallerRight(A);
        int[] ngl=nextGreaterLeft(A);
        int[] ngr=nextGreaterRight(A);

        for(int i=0;i<A.length;++i) {
            long contributionAsMin=1L*(i-nsl[i])*(nsr[i]-i)-1;
            long contributionAsMax=1L*(i-ngl[i])*(ngr[i]-i)-1;
            long totalContribution=A[i]*(contributionAsMax-contributionAsMin);
            ans+=totalContribution;
        }

        return (int)(ans%M);
    }
}
