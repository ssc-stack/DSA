/*
Problem Description

Given a singly linked list A

 A: A0 → A1 → … → An-1 → An

reorder it to:

 A0 → An → A1 → An-1 → A2 → An-2 → …

You must do this in-place without altering the nodes' values.



Problem Constraints

1 <= |A| <= 106
 */
package linkedlist.singly;

public class ReOrderList {
    private static ListNode findMid(ListNode head) {
        ListNode slow=head,fast=head;
        while(fast!=null && fast.next!=null) {
            slow=slow.next;
            fast=fast.next.next;
        }

        return slow;
    }

    private static ListNode reverseList(ListNode head) {
        ListNode prev=null,curr=head,next=null;
        while(curr!=null) {
            next=curr.next;
            curr.next=prev;
            prev=curr;
            curr=next;
        }

        return prev;
    }

    public ListNode reorderList(ListNode A) {

        if(A==null || A.next==null) return A;
        ListNode midNode=findMid(A);

        ListNode first=A;
        ListNode second=midNode.next;
        midNode.next=null;

        second=reverseList(second);

        ListNode ans=new ListNode(-1);
        ListNode temp=ans;
        while(first!=null && second!=null) {
            temp.next=first;
            temp=first;
            first=first.next;
            temp.next=second;
            temp=second;
            second=second.next;
        }

        while(first!=null) {
            temp.next=first;
            temp=first;
            first=first.next;
        }

        while(second!=null) {
            temp.next=second;
            temp=second;
            second=second.next;
        }

        return ans.next;
    }
}
