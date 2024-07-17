/*
Problem Description

Given an array of integers A, find and return the peak element in it.
An array element is considered a peak if it is not smaller than its neighbors. For corner elements, we need to consider only one neighbor.

NOTE:

    It is guaranteed that the array contains only a single peak element.
    Users are expected to solve this in O(log(N)) time. The array may contain duplicate elements.

 */
package searching;

public class PeakElement {
    private static int peakElement(int [] A,int N) {
        int low=1,high=N-2;
        if(N==1) return A[0];
        if(A[0]>A[1]) return A[0];
        if(A[N-1]>=A[N-2]) return A[N-1];

        while(low<=high) {
            int mid=low+(high-low)/2;

            if(A[mid]>=A[mid-1] && A[mid]>=A[mid+1]) {
                return A[mid];
            }

            if(A[mid]>A[mid-1]) {
                low=mid+1;
            } else {
                high=mid-1;
            }
        }

        return -1;
    }

    public int solve(int[] A) {
        return peakElement(A,A.length);
    }
}
