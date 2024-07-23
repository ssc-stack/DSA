/*
Problem Description

Given an array of integers A and an integer B, find and return the maximum value K such that there is no sub-array in A of size K with the sum of elements greater than B.

Problem Constraints
1 <= |A| <= 100000

1 <= A[i] <= 10^9

1 <= B <= 10^9
 */

package searching;

public class SpecialInteger {
    private static int maxK(int[] A,int B) {
        int low=0,high=A.length;
        int ans=0;
        while(low<=high) {
            int mid=low+(high-low)/2;

            if(isPossible(A,mid,B)) {
                ans=mid;
                low=mid+1;
            } else {
                high=mid-1;
            }
        }

        return ans;
    }

    private static boolean isPossible(int[] A,int k,int B) {
        long sum=0L;

        for(int i=0;i<k;++i) {
            sum+=A[i];
        }

        if(sum>B) return false;

        int start=0;
        int end=k;

        while(end<A.length) {
            sum-=A[start];
            sum+=A[end];

            if(sum>B) return false;
            start++;
            end++;
        }

        return true;

    }

    public int solve(int[] A, int B) {
        return maxK(A,B);
    }
}
