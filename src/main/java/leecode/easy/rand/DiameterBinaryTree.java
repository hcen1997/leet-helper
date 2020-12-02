package leecode.easy.rand;

import leetcode.TreeNode;

public class DiameterBinaryTree {
    public int diameterOfBinaryTree(TreeNode root) {
        if(root==null){
            return 0;
        }
        // 穿过  左深度 加 右深度 + 1
        int dPath =  calDepth(root.left)+calDepth(root.right);
        int rd= diameterOfBinaryTree(root.left);
        int rl= diameterOfBinaryTree(root.right);
        return Math.max(Math.max(rd,rl),dPath);
    }

    private int calDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return Math.max(1 + calDepth(root.left), 1 + calDepth(root.right));
    }
}
