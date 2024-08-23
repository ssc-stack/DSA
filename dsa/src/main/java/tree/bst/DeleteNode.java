/*
Given a root node reference of a BST and a key, delete the node with the given key in the BST. Return the root node reference (possibly updated) of the BST.

Basically, the deletion can be divided into two stages:

    Search for a node to remove.
    If the node is found, delete the node.


 */

package tree.bst;

import tree.TreeNode;

public class DeleteNode {
    public TreeNode deleteNode(TreeNode root, int key) {
        if(root==null) return null;
        else if(key<root.val) root.left=deleteNode(root.left,key);
        else if(key>root.val) root.right=deleteNode(root.right,key);
        else {
            if(root.left==null) return root.right;
            else if(root.right==null) return root.left;
            else {
                TreeNode maxNode=findMaxNode(root.left); // Inorder predecessor
                root.val=maxNode.val;
                root.left=deleteNode(root.left,maxNode.val);
            }
        }
        return root;
    }

    public TreeNode findMaxNode(TreeNode root) {
        while(root.right!=null) {
            root=root.right;
        }

        return root;
    }
}
