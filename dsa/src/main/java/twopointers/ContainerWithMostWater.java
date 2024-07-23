/*
Problem Description

Given N non-negative integers A[0], A[1], ..., A[N-1] , where each represents a point at coordinate (i, A[i]).

N vertical lines are drawn such that the two endpoints of line i is at (i, A[i]) and (i, 0).

Find two lines, which together with x-axis forms a container, such that the container contains the most water. You need to return this maximum area.

Note: You may not slant the container. It is guaranteed that the answer will fit in integer limits.



Problem Constraints

1 <= N <= 105

1 <= A[i] <= 105



 */
package twopointers;

public class ContainerWithMostWater {
    public int maxArea(int[] A) {
        int n=A.length;
        int left=0,right=n-1;
        int maxArea=0;
        while(left<right) {
            int height=Math.min(A[right],A[left]);
            int width=right-left;
            int area=height*width;
            maxArea=Math.max(maxArea,area);
            if(A[left]<A[right]) {
                left++;
            } else {
                right--;
            }

        }

        return maxArea;
    }
}
