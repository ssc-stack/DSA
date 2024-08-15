package tree;

import java.util.*;

public class PostOrderTraversal {
    private class Pair {
        private TreeNode node;
        private int state;

        Pair(TreeNode node,int state) {
            this.node=node;
            this.state=state;
        }
    }

    public void postorderUsingStack(TreeNode root,List<Integer> list) {
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
                p.state++;
                if(p.node.right!=null) {
                    stack.push(new Pair(p.node.right,0));
                }
            } else { //p.state==2
                list.add(p.node.val);
                stack.pop();
            }
        }
    }

    public void postorder(TreeNode root,List<Integer> list) {
        if(root==null) return;
        postorder(root.left,list);
        postorder(root.right,list);
        list.add(root.val);
    }

    public ArrayList<Integer> postorderTraversal(TreeNode A) {
        ArrayList<Integer> postorder=new ArrayList<>();
        postorderUsingStack(A,postorder);
        return postorder;
    }
}
