/*
Problem Description

Given a linked list A, remove the B-th node from the end of the list and return its head.
For example, given linked list: 1->2->3->4->5, and B = 2.
After removing the second node from the end, the linked list becomes 1->2->3->5.

NOTE: If B is greater than the size of the list, remove the first node of the list.

Try doing it using constant additional space.



Problem Constraints
1 <= |A| <= 106



 */

package linkedlist;

public class DeleteFromEnd {
    public ListNode removeNthFromEnd(ListNode A, int B) {
        int totalNodes=0;
        ListNode itr=A;
        while(itr!=null) {
            totalNodes++;
            itr=itr.next;
        }

        if(totalNodes<=B) return A.next;

        int k=totalNodes-B;
        itr=A;
        while(itr!=null && k>1) {
            itr=itr.next;
            k--;
        }

        itr.next=itr.next.next;
        return A;
    }
}
