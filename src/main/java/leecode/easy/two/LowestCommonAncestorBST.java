package leecode.easy.two;

import leetcode.TreeNode;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import static leetcode.MainClass.stringToTreeNode;
import static leetcode.MainClass.treeNodeToString;

public class LowestCommonAncestorBST {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            TreeNode root = stringToTreeNode(line);
            line = in.readLine();
            int p = Integer.parseInt(line);
            line = in.readLine();
            int q = Integer.parseInt(line);

            TreeNode ret = new LowestCommonAncestorBST().lowestCommonAncestor(root, p, q);

            String out = treeNodeToString(ret);

            System.out.print(out);
        }
    }

    public TreeNode lowestCommonAncestor(TreeNode root, int p, int q) {
        return lowestCommonAncestor(root, new TreeNode(p), new TreeNode(q));
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        boolean lp = find(root.left, p);
        boolean lq = find(root.left, q);
        if(root.val==p.val ||root.val==q.val){
            return root;
        }
        if (lp && lq) {
            return lowestCommonAncestor(root.left, p, q);
        }
        if (lp || lq) {
            return root;
        } else {
            return lowestCommonAncestor(root.right, p, q);
        }

    }

    private boolean find(TreeNode root, TreeNode p) {
        if (root == null) {
            return false;
        }
        if (root.val == p.val) {
            return true;
        }
        return find(root.left, p) || find(root.right, p);
    }
}
