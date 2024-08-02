/*
Problem Description

You are given A which is the head of a linked list. Also given is the value B and position C. Complete the function that should insert a new node with the said value at the given position.

Notes:

    In case the position is more than length of linked list, simply insert the new node at the tail only.
    In case the pos is 0, simply insert the new node at head only.
    Follow 0-based indexing for the node numbering.



Problem Constraints

0 <= size of linked list <= 105

1 <= value of nodes <= 109

1 <= B <= 109

0 <= C <= 105
 */
package linkedlist.singly;

public class InsertIntoLinkedList {
    public ListNode solve(ListNode A, int B, int C) {
        ListNode newNode=new ListNode(B);
        ListNode itr=A,prev=null;
        int k=0;
        while(k<C && itr!=null) {
            prev=itr;
            itr=itr.next;
            k++;
        }

        if(prev==null || A==null) {
            newNode.next=A;
            return newNode;
        }

        newNode.next=prev.next;
        prev.next=newNode;

        return A;

    }
}
