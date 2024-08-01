/*
Problem Description

Given a singly linked list A and an integer B, reverse the nodes of the list B at a time and return the modified linked list.



Problem Constraints

1 <= |A| <= 103

B always divides A
 */
package linkedlist;

public class ReverseListInGroups {
    private static ListNode getKthNode(ListNode head,int K) {
        for(int i=1;head!=null && i<K;++i) {
            head=head.next;
        }

        return head;
    }

    private static ListNode reverseList(ListNode head) {
        ListNode curr=head,prev=null,next=null;

        while(curr!=null) {
            next=curr.next;
            curr.next=prev;
            prev=curr;
            curr=next;
        }

        return prev;
    }

    public ListNode reverseList(ListNode A, int B) {
        ListNode itr=A,prevLast=null;

        while(itr!=null) {

            ListNode kthNode=getKthNode(itr,B);

            if(kthNode==null) {
                if(prevLast!=null) prevLast.next=itr;
                return A;
            }


            ListNode nextNode=kthNode.next;
            kthNode.next=null;
            reverseList(itr);
            if(itr==A) {
                A=kthNode;
            } else {
                prevLast.next=kthNode;
            }

            prevLast=itr;
            itr=nextNode;
        }

        return A;
    }
}
