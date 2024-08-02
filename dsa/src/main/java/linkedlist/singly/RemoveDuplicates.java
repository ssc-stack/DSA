/*
Problem Description

Given a sorted linked list, delete all duplicates such that each element appears only once.



Problem Constraints

0 <= length of linked list <= 106
 */

package linkedlist.singly;

public class RemoveDuplicates {
    public ListNode deleteDuplicates(ListNode A) {
        ListNode itr=A;
        while(itr!=null && itr.next!=null) {
            while(itr.next!=null && itr.val==itr.next.val) {
                itr.next=itr.next.next;
            }
            itr=itr.next;
        }

        return A;
    }
}
