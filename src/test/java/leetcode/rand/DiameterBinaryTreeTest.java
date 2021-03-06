package leetcode.rand;

import leetcode.TreeNode;
import leetcode.Utils;
import org.junit.Test;

public class DiameterBinaryTreeTest extends DiameterBinaryTree {

    @Test
    public void diameterOfBinaryTree() {
        String dd = "[1,2,3,4,5]";
        TreeNode treeNode = Utils.stringToTreeNode(dd);
        int i = diameterOfBinaryTree(treeNode);
        System.out.println("i = " + i);
    }
}