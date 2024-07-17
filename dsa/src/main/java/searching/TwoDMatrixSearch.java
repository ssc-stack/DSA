/*
Problem Description

Given a matrix of integers A of size N x M and an integer B. Write an efficient algorithm that searches for integer B in matrix A.

This matrix A has the following properties:

    Integers in each row are sorted from left to right.
    The first integer of each row is greater than or equal to the last integer of the previous row.

Return 1 if B is present in A, else return 0.

NOTE: Rows are numbered from top to bottom, and columns are from left to right.



Problem Constraints

1 <= N, M <= 1000
1 <= A[i][j], B <= 106
 */

package searching;

public class TwoDMatrixSearch {
    private static int binarySearch(int[][] A,int N,int M,int B) {
        int low=0,high=N*M-1;

        while(low<=high) {
            int mid=low+(high-low)/2;
            int row=mid/M;
            int col=mid%M;

            if(A[row][col]==B) return 1;

            if(A[row][col]<B) low=mid+1;
            else high=mid-1;
        }

        return 0;
    }

    public int searchMatrix(int[][] A, int B) {
        int N=A.length;
        int M=A[0].length;

        return binarySearch(A,N,M,B);
    }
}
