package leetcode.easy.rand;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class ContainDuplicate {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer, Integer> valIndex = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (!valIndex.containsKey(nums[i])) {
                valIndex.put(nums[i], i);
            } else {
                int indexPast = valIndex.get(nums[i]);
                if(i-indexPast<=k){
                    return true;
                }else {
                    valIndex.put(nums[i], i);
                }
            }
        }
        return false;
    }

    class ValIndex {
        public int val;
        public int index;
    }
}
