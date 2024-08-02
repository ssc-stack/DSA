/*
Problem Description

Reverse a linked list A from position B to C.

NOTE: Do it in-place and in one-pass.



Problem Constraints

1 <= |A| <= 106

1 <= B <= C <= |A|
 */
package linkedlist.singly;

public class ReverseBetween {
    public ListNode reverseBetween(ListNode A, int B, int C) {
        ListNode prev=null;
        ListNode itr=A;
        for(int i=1;i<B;++i) {
            prev=itr;
            itr=itr.next;
        }

        if(prev!=null) {
            prev.next=reverseList(itr,C-B+1);
        } else {
            A=reverseList(itr,C-B+1);
        }

        return A;//
    }

    public ListNode reverseList(ListNode A,int count) {

        if(A==null) return A;

        ListNode curr=A,prev=null,next=null;
        ListNode last=A;

        while(curr!=null && count>0) {
            next=curr.next;
            curr.next=prev;
            prev=curr;
            curr=next;
            count--;
        }
        last.next=curr;
        return prev;
    }
}
