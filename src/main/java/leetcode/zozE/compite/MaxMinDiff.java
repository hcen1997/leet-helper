package leetcode.zozE.compite;

import org.junit.Test;

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
    @Test
    public void t3(){
        new Solution3().minImpossibleOR(null);
    }

    class Solution3 {
        public int minImpossibleOR(int[] nums) {
//            // 如果全是 1,2,4,8,16.... 最终答案是 16*2
//            // 如果 没有 一些特殊值, 只是 3,7,15 ... 答案就是1/  1,2,3,7,15  第四位的数能表达吗?
//            Arrays.sort(nums);
//            // ans <= nums[last] *2
//            for (int i = 1; i < 1000000; i++) {
//                isOk(data,nums[i],i)?continue:i;
//            }
//            return max_data +1;
            return 0;
        }
    }
}
