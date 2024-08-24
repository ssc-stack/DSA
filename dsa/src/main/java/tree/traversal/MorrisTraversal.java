/* Morris Inorder Traversal */
package tree.traversal;

import tree.TreeNode;

import java.util.*;

public class MorrisTraversal {
    public ArrayList<Integer> solve(TreeNode A) {
        ArrayList<Integer> inorder=new ArrayList<>();

        TreeNode curr=A;

        while(curr!=null) {
            if(curr.left==null) {
                inorder.add(curr.val);
                curr=curr.right;
            } else {
                TreeNode prev=curr.left;
                while(prev.right!=null && prev.right!=curr) {
                    prev=prev.right;
                }

                if(prev.right==null) {
                    prev.right=curr;
                    curr=curr.left;
                } else {
                    prev.right=null;
                    inorder.add(curr.val);
                    curr=curr.right;
                }
            }

        }

        return inorder;
    }
}

