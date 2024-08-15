/*
Problem Description

Given preorder and inorder traversal of a tree, construct the binary tree.

NOTE: You may assume that duplicates do not exist in the tree.



Problem Constraints

1 <= number of nodes <= 105
 */

package tree;

import java.util.*;

public class BinaryTreeUsingInorderAndPreOrder {
    public TreeNode buildTree(ArrayList<Integer> A, ArrayList<Integer> B) {
        if(A.size()!=B.size()) return null;

        Map<Integer,Integer> map=new HashMap<>(); // inorder value to index mapping

        for(int i=0;i<B.size();++i) {
            int el=B.get(i);
            map.put(el,i);
        }

        return buildTreeHelper(B,0,B.size()-1,A,0,A.size()-1,map);
    }

    public TreeNode buildTreeHelper(List<Integer> inorder,int is,int ie,List<Integer> preorder,int ps,int pe,Map<Integer,Integer> map) {
        if(is>ie || ps>pe) return null;

        // Create a new TreeNode
        // with the root value from preorder
        TreeNode root = new TreeNode(preorder.get(ps));

        int inRoot=map.get(preorder.get(ps)); // index of root element in inorder
        int numsLeft=inRoot-is;// No. of nodes in the right subtree

        // Recursively build the left subtree
        root.left=buildTreeHelper(inorder,is,inRoot-1,preorder,ps+1,ps+numsLeft,map);
        // Recursively build the right subtree
        root.right=buildTreeHelper(inorder,inRoot+1,ie,preorder,ps+numsLeft+1,pe,map);

        return root;
    }
}
