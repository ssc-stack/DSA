package tree;

public class Diameter {
    private int diameter=0;

    private int height(TreeNode root) {
        if(root==null) return -1;
        int lh=height(root.left);
        int rh=height(root.right);
        diameter=Math.max(diameter,lh+rh+2);
        return Math.max(lh,rh)+1;
    }

    public int diameterOfBinaryTree(TreeNode root) {
        height(root);
        return diameter;
    }
}
