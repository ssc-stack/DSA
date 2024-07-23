/*
Problem Description

Given an array A of N integers, find three integers in A such that the sum is closest to a given number B. Return the sum of those three integers.

Assume that there will only be one solution.



Problem Constraints

    -108 <= B <= 108
    1 <= N <= 104
    -108 <= A[i] <= 108

 */
package twopointers;

import java.util.Arrays;

public class ThreeSumClosest {
    public int threeSumClosest(int[] A, int B) {
        Arrays.sort(A);
        int n=A.length;
        int minDiff=Integer.MAX_VALUE;
        int ans=0;
        for(int i=0;i<n-2;++i) {
            int left=i+1,right=n-1;
            while(left<right) {
                int sumOfThree=A[i]+A[left]+A[right];
                int diff=Math.abs(sumOfThree-B);
                if(diff==0) return sumOfThree;
                if(diff<minDiff) {
                    ans=sumOfThree;
                    minDiff=diff;
                }

                if(sumOfThree>B) {
                    right--;
                } else {
                    left++;
                }
            }
        }

        return ans;
    }
}
