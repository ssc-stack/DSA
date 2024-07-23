/*
Problem Description

Given a sorted array of integers (not necessarily distinct) A and an integer B, find and return how many pair of integers ( A[i], A[j] ) such that i != j have sum equal to B.

Since the number of such pairs can be very large, return number of such pairs modulo (109 + 7).



Problem Constraints

1 <= |A| <= 100000

1 <= A[i] <= 10^9

1 <= B <= 10^9
 */

package twopointers;

public class PairSumDuplicates {
    private static final long M=(long)1e9+7;

    public int solve(int[] A, int B) {
        long count=0;
        int n=A.length;
        int left=0,right=n-1;

        while(left<right) {
            long sum=A[left]+A[right];
            if(sum==B) {

                if(A[left]==A[right]) {
                    long k=right-left;
                    count+=k*(k+1)/2;
                    return (int)(count%M);
                }

                int c1=1,c2=1;

                while(left<right && A[left]==A[left+1]) {
                    c1++; left++;
                }

                while(left<right && A[right]==A[right-1]) {
                    c2++; right--;
                }

                count+=(c1*c2);

            } if(sum>B) {
                right--;
            } else {
                left++;
            }
        }

        return (int)(count%M);
    }
}
