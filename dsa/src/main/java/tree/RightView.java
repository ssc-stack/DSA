/*
Problem Description

Given a binary tree of integers denoted by root A. Return an array of integers representing the right view of the Binary tree.

Right view of a Binary Tree is a set of nodes visible when the tree is visited from Right side.



Problem Constraints

1 <= Number of nodes in binary tree <= 100000

0 <= node values <= 10^9
 */
package tree;

import java.util.*;

public class RightView {
    public ArrayList<Integer> solve(TreeNode A) {
        ArrayList<Integer> rightView=new ArrayList<>();
        if(A==null) return rightView;
        Deque<TreeNode> queue=new ArrayDeque<>();
        queue.offer(A);

        while(!queue.isEmpty()) {
            int size=queue.size();
            for(int i=0;i<size;++i) {
                TreeNode node=queue.pop();
                if(node.left!=null) queue.offer(node.left);
                if(node.right!=null) queue.offer(node.right);
                if(i==size-1) rightView.add(node.val);
            }
        }

        return rightView;
    }
}
