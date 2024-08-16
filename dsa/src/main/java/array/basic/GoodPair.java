/*
Problem Description

Given an array A and an integer B. A pair(i, j) in the array is a good pair if i != j and (A[i] + A[j] == B). Check if any good pair exist or not.
 */
package array.basic;

import java.util.*;

public class GoodPair {
    public int solve(ArrayList<Integer> A, int B) {
        Set<Integer> set=new HashSet<>();

        for(int el:A) {
            if(set.contains(B-el)) return 1;
            set.add(el);
        }
        return 0;
    }
}
