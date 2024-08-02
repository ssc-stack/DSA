/*
Problem Description

Given a singly linked list A, determine if it's a palindrome. Return 1 or 0, denoting if it's a palindrome or not, respectively.



Problem Constraints

1 <= |A| <= 105
 */
package linkedlist.singly;

public class PalindromicList {
    public ListNode reverse(ListNode head) {
        ListNode curr=head,prev=null,next=null;

        while(curr!=null) {
            next=curr.next;
            curr.next=prev;
            prev=curr;
            curr=next;
        }

        return prev;
    }

    public ListNode midNode(ListNode head) {
        ListNode slow=head,fast=head;

        while(fast!=null && fast.next!=null) {
            slow=slow.next;
            fast=fast.next.next;
        }

        return slow;
    }

    public int lPalin(ListNode A) {
        ListNode midNode=midNode(A);

        ListNode first=A;
        ListNode second=reverse(midNode);

        while(first!=null && second!=null) {
            if(first.val!=second.val) return 0;
            first=first.next;
            second=second.next;
        }

        return 1;

    }
}
