/*
Given a binary search tree (BST), find the lowest common ancestor (LCA) node of two given nodes in the BST.

According to the definition of LCA on Wikipedia: “The lowest common ancestor is defined between two nodes p and q as the lowest node in T
that has both p and q as descendants (where we allow a node to be a descendant of itself).”
 */
package tree.bst;

import tree.TreeNode;

public class LCAInBST {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root==null) return root;
        if(p.val<root.val && q.val<root.val) {
            return lowestCommonAncestor(root.left,p,q);
        } else if(p.val>root.val && q.val>root.val) {
            return lowestCommonAncestor(root.right,p,q);
        }

        return root; // Flound the first split point
    }
}
