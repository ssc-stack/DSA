package hashing;

/*
Problem Description

Given two integer arrays, A and B of size N and M, respectively. Your task is to find all the common elements in both the array.

NOTE:

    Each element in the result should appear as many times as it appears in both arrays.
    The result can be in any order.



Problem Constraints

1 <= N, M <= 105

1 <= A[i] <= 109
 */
import java.util.*;


public class CommonElements {
    public ArrayList<Integer> solve(ArrayList<Integer> A, ArrayList<Integer> B) {


        ArrayList<Integer> res=new ArrayList<>();

        Map<Integer,Integer> freq=new HashMap<>();
        for(int num:A) freq.put(num,freq.getOrDefault(num,0)+1);

        for(int num:B) {
            int f=freq.getOrDefault(num,0);
            if(f>0) {
                res.add(num);
                freq.put(num,f-1);
            }
        }

        return res;

    }
}
