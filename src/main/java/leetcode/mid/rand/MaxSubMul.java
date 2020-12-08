package leetcode.mid.rand;

public class MaxSubMul {
    public int maxProduct(int[] nums) {
        long max = Long.MIN_VALUE;

        for (int i = 0; i < nums.length ; i++) {
            for (int j = i; j < nums.length; j++) {
                max = Math.max(max, calSub(nums, i, j));
            }
        }
        return (int) max;
    }

    long calSub(int[] n, int s, int e) {
        long ans = 1;
        for (int i = s; i <= e; i++) {
            ans *= n[i];
        }
        return ans;
    }
}
