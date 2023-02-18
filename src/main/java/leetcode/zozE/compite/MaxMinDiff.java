package leetcode.zozE.compite;

import java.util.Arrays;

public class MaxMinDiff {
    class Solution {
        public int minMaxDifference(int num) {
            // 第一感觉是 把前面的值变成0/9
            String n = Integer.toString(num);
            String c = n.substring(0, 1);
            int min = Integer.parseInt(n.replaceAll(c, "0"));
            int i = 0;
            while ((c = n.substring(i, i + 1)).equals("9") && i < n.length() - 1) i++;
            if (i >= n.length()) {
                return num - min;
            }
            int max = Integer.parseInt(n.replaceAll(c, "9"));
            return max - min;
        }
    }

    class Solution2 {
            public int minimizeSum(int[] nums) {
                if (nums.length == 3) return 0;
                Arrays.sort(nums);
                // 先删一个 然后看剩下的, 然后再删剩下的中的一个, 然后答案是剩下的中的取值
                // 第一次肯定是去掉头 /尾
                // 去掉2个, 只有几种方法
                int q = minimizeSum(nums, 1, nums.length - 2);
                int w = minimizeSum(nums, 2, nums.length-1);
                int e = minimizeSum(nums, 0, nums.length - 3);
                int r = e;
                q = q < w ? q : w;
                e = e < r ? e : r;
                return q < e ? q : e;
            }

            // 末尾算
            private int minimizeSum(int[] nums, int l, int r) {
                int min = 1000000009, max = 0;
                max = nums[r] - nums[l];
                return max;
            }
    }
}
