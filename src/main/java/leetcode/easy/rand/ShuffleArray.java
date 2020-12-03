package leetcode.easy.rand;

public class ShuffleArray {
    public int[] shuffle(int[] nums, int n) {
        int[] ans = new int[nums.length];
        for (int i = 0; i < n; i++) {
            ans[i * 2 ] = nums[i];
        }
        for (int i = n; i < 2 * n; i++) {
            ans[(i - n) * 2 - 1] = nums[i];
        }
        return ans;
    }

    void swap(int[] ints, int a, int b) {
        int tmp = ints[a];
        ints[a] = ints[b];
        ints[b] = tmp;
    }
}
