/*
Problem Description

Given 2 integers A and B and an array of integers C of size N. Element C[i] represents the length of ith board.
You have to paint all N boards [C0, C1, C2, C3 … CN-1]. There are A painters available and each of them takes B units of time to paint 1 unit of the board.
Calculate and return the minimum time required to paint all boards under the constraints that any painter will only paint contiguous sections of the board.

NOTE:
1. 2 painters cannot share a board to paint. That is to say, a board cannot be painted partially by one painter, and partially by another.
2. A painter will only paint contiguous boards. This means a configuration where painter 1 paints boards 1 and 3 but not 2 is invalid.

Return the ans % 10000003.



Problem Constraints

1 <= A <= 1000
1 <= B <= 106
1 <= N <= 105
1 <= C[i] <= 106
 */

package searching;

public class PainterPartition {
    private static final long M=(int)1e7+3;

    private static int minimumTime(int A,int B,int[] C) {

        long low=Integer.MIN_VALUE,high=0;
        for(int i=0;i<C.length;++i) { // No need to modify the array final answer can be multiplied with B
            low=Math.max(C[i],low);
            high+=C[i];
        }

        long ans=high;

        while(low<=high) {
            long mid=low+(high-low)/2;
            // Is it possible to paint with allowed time as mid
            if(isPossibleToPaint(C,mid,A)) {
                ans=mid%M;
                high=mid-1;
            } else {
                low=mid+1;
            }
        }

        return (int)((ans*B)%M);
    }

    private static boolean isPossibleToPaint(int[] C,long time,int totalPainters) {
        int count=1; // required painter count
        int current=0; // time taken by current painter
        for(int i=0;i<C.length;++i) {
            current+=C[i];
            if(current>time) {
                count++;
                current=C[i];
            }

            if(count>totalPainters) return false;

        }

        return true;
    }

    public int paint(int A, int B, int[] C) {
        return minimumTime(A,B,C);
    }
}
