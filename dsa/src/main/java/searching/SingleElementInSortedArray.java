/*
Problem Description

Given a sorted array of integers A where every element appears twice except for one element which appears once, find and return this single element that appears only once.

Elements which are appearing twice are adjacent to each other.

NOTE: Users are expected to solve this in O(log(N)) time.
 */

package searching;

public class SingleElementInSortedArray {
    private static int getFirstIndex(int[] A,int index) {
        if(index!=0 && A[index]==A[index-1]) {
            return index-1;
        } else {
            return index;
        }
    }

    private static int getSingleElement(int[] A) {
        int low=0,high=A.length-1;

        while(low<=high) {
            int mid=low+(high-low)/2;

            if((mid==0 || A[mid]!=A[mid-1]) && (mid==A.length-1 || A[mid]!=A[mid+1])) {
                return A[mid];
            }

            int firstIndex=getFirstIndex(A,mid);
            if(firstIndex%2==0) {
                low=mid+1;
            } else {
                high=mid-1;
            }
        }

        return -1;
    }

    public int solve(int[] A) {
        return getSingleElement(A);
    }
}
