package leetcode.level.easy.rand2;

import leetcode.TreeNode;

public class BinaryTreeTili {
    public int findTilt(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int lt = root.left!=null?val(root.left):0;
        int lr = root.right!=null?val(root.right):0;
        int til = Math.abs(lt-lr);
        return til + findTilt(root.left) + findTilt(root.right);
    }

    private int val(TreeNode root) {
        if(root==null){
            return 0;
        }
        int lt = root.left!=null?val(root.left):0;
        int lr= root.right!=null?val(root.right):0;
        return root.val+lr+lt;
    }

}
