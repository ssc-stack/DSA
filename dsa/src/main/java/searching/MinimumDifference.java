/*
Problem Description

You are given a 2-D matrix C of size A × B.
You need to build a new 1-D array of size A by taking one element from each row of the 2-D matrix in such a way that the cost of the newly built array is minimized.

The cost of an array is the minimum possible value of the absolute difference between any two adjacent elements of the array.

So if the newly built array is X, the element picked from row 1 will become X[1], element picked from row 2 will become X[2], and so on.

Determine the minimum cost of the newly built array.



Problem Constraints

2 <= A <= 1000
2 <= B <= 1000
1 <= C[i][j] <= 106

 */
package searching;

import java.util.Arrays;

public class MinimumDifference {
    private static int binarySearch(int[] row,int N,int element) {
        int low=0,high=N-1;

        while(low<=high) {
            int mid=low+(high-low)/2;
            if(row[mid]==element) return mid;
            if(row[mid]<element) low=mid+1;
            else high=mid-1;
        }

        if(low==N) return low-1;
        return low;
    }

    private static int minDiff(int A,int B,int[][] C) {
        for(int[] row:C) {
            Arrays.sort(row);
        }

        int ans=Integer.MAX_VALUE;

        for(int i=0;i<A-1;++i) {
            for(int j=0;j<B;++j) {
                int currentElement=C[i][j];
                int[] nextRow=C[i+1];

                //Index of just Greater Than Equal Element in the Next Row
                int nextRowIndex=binarySearch(nextRow,nextRow.length,currentElement);
                ans=Math.min(Math.abs(nextRow[nextRowIndex]-currentElement),ans);

                //Index of just Smaller Element in the Next Row
                if(nextRowIndex>0)
                    ans=Math.min(ans,Math.abs(nextRow[nextRowIndex-1]-currentElement));
            }
        }

        return ans;
    }

    public int solve(int A, int B, int[][] C) {
        return minDiff(A,B,C);
    }
}
