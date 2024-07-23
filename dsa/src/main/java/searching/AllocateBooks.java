/*
Problem Description

Given an array of integers A of size N and an integer B.

The College library has N books. The ith book has A[i] number of pages.

You have to allocate books to B number of students so that the maximum number of pages allocated to a student is minimum.

A book will be allocated to exactly one student.
Each student has to be allocated at least one book.
Allotment should be in contiguous order, for example: A student cannot be allocated book 1 and book 3, skipping book 2.

Calculate and return that minimum possible number.

NOTE: Return -1 if a valid assignment is not possible.

Problem Constraints

1 <= N <= 105
1 <= A[i], B <= 105

 */
package searching;

public class AllocateBooks {
    private static int allocateBooks(int[] A,int B) {
        if(B>A.length) return -1;
        int low=0,high=0,ans=0;
        for(int pages:A) {
            low=Math.max(pages,low);
            high+=pages;
        }

        while(low<=high) {
            int mid=low+(high-low)/2;

            if(isPossible(A,B,mid)) {
                ans=mid;
                high=mid-1;
            } else {
                low=mid+1;
            }
        }

        return ans;
    }

    private static boolean isPossible(int[] A,int totalStudents,int pages) {
        int studentCount=1; //Current student
        int studentPages=0; // pages allocated to current student

        for(int i=0;i<A.length;++i) {
            studentPages+=A[i];

            if(studentPages>pages) {
                studentCount++;
                studentPages=A[i];
            }

            if(studentCount>totalStudents) return false;
        }

        return true;
    }

    public int books(int[] A, int B) {
        return allocateBooks(A,B);
    }
}
