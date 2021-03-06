package leetcode.level.mid.rand;

import leetcode.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class AllPossibleFBT {
    /**
     * // n =1 : 单节点
     * // n = 2: 空列表
     * // n = 3  小树
     * // n = 4 空列表
     * // n = 5  偏树
     * // n = 6  空列表
     * // n = 7 ...
     *
     * @param N
     * @return
     */
    public List<TreeNode> allPossibleFBT(int N) {
        // assert N >=1 and N <=20
        List<TreeNode> ans = new ArrayList<>();
        if (N == 1) {
            ans.add(new TreeNode(0));
            return ans;
        }
        if (N % 2 == 0) {
            return ans;
        }
        return doAllPossibleFBT(N, ans);
    }

    private List<TreeNode> doAllPossibleFBT(int n, List<TreeNode> ans) {
        // 算法 得到 N-2 时的输出
        // 然后在每个节点下加两个
        // 去重
        // 输出 N
        return null;
    }
}
