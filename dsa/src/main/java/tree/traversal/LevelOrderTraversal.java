/*
Given the root of a binary tree, return the level order traversal of its nodes' values. (i.e., from left to right, level by level).
 */
package tree.traversal;

import tree.TreeNode;

import java.util.*;

public class LevelOrderTraversal {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> levelOrder=new ArrayList<>();
        if(root==null) return levelOrder;
        Deque<TreeNode> queue=new ArrayDeque<>();
        queue.offer(root);
        while(!queue.isEmpty()) {
            int size=queue.size();
            List<Integer> level=new ArrayList<>();
            for(int i=0;i<size;++i) {
                TreeNode node=queue.poll();
                level.add(node.val);
                if(node.left!=null) queue.add(node.left);
                if(node.right!=null) queue.add(node.right);
            }
            levelOrder.add(level);
        }
        return levelOrder;
    }
}
