package tree.bst;

import tree.TreeNode;

public class KthSmallestElement {
    private int ans;
    private int index;

    private void kthSmallestHelper(TreeNode root, int k) {
        if(root==null) return;
        kthSmallestHelper(root.left,k);
        index++;
        if(index==k) {
            ans=root.val;
            return;
        }
        if(ans==-1)
            kthSmallestHelper(root.right,k);
    }

    public int kthsmallest(TreeNode A, int B) {
        index=0;
        ans=-1;
        kthSmallestHelper(A,B);
        return ans;
    }
}
