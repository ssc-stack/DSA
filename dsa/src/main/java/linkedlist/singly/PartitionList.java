package linkedlist.singly;

/*
Problem Description

Given a linked list A and a value B, partition it such that all nodes less than B come before nodes greater than or equal to B.

You should preserve the original relative order of the nodes in each of the two partitions.



Problem Constraints

1 <= |A| <= 106

1 <= A[i], B <= 109
 */
public class PartitionList {
    public ListNode partition(ListNode A, int B) {
        ListNode left=new ListNode(-1),leftTail=left;
        ListNode right=new ListNode(-1),rightTail=right;

        while(A!=null) {
            if(A.val<B) {
                leftTail.next=A;
                leftTail=A;
            } else {
                rightTail.next=A;
                rightTail=A;
            }
            A=A.next;
        }

        leftTail.next=right.next;
        rightTail.next=null;

        return left.next;
    }
}
