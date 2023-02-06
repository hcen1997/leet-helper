package leetcode.easy.rand3;

import java.util.Arrays;

public class MaxThreeSum {
    public int maximumProduct(int[] nums) {
        Arrays.sort(nums);
        if(nums.length==3){
            return mun(nums,0,1,2);
        }
        //

                return 1;

    }

    private int mun(int[] nums, int i, int ii, int iii) {
        return nums[i] * nums[iii] * nums[ii];
    }
}
