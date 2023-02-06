package leetcode.easy.rand3;

public class Jump {
    public int missingNumber(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int[] ints = new int[nums.length + 1];
        for (int i = 0; i < nums.length; i++) {
            ints[nums[i]] = 1;
        }

        for (int i = 0; i < ints.length; i++) {
            if (ints[i] == 0) {
                return i;
            }
        }
        return -1;
    }
}
