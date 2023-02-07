package leetcode.zozE;

import java.util.HashMap;

public class SumTwo {
    class Solution {
        public int[] twoSum(int[] nums, int target) {
            for (int i = 0; i < nums.length - 1; i++) {
                for (int j = i + 1; j < nums.length; j++) {
                    if (nums[i] + nums[j] == target) {
                        return new int[]{i, j};
                    }
                }
            }
            return new int[]{};
        }

        public int[] twoSumFast(int[] nums, int target) {
            HashMap<Integer, Integer> cache = new HashMap<>();
            for (int i = 0; i < nums.length; i++) {
                if (cache.containsKey(target - nums[i]) && cache.get(target - nums[i]) != i) {
                    return new int[]{i, cache.get(target - nums[i])};
                }
                cache.put(nums[i], i);
            }
            return new int[]{};
        }
    }
}
