/*
Problem Description

You are given two linked lists, A and B, representing two non-negative numbers.

The digits are stored in reverse order, and each of their nodes contains a single digit.

Add the two numbers and return it as a linked list.



Problem Constraints

1 <= |A|, |B| <= 105
 */
package linkedlist.singly;

public class AddBigNumbers {
    public ListNode addTwoNumbers(ListNode A, ListNode B) {
        ListNode ans=new ListNode(-1);
        ListNode newHead=ans;
        int rem=0;
        while(A!=null & B!=null) {
            int sum=A.val+B.val+rem;
            ans.next=new ListNode((sum)%10);
            rem=(sum)/10;
            A=A.next;
            B=B.next;
            ans=ans.next;
        }

        while(A!=null) {
            int sum=A.val+rem;
            ans.next=new ListNode((sum)%10);
            rem=(sum)/10;
            A=A.next;
            ans=ans.next;
        }

        while(B!=null) {
            int sum=B.val+rem;
            ans.next=new ListNode((sum)%10);
            rem=sum/10;
            B=B.next;
            ans=ans.next;
        }

        if(rem!=0) ans.next=new ListNode(rem);
        return newHead.next;
    }
}
