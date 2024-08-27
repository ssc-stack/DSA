/*
Problem Description

Given a binary tree,

Populate each next pointer to point to its next right node. If there is no next right node, the next pointer should be set to NULL.

Initially, all next pointers are set to NULL.

Assume perfect binary tree.
 */

package tree;

import java.util.*;

public class ConnectNextPointerAtEachLevel {

    public class TreeLinkNode {
        int val;
        TreeLinkNode left, right, next;

        TreeLinkNode(int x) {
            val = x;
        }
    }

    public void connect(TreeLinkNode root) {
        if (root == null) return;
        Deque<TreeLinkNode> queue = new ArrayDeque<>();
        TreeLinkNode itr = root;
        queue.offer(itr);
        while (!queue.isEmpty()) {
            int size = queue.size();
            TreeLinkNode prev = null;
            for (int i = 0; i < size; ++i) {
                TreeLinkNode node = queue.poll();
                if (prev != null) {
                    prev.next = node;
                }
                prev = node;
                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
            }
        }
    }
}
