/*
Problem Description
Given an integer array A of size N and an integer B, you have to return the same array after rotating it B times towards the right.
 */
package array.basic;

public class RotateArrayToRight {
    public void reverse(int[] arr,int start,int end) {
        int i=start;
        int j=end;

        while(i<j) {
            int temp=arr[i];
            arr[i]=arr[j];
            arr[j]=temp;
            i++;
            j--;
        }

    }

    public int[] solve(int[] A, int B) {
        int n=A.length;
        B=B%n;
        reverse(A,0,n-1);
        reverse(A,0,B-1);
        reverse(A,B,n-1);
        return A;
    }
}
