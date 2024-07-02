package hashing;

/*
Problem Description
You are given an array A of N integers. Return the count of elements with frequncy 1 in the given array.



Problem Constraints
1 <= N <= 105
1 <= A[i] <= 109



Input Format
First argument A is an array of integers.



Output Format
Return an integer.
 */
import java.util.*;

public class CountUniqueElements {
    public int solve(ArrayList<Integer> A) {
        int ans=0;

        Map<Integer,Integer> map=new HashMap<>();

        for(int num:A) {
            map.put(num,map.getOrDefault(num,0)+1);
        }

        for(Map.Entry<Integer,Integer> entry:map.entrySet()) {
            if(entry.getValue()==1) ans++;
        }
        return ans;
    }
}
