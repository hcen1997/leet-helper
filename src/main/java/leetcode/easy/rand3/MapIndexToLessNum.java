package leetcode.easy.rand3;

import java.util.Arrays;
import java.util.Comparator;

public class MapIndexToLessNum {
    public int[] smallerNumbersThanCurrent(int[] nums) {
        Par[] sorted = new Par[nums.length];
        for (int i = 0; i < nums.length; i++) {
            sorted[i] = new Par(i, nums[i]);
        }
        Arrays.sort(sorted, Comparator.comparingInt(o -> o.value));
        // 为重复值赋值
        handleDup(sorted);

        int[] ans = new int[nums.length];
        for (int i = 0; i < sorted.length; i++) {
            Par par = sorted[i];
            ans[par.index] = par.blow;
        }

        return ans;


    }

    private void handleDup(Par[] sorted) {
        int count =0;
        sorted[0].blow=0;
        for (int i = 0; i < sorted.length; i++) {
            if(sorted[i].value!=sorted[i-1].value){
                count=i;
            }
            sorted[i].blow = count;
        }
    }

    class Par {
        Par(int i, int v) {
            index = i;
            value = v;
        }

        public int index;
        public int value;
        public int blow;
    }
}
