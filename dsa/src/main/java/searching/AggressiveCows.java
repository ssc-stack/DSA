/*
Problem Description

Farmer John has built a new long barn with N stalls. Given an array of integers A of size N where each element of the array represents the location of the stall and an integer B which represents the number of cows.

His cows don't like this barn layout and become aggressive towards each other once put into a stall. To prevent the cows from hurting each other, John wants to assign the cows to the stalls, such that the minimum distance between any two of them is as large as possible. What is the largest minimum distance?



Problem Constraints

2 <= N <= 100000
0 <= A[i] <= 109
2 <= B <= N
 */

package searching;


import java.util.Arrays;

public class AggressiveCows {
    private static int minimumDistance(int[] A,int B) {
        Arrays.sort(A);
        int n=A.length;
        int low=1,high=A[n-1]-A[0];
        while(low<=high) {
            int mid=low+(high-low)/2;

            if(isPossibleToPlaceCows(A,B,mid)) {
                low=mid+1;
            } else {
                high=mid-1;
            }
        }

        return low-1;
    }

    private static boolean isPossibleToPlaceCows(int[] A,int B,int mid) {
        int count=1; //No. of placed cows
        int lastLocation=0; // Last location of cow
        for(int i=1;i<A.length;++i) {
            if(A[i]-A[lastLocation]>=mid) {
                count++;
                lastLocation=i;
            }

            if(count==B) return true;
        }

        return false;
    }

    public int solve(int[] A, int B) {
        return minimumDistance(A,B);
    }
}
