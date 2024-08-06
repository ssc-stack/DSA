/*
Problem Description

    You are given a linked list A
    Each node in the linked list contains two pointers: a next pointer and a random pointer
    The next pointer points to the next node in the list
    The random pointer can point to any node in the list, or it can be NULL
    Your task is to create a deep copy of the linked list A
    The copied list should be a completely separate linked list from the original list, but with the same node values and random pointer connections as the original list
    You should create a new linked list B, where each node in B has the same value as the corresponding node in A
    The next and random pointers of each node in B should point to the corresponding nodes in B (rather than A)



Problem Constraints

0 <= |A| <= 106
 */
package linkedlist.singly;


public class CopyList {

    private class RandomListNode {
        int label;
        RandomListNode next, random;

        RandomListNode(int x) {
            this.label = x;
        }
    }

    public RandomListNode copyRandomList(RandomListNode head) {

        if (head == null) return null;

        RandomListNode dummy = new RandomListNode(-1);
        RandomListNode res = dummy;
        RandomListNode temp = head;
        while (temp != null) {
            RandomListNode copy = new RandomListNode(temp.label);
            copy.next = temp.next;
            temp.next = copy;
            temp = temp.next.next;
        }

        temp = head;
        while (temp != null) {
            RandomListNode copy = temp.next;
            copy.random = temp.random == null ? null : temp.random.next;
            temp = temp.next.next;
        }

        temp = head;
        while (temp != null) {
            RandomListNode copy = temp.next;
            res.next = copy;
            temp.next = temp.next.next;
            temp = temp.next;
            res = res.next;
        }

        return dummy.next;
    }
}
