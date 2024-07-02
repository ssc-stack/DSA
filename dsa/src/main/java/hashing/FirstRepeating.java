package hashing;

/*
Problem Description

Given an integer array A of size N, find the first repeating element in it.

We need to find the element that occurs more than once and whose index of the first occurrence is the smallest.

If there is no repeating element, return -1.



Problem Constraints

1 <= N <= 105

1 <= A[i] <= 109



Input Format

The first and only argument is an integer array A of size N.



Output Format

Return an integer denoting the first repeating element.

 */
import java.util.*;

public class FirstRepeating {
    public int solve(ArrayList<Integer> A) {
        Map<Integer,Integer> freq=new HashMap<>();
        for(int num:A) freq.put(num,freq.getOrDefault(num,0)+1);

        for(int num:A) {
            if(freq.get(num)>1) return num;
        }

        return -1;
    }
}
