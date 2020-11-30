package leecode.easy.two;

import leetcode.ListNode;
import leetcode.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class BTP {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> ans = new ArrayList<>();
        List<TreeNode> path = null;
        String p = gString(path);
        ans.add(p);
        return ans;
    }

    private String gString(List<TreeNode> path) {
        String ad = "->";
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(path.get(0).val);
        for (int i = 1; i < path.size(); i++) {
            TreeNode treeNode = path.get(i);
            stringBuilder.append(ad);
            stringBuilder.append(treeNode.val);
        }
        return stringBuilder.toString();
    }

    boolean isLeaf(TreeNode n) {
        return n.left == null && n.right == null;
    }
}
