package leetcode.level.easy.rand3;

import leetcode.TreeNode;

public class MergeBinary {
    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        // todo  t.left = mergeT()..
        TreeNode head = t1;
        if (t1 == null) {
            if (t2 == null) {
            } else {
                t1 = new TreeNode(t2.val);
                t1.left = t2.left;
                t1.right = t2.right;
            }
        } else {
            if (t2 == null) {
                t2 = new TreeNode(t1.val);
                t2.left = t1.left;
                t2.right = t1.right;
            }else {
                head.val = t1.val+t2.val;
                mergeTrees(t1.left,t2.left);
                mergeTrees(t1.right,t2.right);
            }
        }
        return head;
    }

    private void mergeTree(TreeNode head, TreeNode t1, TreeNode t2) {
        if (t1 == null) {
            if (t2 == null) {
                head =  null;
            } else {
                head =  t2;
            }
        } else {
            if (t2 == null) {
                head =  t1;
            }else {
                head = new TreeNode(t1.val+t2.val);
        mergeTree(head.left,t1.left,t2.left);
        mergeTree(head.right,t1.right,t2.right);
            }
        }
    }
}
