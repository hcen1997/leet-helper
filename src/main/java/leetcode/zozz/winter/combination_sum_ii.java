package leetcode.zozz.winter;

import leetcode.Utils;
import org.junit.Test;

import java.util.List;

/**
 * 给定一个数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
 * <p>
 * candidates 中的每个数字在每个组合中只能使用一次。
 * 注意：解集不能包含重复的组合。
 * 示例 1:
 * <p>
 * 输入: candidates = [10,1,2,7,6,1,5], target = 8,
 * 输出:
 * [
 * [1,1,6],
 * [1,2,5],
 * [1,7],
 * [2,6]
 * ]
 * <p>
 * 示例 2:
 * <p>
 * 输入: candidates = [2,5,2,1,2], target = 5,
 * 输出:
 * [
 * [1,2,2],
 * [5]
 * ]
 * <p>
 * <p>
 * <p>
 * 提示:
 * <p>
 * 1 <= candidates.length <= 100
 * 1 <= candidates[i] <= 50
 * 1 <= target <= 30
 * <p>
 * 通过次数198,869
 * 提交次数318,635
 */
public class combination_sum_ii {
    @Test
    public void tt() {
        Solution solution = new Solution();
        List<List<Integer>> lists = solution.combinationSum2(
                Utils.stringToIntegerArray("[10,1,2,7,6,1,5]")
                , 8
        );
        System.out.println("lists = " + lists);
    }

    class Solution {

        public List<List<Integer>> combinationSum2(int[] candidates, int target) {
            return null;
        }
    }
}
