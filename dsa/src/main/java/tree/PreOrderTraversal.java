package tree;

import java.util.*;

public class PreOrderTraversal {
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
