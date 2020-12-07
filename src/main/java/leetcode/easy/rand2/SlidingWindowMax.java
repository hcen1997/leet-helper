package leetcode.easy.rand2;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class SlidingWindowMax {

    public int[] maxSlidingWindow1(int[] nums, int k) {
        // 维护最大数
        // 最大数如果出去触发堆重建
        return nums;
    }

    public int[] maxSlidingWindow(int[] nums, int k) {
        if (k == 1) {
            return nums;
        }
        if (k == nums.length) {
            int max = Arrays.stream(nums).max().getAsInt();
            return new int[]{max};
        }
        // 初始化
        int size = nums.length - k + 1;
        int[] ans = new int[size];
        PriorityQueue<Integer> bigger = new PriorityQueue<>(k, Comparator.reverseOrder());
        for (int i = 0; i < nums.length; i++) {
            bigger.add(nums[i]);
            if (i > k - 1) {
                bigger.remove(nums[i - k]);
            }
            if (i >= k - 1) {
                ans[i - k + 1] = bigger.peek();
            }
        }
        return ans;
    }
}
