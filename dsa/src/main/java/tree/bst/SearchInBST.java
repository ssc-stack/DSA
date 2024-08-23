/*
Problem Description
Given a Binary Search Tree A. Check whether there exists a node with value B in the BST.



Problem Constraints

1 <= Number of nodes in binary tree <= 105

0 <= B <= 106
 */
package tree.bst;

import tree.TreeNode;

public class SearchInBST {
    public int solve(TreeNode A, int B) {
        return search(A,B);
    }

    public int recursiveSearch(TreeNode A,int B) {
        if(A==null) return 0;
        if(B==A.val) return 1;
        if(B<A.val) return solve(A.left,B);
        return solve(A.right,B);
    }

    public int search(TreeNode A,int B) {
        while(A!=null) {
            if(A.val==B) return 1;
            else if(B<A.val) A=A.left;
            else A=A.right;
        }

        return 0;
    }
}
