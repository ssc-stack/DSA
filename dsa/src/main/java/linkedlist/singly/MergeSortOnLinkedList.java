/*
Problem Description

Sort a linked list, A in O(n log n) time.



Problem Constraints

0 <= |A| = 105
 */
package linkedlist.singly;

public class MergeSortOnLinkedList {
    private static ListNode getMid(ListNode head) {
        ListNode slow=head,fast=head;

        while(fast.next!=null && fast.next.next!=null) {
            slow=slow.next;
            fast=fast.next.next;
        }

        return slow;
    }

    private static ListNode mergeSortedList(ListNode A,ListNode B) {
        ListNode i=A,j=B;
        ListNode dummy=new ListNode(-1);
        ListNode newHead=dummy;

        while(i!=null && j!=null) {
            if(i.val<j.val) {
                dummy.next=i;
                dummy=i;
                i=i.next;
            } else {
                dummy.next=j;
                dummy=j;
                j=j.next;
            }
        }

        if(i!=null) {
            dummy.next=i;
        }

        if(j!=null) {
            dummy.next=j;
        }

        return newHead.next;
    }

    private static ListNode mergeSort(ListNode head) {

        if(head.next==null) return head;

        ListNode mid=getMid(head);
        ListNode head2=mid.next;
        mid.next=null;

        ListNode leftHalf=mergeSort(head);
        ListNode rightHalf=mergeSort(head2);
        return mergeSortedList(leftHalf,rightHalf);
    }

    public ListNode sortList(ListNode A) {
        if(A==null) return A;
        return mergeSort(A);
    }
}
