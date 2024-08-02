/*
Problem Description

Given a linked list A, swap every two adjacent nodes and return its head.

NOTE: Your algorithm should use only constant space. You may not modify the values in the list; only nodes themselves can be changed.



Problem Constraints

1 <= |A| <= 106
 */
package linkedlist;

public class SwapInPairs {
    public ListNode swapPairs(ListNode A) {

        if(A==null || A.next==null) return A;
        ListNode dummy=new ListNode(-1);
        ListNode prev=dummy,curr=A,next=null;

        while(curr!=null && curr.next!=null) {
            ListNode nextPair=curr.next.next;
            ListNode second=curr.next;

            second.next=curr;
            curr.next=nextPair; // this is required for last node other wise will create cycle in the list
            prev.next=second;

            prev=curr;
            curr=nextPair;
        }
        return dummy.next;


    }
}
