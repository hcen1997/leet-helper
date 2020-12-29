package leetcode.level.easy.two;

import leetcode.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class BTP {
    public List<String> binaryTreePaths(TreeNode root) {
        if(root==null){
            return new ArrayList<>();
        }
        List<String> ans = new ArrayList<>();
        List<List<TreeNode>> paths = new ArrayList<>();
        ArrayList<TreeNode> data = new ArrayList<>();
        data.add(root);
        dfs(root, data, paths);
        for (List<TreeNode> path : paths) {
            String p = pathToString(path);
            ans.add(p);
        }

        return ans;
    }

    void dfs(TreeNode root, ArrayList<TreeNode> his, List<List<TreeNode>> paths) {
        if(root==null){
            return;
        }
        if (root.left == null && root.right == null) {
            paths.add(copy(his));
            his.remove(his.size() - 1);
            return;
        }
        if (root.left != null) {
            his.add(root.left);
            dfs(root.left, his, paths);
        }
        if (root.right != null) {
            his.add(root.right);
            dfs(root.right, his, paths);

        }
        his.remove(his.size() - 1);
    }

    private List<TreeNode> copy(ArrayList<TreeNode> data) {
        ArrayList<TreeNode> treeNodes = new ArrayList<>();
        boolean b = treeNodes.addAll(data);
        return treeNodes;
    }

    String pathToString(List<TreeNode> path) {
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
