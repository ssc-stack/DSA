/*
Problem Description

Given a binary tree A. Check whether it is possible to partition the tree to two trees which have equal sum of values after removing exactly one edge on the original tree.



Problem Constraints

1 <= size of tree <= 100000

0 <= value of node <= 109
 */
package tree;

import java.util.*;

public class EqualTreePartition {
    List<Long> list=new ArrayList<>();
    private long sum(TreeNode root) {
        if(root==null) return 0;
        long s=root.val+sum(root.left)+sum(root.right);
        list.add(s);
        return s;
    }

    public int solve(TreeNode A) {
        long sum=sum(A);
        if(sum%2!=0) return 0;
        list.remove(list.size()-1); // Since only considering proper sub trees
        if(list.contains(sum/2)) return 1;
        return 0;
    }
}
