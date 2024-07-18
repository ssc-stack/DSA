/*
Problem Description

Given an integer A. Compute and return the square root of A.
If A is not a perfect square, return floor(sqrt(A)).

NOTE:
   The value of A*A can cross the range of Integer.
   Do not use the sqrt function from the standard library.
   Users are expected to solve this in O(log(A)) time.



Problem Constraints

0 <= A <= 109
 */
package searching;

public class SqaureRoot {
    public int binarySearch(int A,int low,int high) {
        while(low<=high) {
            long mid=low+(high-low)/2;
            long sq=mid*mid;

            if(sq==(long)A) return (int)mid;
            if(sq<(long)A) low=(int)(mid+1);
            else high=(int)(mid-1);
        }

        return high;
    }

    public int sqrt(int A) {
        if(A==1) return 1;
        return binarySearch(A,1,A/2);
    }
}
