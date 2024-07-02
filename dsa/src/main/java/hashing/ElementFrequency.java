package hashing;

/*
Problem Description

Given an array A. You have some integers given in the array B.
For the i-th number, find the frequency of B[i] in the array A and return a list containing all the frequencies.
*/

import java.util.ArrayList;

public class ElementFrequency {
    public ArrayList<Integer> solve(ArrayList<Integer> A, ArrayList<Integer> B) {
        ArrayList<Integer> res=new ArrayList<>();

        int[] freq=new int[100001];
        for(int num:A) {
            freq[num]++;
        }

        for(int num:B) {
            res.add(freq[num]);
        }

        return res;
    }
}
