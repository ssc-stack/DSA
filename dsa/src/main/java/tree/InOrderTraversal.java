package tree;

import java.util.*;

public class InOrderTraversal {
    private class Pair {
        private TreeNode node;
        private int state;

        Pair(TreeNode node,int state) {
            this.node=node;
            this.state=state;
        }
    }

    public void inOrderUsingStack(TreeNode root,List<Integer> list) {
        Deque<Pair> stack=new ArrayDeque<>();
        stack.push(new Pair(root,0));

        while(!stack.isEmpty()) {
            Pair p=stack.peek();
            if(p.state==0) {
                p.state++;
                if(p.node.left!=null) {
                    stack.push(new Pair(p.node.left,0));
                }
            } else if(p.state==1) {
                list.add(p.node.val);
                p.state++;
                if(p.node.right!=null) {
                    stack.push(new Pair(p.node.right,0));
                }
            } else { //p.state==2
                stack.pop();
            }
        }
    }

    public void inOrder(TreeNode root,List<Integer> list) {
        if(root==null) return;
        inOrder(root.left,list);
        list.add(root.val);
        inOrder(root.right,list);
    }

    public ArrayList<Integer> inorderTraversal(TreeNode A) {
        ArrayList<Integer> inOrder=new ArrayList<>();
        //inOrder(A,inOrder);
        inOrderUsingStack(A,inOrder);
        return inOrder;
    }
}
