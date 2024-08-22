/*
103. Binary Tree Zigzag Level Order Traversal
Given the root of a binary tree, return the zigzag level order traversal of its nodes' values.
(i.e., from left to right, then right to left for the next level and alternate between).
 */

package tree.traversal;

import tree.TreeNode;
import java.util.*;


public class ZigZagTraversal {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> zigZag=new ArrayList<>();
        if(root==null) return zigZag;

        Deque<TreeNode> queue=new ArrayDeque<>();
        queue.offer(root);
        boolean flag=false;
        while(!queue.isEmpty()) {
            int size=queue.size();
            List<Integer> list=new LinkedList<>();
            for(int i=0;i<size;++i) {
                TreeNode node=queue.poll();
                if(node.left!=null) queue.add(node.left);
                if(node.right!=null) queue.add(node.right);
                if(!flag) { // Even
                    list.add(node.val);
                } else {
                    list.addFirst(node.val);
                }
            }
            zigZag.add(list);
            flag=!flag;
        }

        return zigZag;
    }
}
