/*
Problem Description

Given the inorder and postorder traversal of a tree, construct the binary tree.

NOTE: You may assume that duplicates do not exist in the tree.



Problem Constraints

1 <= number of nodes <= 105



Input Format

First argument is an integer array A denoting the inorder traversal of the tree.

Second argument is an integer array B denoting the postorder traversal of the tree.



Output Format

Return the root node of the binary tree.
 */
package tree;

import java.util.*;

public class BinaryTreeFromInorderAndPostorder {
    public TreeNode buildTree(ArrayList<Integer> A, ArrayList<Integer> B) {
        if(A.size()!=B.size()) return null;

        Map<Integer,Integer> map=new HashMap<>(); // inorder value to index mapping

        for(int i=0;i<A.size();++i) {
            int el=A.get(i);
            map.put(el,i);
        }

        return buildTreeHelper(A,0,A.size()-1,B,0,B.size()-1,map);
    }

    public TreeNode buildTreeHelper(List<Integer> inorder,int is,int ie,List<Integer> postorder,int ps,int pe,Map<Integer,Integer> map) {
        if(is>ie || ps>pe) return null;

        // Create a new TreeNode
        // with the root value from postorder
        TreeNode root = new TreeNode(postorder.get(pe));

        int inRoot=map.get(postorder.get(pe)); // index of root element in inorder
        int numsLeft=inRoot-is;// No. of nodes in the left subtree

        // Recursively build the left subtree
        root.left=buildTreeHelper(inorder,is,inRoot-1,postorder,ps,ps+numsLeft-1,map);
        // Recursively build the right subtree
        root.right=buildTreeHelper(inorder,inRoot+1,ie,postorder,ps+numsLeft,pe-1,map);

        return root;
    }
}
