/*
Problem Description

Given a sorted array of integers A (0-indexed) of size N, find the left most and the right most index of a given integer B in the array A.

Return an array of size 2, such that
          First element = Left most index of B in A
          Second element = Right most index of B in A.
If B is not found in A, return [-1, -1].

Note : Your algorithm's runtime complexity must be in the order of O(log n).
roblem Constraints

1 <= N <= 106
1 <= A[i], B <= 109
 */
package searching;

public class RangeSearch {
    private static int binarySearchFirst(int[] A,int N,int B) {
        int low=0,high=N-1;
        int ans=-1;
        while(low<=high) {
            int mid=low+(high-low)/2;

            if(A[mid]==B) {
                ans=mid;
                high=mid-1;
            }

            if(A[mid]<B) {
                low=mid+1;
            } else {
                high=mid-1;
            }
        }

        return ans;
    }

    private static int binarySearchLast(int[] A,int N,int B) {
        int low=0,high=N-1;
        int ans=-1;
        while(low<=high) {
            int mid=low+(high-low)/2;

            if(A[mid]==B) {
                ans=mid;
                low=mid+1;
            }

            if(A[mid]>B) {
                high=mid-1;
            } else {
                low=mid+1;
            }
        }

        return ans;
    }

    public int[] searchRange(final int[] A, int B) {
        int[] ans=new int[2];
        ans[0]=binarySearchFirst(A,A.length,B);
        ans[1]=binarySearchLast(A,A.length,B);

        return ans;
    }
}
