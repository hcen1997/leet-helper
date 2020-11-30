package leetcode.editor.cn;//给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有满足条件且不重复
//的三元组。 
//
// 注意：答案中不可以包含重复的三元组。 
//
// 
//
// 示例： 
//
// 给定数组 nums = [-1, 0, 1, 2, -1, -4]，
//
//满足要求的三元组集合为：
//[
//  [-1, 0, 1],
//  [-1, -1, 2]
//]
// 
// Related Topics 数组 双指针 
// 👍 2767 👎 0


import java.util.ArrayList;
import java.util.HashSet;
import
        java.util.List; // ????3?????0??? ???? // ??: ???????, ??????3?

//leetcode submit region begin(Prohibit modification and deletion)
class ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        final int i = zeroCount(nums);
        if (i == 1) {
            List<List<Integer>> lists = handleZero(nums);
        } else if (i == 0) {
            return handleNoZero(nums);
        } else if (i == 3) {
            final List<List<Integer>> lists = new ArrayList<>();
            lists.add(List.of(0, 0, 0));
            return lists;
        } else {
            final List<List<Integer>> lists = new ArrayList<>();
            return lists;
        }
        return null;
    }

    private List<List<Integer>> handleNoZero(int[] nums) {
// 先分正负,然后再想想
// 找到所有正负相等的元组
        final HashSet<Integer> ans = new HashSet<>();
        final HashSet<Integer> z正数 = new HashSet<>();
        final HashSet<Integer> f负数 = new HashSet<>();
        筛选正负(nums, z正数, f负数);
// 从正数中对于每个筛
        List<List<Integer>> lists = new ArrayList<>();
        z正数.forEach(zz -> {
            f负数.forEach(fff -> {
                int i = zz - fff;
// find i in zSet or fSet
                if (z正数.contains(i) || f负数.contains(-i)) {
                    lists.add(List.of(zz, fff, i));
                }
            });
        });
        return lists;
    }

    private List<List<Integer>> handleZero(int[] nums) { // ??????????
        final HashSet<Integer> ans = new HashSet<>();
        final HashSet<Integer> z正数 = new HashSet<>();
        final HashSet<Integer> f负数 = new HashSet<>();
        筛选正负(nums, z正数, f负数);
        z正数.retainAll(f负数);

        List<List<Integer>> lists = new ArrayList<>();
        z正数.forEach(integer -> lists.add(List.of(0, integer, -integer)));
        return lists;
    }

    private void 筛选正负(
            int[] nums, HashSet<Integer> z正数,
            HashSet<Integer> f负数) {
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            if (num > 0) {
                z正数.add(num);
            } else {
                f负数.add(-num);
            }
        }
    }

    private int zeroCount(int[] nums) {
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                sum++;
            }
        }
        return sum;
    }
}

//leetcode submit region end(Prohibit modification and deletion)
