package leetcode.level.easy.rand4;

public class RunningSumOf1DArray {
    public int[] runningSum(int[] nums) {
        int[] clone = nums.clone();
        for (int i = 1; i < clone.length; i++) {
            clone[i] = clone[i]+clone[i-1];
        }

        return clone;
    }
}
