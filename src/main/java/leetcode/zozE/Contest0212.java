package leetcode.zozE;

import java.util.ArrayList;

public class Contest0212 {
    class Solution {
        public long findTheArrayConcVal(int[] nums) {
            int first = 0;
            int last = nums.length - 1;
            long ans = 0;
            while (first <= last) {
                if (first != last) {
                    ans+= Long.parseLong(Integer.toString(nums[first])+Integer.toString(nums[last]));
                } else {
                    ans+=nums[first];
                }
                first++;
                last--;
            }
            return ans;
        }
    }
}
