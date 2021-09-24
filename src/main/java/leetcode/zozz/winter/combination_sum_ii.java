package leetcode.zozz.winter;

import leetcode.Utils;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
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

        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> line = new ArrayList<>();

        public List<List<Integer>> combinationSum2(int[] candidates, int target) {
            // dfs 回溯 从前开始
            Arrays.sort(candidates);
            dfs(candidates, target, 0);
            return ans;
        }

        private void dfs(int[] candidates, int target, int index) {
            if (target == 0) {
                System.out.println("addlist " + line.toString());
                ans.add(new ArrayList<>(line));
            }
            for (int i = index; i < candidates.length; i++) {
                if (candidates[i] <= target) {
                    for (int j = 0; j < i; j++) {
                        System.out.print("    " );
                    }
                    System.out.println("add " + candidates[i]);
                    line.add(candidates[i]);
                    for (int j = 0; j < i; j++) {
                        System.out.print("    " );
                    }
                    System.out.println(String.format("dfs %s %s", target - candidates[i], candidates[i + 1]));
                    dfs(candidates, target - candidates[i], i + 1);
                    for (int j = 0; j < i; j++) {
                        System.out.print("    " );
                    }
                    System.out.println("remove " + line.get(line.size() - 1));
                    line.remove(line.size() - 1);
                }
            }
        }
    }
//     add 1;
//            1< 8:  add 1;
//            1+1< 8 : add 2;
//             1+2+1<8 : add5;
//            1+1+2+5>8: remove 5;

//            7<8: add 2;
//            7+2>8: remove 2;
//            7<8: add 1;
//            7 +1 ==8: addlist 7,1;
//            remove 1; find 1; skip 1;
//            index == -1 : remove 7;
//            add 6;
//            6<8: add 5;
//            6+5>8: remove 5;
//            6<8: add 2;
//            6+2==8: addlist 6,2;
//            index!=-1: remove 2;
//            6<8: add 1;
//            6+1<8: add 1;
//            6+1+1==8: addlist 6,1,1;
//            index == -1: remove 1;
//            index == -1: remove 1;
//            index == -1: remove 6;
//            add 5;
//            5<8: add 2;
//            5+2<8: add 1;
//            5+2+1==8: addlist 5,2,1;
//            remove 1, find 1, skip 1;
//            index == -1: remove 2;
//            5<8: add 1;
//            5+1<8: add 1;
//            5+1+1<8 && index ==-1: remove 1, remove 1, remove 1;
//            ...
    // 我是一个机器人
}
