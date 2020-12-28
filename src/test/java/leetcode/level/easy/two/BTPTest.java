package leetcode.level.easy.two;

import leetcode.TreeNode;
import leetcode.Utils;
import leetcode.level.easy.rand4.BinaryWithAlterBits;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class BTPTest extends BTP {
    @Test
    public void testBinaryTreePaths() {
        TreeNode treeNode = Utils.stringToTreeNode("[1,2,3,4,5,1,6,7,89]");
        List<String> strings = binaryTreePaths(treeNode);
        System.out.println("strings = " + strings);
    }
}