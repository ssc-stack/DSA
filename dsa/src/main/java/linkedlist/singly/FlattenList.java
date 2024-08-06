/*
Problem Description

Given a linked list where every node represents a linked list and contains two pointers of its type:

    Pointer to next node in the main list (right pointer)
    Pointer to a linked list where this node is head (down pointer). All linked lists are sorted.

You are asked to flatten the linked list into a single list. Use down pointer to link nodes of the flattened list. The flattened linked list should also be sorted.



Problem Constraints

1 <= Total nodes in the list <= 100000

1 <= Value of node <= 109
 */
package linkedlist.singly;



public class FlattenList {

    private class ListNode {
        int val;
        ListNode right, down;
        ListNode(int x) {
            val = x;
            right = down = null;
        }
    }

    ListNode merge(ListNode list1,ListNode list2) {
        ListNode dummy=new ListNode(-1);
        ListNode res=dummy;

        while(list1!=null && list2!=null) {
            if(list1.val<list2.val) {
                res.down=list1;
                res=list1;
                list1=list1.down;
            } else {
                res.down=list2;
                res=list2;
                list2=list2.down;
            }
            res.right=null;
        }

        if(list1!=null) {
            res.down=list1;
            list1.right=null;
        } else if(list2!=null) {
            res.down=list2;
            list2.right=null;
        }

        return dummy.down;

    }

    ListNode flatten(ListNode root) {
        if(root==null || root.right==null) {
            return root;
        }

        ListNode mergedHead=flatten(root.right);
        return merge(root,mergedHead);
    }
}
