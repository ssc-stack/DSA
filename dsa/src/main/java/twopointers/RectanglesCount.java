/*
Problem Description

Given a sorted array of distinct integers A and an integer B, find and return how many rectangles with distinct configurations can be created using elements of this array as length and breadth whose area is lesser than B.

(Note that a rectangle of 2 x 3 is different from 3 x 2 if we take configuration into view)



Problem Constraints

1 <= |A| <= 100000
1 <= A[i] <= 109
1 <= B <= 109
 */
package twopointers;

public class RectanglesCount {
    private static long M=(long)1e9+7;

    public int solve(int[] A, int B) {
        int left=0,right=A.length-1;
        long count=0;
        while(left<A.length && right>=0) {
            long area=1L*A[left]*A[right];
            if(area<B) {
                count+=right+1;
                left++;
            } else {
                right--;
            }
        }

        return (int)(count%M);
    }
}
