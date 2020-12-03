package leetcode.easy.rand;

import leetcode.TreeNode;

public class MinDistanceInBinaryTree {
    public int minDiffInBST(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int dL = 0;
        if (root.left != null) {
            dL = root.val + root.left.val;
        }
        int dR = 0;
        if (root.left != null) {
            dR = root.val + root.right.val;
        }
        return Math.min(Math.min(dL, dR),
                Math.min(
                        minDiffInBST(root.left),
                        minDiffInBST(root.right)
                )
        );

    }
}
