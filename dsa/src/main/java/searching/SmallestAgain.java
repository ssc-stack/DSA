/*
Problem Description

Given an integer array A of size N.

If we store the sum of each triplet of the array A in a new list, then find the Bth smallest element among the list.

NOTE: A triplet consists of three elements from the array. Let's say if A[i], A[j], A[k] are the elements of the triplet then i < j < k.



Problem Constraints

3 <= N <= 500
1 <= A[i] <= 108
1 <= B <= (N*(N-1)*(N-2))/6

 */
package searching;

import java.util.Arrays;

public class SmallestAgain {
    public int solve(int[] A, int B) {
        Arrays.sort(A);
        int n=A.length;
        int ans=0;
        int low=1,high=A[n-1]+A[n-2]+A[n-3];

        while(low<=high) {
            int mid=low+(high-low)/2;
            if(checkLessThanEq(A,B,mid)) {
                ans=mid;
                high=mid-1;
            } else {
                low=mid+1;
            }
        }

        return ans;
    }

    public boolean checkLessThanEq(int[] A,int B,int sum) {

        int count=0;
        for(int i=0;i<A.length;++i) {
            int p1=i+1,p2=A.length-1;

            while(p1<p2) {
                if(A[i]+A[p1]+A[p2]<=sum) {
                    count+=p2-p1;
                    p1++;
                } else {
                    p2--;
                }

            }
        }

        return B<=count;
    }
}
