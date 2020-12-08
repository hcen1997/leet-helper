package leetcode.easy.rand2;

class NumArray {

    private int[] sums;

    public NumArray(int[] nums) {
        sums = nums.clone();
        for (int i = 0; i < sums.length - 1; i++) {
            sums[i + 1] = sums[i] + sums[i + 1];
        }
    }

    public int sumRange(int i, int j) {
        if(i==0){
            return sums[j];
        }
        return sums[j] - sums[i-1];
    }
}