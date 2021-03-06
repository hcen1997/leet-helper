package leetcode.level.easy.woked.rand2;

import leetcode.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class LayerSearchBinary {
    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) {
            return new ArrayList<List<Integer>>();
        }
        int depth = maxDepth(root);
        ArrayList<List<Integer>> ans = new ArrayList<>();
        for (int i = 0; i < depth; i++) {
            ans.add(new ArrayList<Integer>());
        }

        fillLevel(root, ans, 0);
        return ans;
    }

    void fillLevel(TreeNode root, List<List<Integer>> ans, int depth) {
        if (root == null) {
            return;
        }
        List<Integer> target = ans.get(depth);
        target.add(root.val);
        fillLevel(root.left, ans, depth + 1);
        fillLevel(root.right, ans, depth + 1);
    }

    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int ld = root.left == null ? 0 : maxDepth(root.left);
        int rd = root.right == null ? 0 : maxDepth(root.right);
        return Math.max(ld, rd) + 1;
    }
}
