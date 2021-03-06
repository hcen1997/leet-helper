package leetcode.level.easy.woked.rand2;

import leetcode.TreeNode;

import java.util.PriorityQueue;

public class MinDiffDsfTree {
    // dfs sort in array return
    public int minDiffInBST(TreeNode root) {
        PriorityQueue<Integer> tree = new PriorityQueue<>();
        dfs(root, tree);
        int min = Integer.MAX_VALUE;
        int pr = tree.poll();
        while (!tree.isEmpty()) {
            min = Math.min(min, Math.abs(pr - tree.peek()));
            pr = tree.poll();
        }
        return min;
    }

    public int getMinimumDifference(TreeNode root) {
        return minDiffInBST(root);
    }

    void dfs(TreeNode r, PriorityQueue<Integer> t) {
        if (r == null) {
            return;
        }
        t.add(r.val);
        dfs(r.left, t);
        dfs(r.right, t);
    }
}
