/*
Problem Description

Reverse a linked list A from position B to C.

NOTE: Do it in-place and in one-pass.



Problem Constraints

1 <= |A| <= 106

1 <= B <= C <= |A|
 */
package linkedlist;

public class ReverseBetween {
    public ListNode reverseBetween(ListNode A, int B, int C) {
        int s=1;

        ListNode itr=A;

        if(B==C) return A;

        while(s<B-1) {
            itr=itr.next;
            s++;
        }

        ListNode temp=itr.next;
        ListNode curr=itr,prev=null,next=null;
        while(curr!=null && s<=C) {
            next=curr.next;
            curr.next=prev;
            prev=curr;
            curr=next;
            s++;
        }

        if(B==1) {
            A.next=curr;
            return prev;
        }
        itr.next=prev;
        temp.next=curr;


        return A;
    }
}
