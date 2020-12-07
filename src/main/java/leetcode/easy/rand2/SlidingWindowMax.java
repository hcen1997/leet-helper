package leetcode.easy.rand2;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class SlidingWindowMax {

    public int[] maxSlidingWindow(int[] nums, int k) {
        if(nums.length<50000){
            return maxSlidingWindow1(nums,k);
        }
        // 维护最大数
        // 最大数如果出去触发堆重建
        int size = nums.length - k + 1;
        int[] ans = new int[size];
        int maxCount = 0;
        int big = Integer.MAX_VALUE;
        PriorityQueue<Integer> bigger = new PriorityQueue<>(k, Comparator.reverseOrder());
        for (int i = 0; i < nums.length; i++) {
            bigger.add(nums[i]);
            if (i > k - 1&& nums[i-k]==bigger.peek()) {
                maxCount--;
                if(maxCount==0){
                    bigger.clear();
                    for (int j = i-k; j <= i; j++) {
                        bigger.add(nums[j]);
                    }
                }
            }
            if (i >= k - 1) {
                ans[i - k + 1] = bigger.peek();
                big = bigger.peek();
                maxCount++;
            }
        }
        return ans;
    }

    public int[] maxSlidingWindow1(int[] nums, int k) {
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
