/*
Problem Description
You are given a sorted array A of size N and a target value B.
Your task is to find the index (0-based indexing) of the target value in the array.

    If the target value is present, return its index.
    If the target value is not found, return the index of least element greater than equal to B.
    If the target value is not found and least number greater than equal to target is also not present, return the length of array (i.e. the position where target can be placed)

Your solution should have a time complexity of O(log(N)).
 */

package searching;

import java.util.*;

public class SortedInsertedPosition {
    private static int binarySearch(List<Integer> list,int target) {
        int low=0;
        int high=list.size()-1;
        while(low<=high) {
            int mid=low+(high-low)/2;
            if(list.get(mid)==target) return mid;

            if(list.get(mid)<target) {
                low=mid+1;
            } else {
                high=mid-1;
            }
        }

        return low;
    }

    public int searchInsert(ArrayList<Integer> A, int B) {
        return binarySearch(A,B);
    }
}
