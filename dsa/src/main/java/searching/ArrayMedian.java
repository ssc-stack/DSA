/*
Problem Description

There are two sorted arrays A and B of sizes N and M respectively.

Find the median of the two sorted arrays ( The median of the array formed by merging both the arrays ).

NOTE:

    The overall run time complexity should be O(log(m+n)).
    IF the number of elements in the merged array is even, then the median is the average of (n/2)th and (n/2+1)th element. For example, if the array is [1 2 3 4], the median is (2 + 3) / 2.0 = 2.5.



Problem Constraints

1 <= N + M <= 2*106
 */

package searching;

import java.util.*;

public class ArrayMedian {
    public double findMedianSortedArrays(final List<Integer> a, final List<Integer> b) {
        int n1=a.size();
        int n2=b.size();
        int low=0,high=n1;

        int left=(n1+n2+1)/2;

        if (n1 > n2) return findMedianSortedArrays(b, a);

        while(low<=high) {
            int mid1=low+(high-low)/2;
            int mid2=left-mid1;
            int l1=mid1>0?a.get(mid1-1):Integer.MIN_VALUE;
            int l2=mid2>0?b.get(mid2-1):Integer.MIN_VALUE;
            int r1=mid1<n1?a.get(mid1):Integer.MAX_VALUE;
            int r2=mid2<n2?b.get(mid2):Integer.MAX_VALUE;

            if(l1 <= r2 && l2 <= r1) {
                if((n1+n2)%2==1) return Math.max(l1,l2); //ODD
                else return ((double) (Math.max(l1, l2) + Math.min(r1, r2))) / 2.0; //EVEN
            } else if(l1>r2) {
                high=mid1-1;
            } else {
                low=mid1+1;
            }

        }

        return -1;
    }
}
