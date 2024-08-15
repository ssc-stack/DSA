package tree;

import com.sun.source.tree.Tree;

import java.util.*;

public class PreOrderTraversal {

    public void preOrderUsingStack(TreeNode root,List<Integer> list) {
        Deque<TreeNode> stack=new ArrayDeque<>();
        if(root!=null) stack.push(root);

        while(!stack.isEmpty()) {
            TreeNode node=stack.pop();
            list.add(node.val);
            if(node.right!=null)
            stack.push(node.right);
            if(node.left!=null)
            stack.push(node.left);
        }
    }

    public void preOrder(TreeNode root,List<Integer> list) {
        if(root==null) return;
        list.add(root.val);
        preOrder(root.left,list);
        preOrder(root.right,list);
    }


    public ArrayList<Integer> preorderTraversal(TreeNode A) {
        ArrayList<Integer> preOrder=new ArrayList<>();
        preOrder(A,preOrder);
        return preOrder;
    }
}
