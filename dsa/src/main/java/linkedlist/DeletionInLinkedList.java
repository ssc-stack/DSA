/*
Problem Description

You are given the head of a linked list A and an integer B. Delete the B-th node from the linked list.

Note : Follow 0-based indexing for the node numbering.



Problem Constraints

1 <= size of linked list <= 105
1 <= value of nodes <= 109
0 <= B < size of linked list
 */
package linkedlist;

public class DeletionInLinkedList {
    public ListNode solve(ListNode A, int B) {

        if(B==0) return A.next;
        ListNode itr=A;
        ListNode prev;
        int n=0;
        while(itr!=null && n<B-1) {
            itr=itr.next;
            n++;
        }

        itr.next=itr.next.next;

        return A;
    }
}
