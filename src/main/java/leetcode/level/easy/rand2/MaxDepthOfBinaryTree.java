package leetcode.level.easy.rand2;

import leetcode.TreeNode;

public class MaxDepthOfBinaryTree {
    public int maxDepth(TreeNode root) {
        if (root==null){
            return 0;
        }
        int ld = root.left==null?0:maxDepth(root.left);
        int rd = root.right==null?0:maxDepth(root.right);
        return Math.max(ld,rd) + 1;
    }
}
