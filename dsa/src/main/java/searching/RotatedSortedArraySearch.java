/*
Problem Description

Given a sorted array of integers A of size N and an integer B,
where array A is rotated at some pivot unknown beforehand.

For example, the array [0, 1, 2, 4, 5, 6, 7] might become [4, 5, 6, 7, 0, 1, 2].

Your task is to search for the target value B in the array. If found, return its index; otherwise, return -1.

You can assume that no duplicates exist in the array.

NOTE: You are expected to solve this problem with a time complexity of O(log(N)).



Problem Constraints

1 <= N <= 1000000
1 <= A[i] <= 109
All elements in A are Distinct.
 */

package searching;

public class RotatedSortedArraySearch {
    public int binarySearch(int[] A,int low,int high,int target) {
        while(low<=high) {
            int mid=low+(high-low)/2;

            if(A[mid]==target) return mid;
            if(A[mid]<=A[low]) {
                if(target>A[mid] && target<=A[high]) {
                    low=mid+1;
                } else {
                    high=mid-1;
                }
            } else {
                if(target>=A[low] && target<A[mid]) {
                    high=mid-1;
                } else {
                    low=mid+1;
                }
            }
        }

        return -1;
    }

    public int search(final int[] A, int B) {
        return binarySearch(A,0,A.length-1,B);
    }
}
