/*
Problem Description

Given an array A of N integers, return the number of unique elements in the array.



Problem Constraints

1 <= N <= 105
1 <= A[i] <= 109



Input Format

First argument A is an array of integers.



Output Format

Return an integer.
 */

package hashing;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class UniqueElements {
    public int solve(ArrayList<Integer> A) {
        Map<Integer,Integer> map=new HashMap<>();
        for(int num:A) {
            map.put(num,null);
        }

        return map.size();
    }
}
