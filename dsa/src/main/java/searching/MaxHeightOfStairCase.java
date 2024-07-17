/*
Problem Description

Given an integer A representing the number of square blocks. The height of each square block is 1. The task is to create a staircase of max-height using these blocks.

The first stair would require only one block, and the second stair would require two blocks, and so on.

Find and return the maximum height of the staircase.



Problem Constraints
0 <= A <= 109
 */

package searching;

public class MaxHeightOfStairCase {
    public int solve(int A) {
        int height=0;

        while(A>0) {
            height++;
            A-=height;
        }

        if(A>=0) return height;
        if(A<0) return height-1;

        return 0;

    }
}
