/*
Problem Description

Given a matrix of integers A of size N x M in which each row is sorted.

Find and return the overall median of matrix A.

NOTE: No extra memory is allowed.

NOTE: Rows are numbered from top to bottom and columns are numbered from left to right.



Problem Constraints

1 <= N, M <= 10^5

1 <= N*M <= 10^6

1 <= A[i] <= 10^9

N*M is odd
 */
package searching;

public class MatrixMedain {
    private static int upperBound(int[] row,int target){

        int low=0,high=row.length-1;
        while(low<=high) {
            int mid=low+(high-low)/2;
            if(row[mid]>target) {
                high=mid-1;
            } else {
                low=mid+1;
            }
        }

        return high+1;
    }

    private static int countSmallEqual(int[][] A,int target) {
        int count=0;
        for(int[] row:A) {
            count+=upperBound(row,target);
        }
        return count;
    }

    public int findMedian(int[][] A) {
        int N=A.length; //total rows
        int M=A[0].length; //total columns

        int min=Integer.MAX_VALUE,max=Integer.MIN_VALUE;

        for(int[] row:A) {
            min=Math.min(row[0],min);
            max=Math.max(row[row.length-1],max);
        }

        int low=min,high=max; //Search Space
        int req=(N*M)/2; // No. of elements to the left Or Right of the Median Element
        while(low<=high) {
            int mid=low+(high-low)/2;
            int smallEqual=countSmallEqual(A,mid);
            if(smallEqual<=req) low=mid+1;
            else high=mid-1;
        }
        return low;
    }
}
