/*
Problem Description

Merge two sorted linked lists, A and B, and return it as a new list.

The new list should be made by splicing together the nodes of the first two lists and should also be sorted.



Problem Constraints

0 <= |A|, |B| <= 105
 */
package linkedlist.singly;

public class MergeTwoSortedList {
    public ListNode mergeTwoLists(ListNode A, ListNode B) {
        ListNode i=A,j=B;
        ListNode dummyNode=new ListNode(-1);
        ListNode temp=dummyNode;
        while(i!=null && j!=null) {
            if(i.val<j.val) {
                temp.next=i;
                temp=i;
                i=i.next;
            } else {
                temp.next=j;
                temp=j;
                j=j.next;
            }
        }

        if(i!=null) {
            temp.next=i;
        }

        if(j!=null) {
            temp.next=j;
        }

        return dummyNode.next;
    }
}
