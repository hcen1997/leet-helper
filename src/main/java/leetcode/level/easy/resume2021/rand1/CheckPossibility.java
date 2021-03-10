package leetcode.level.easy.resume2021.rand1;

import java.util.ArrayList;
import java.util.List;

public class CheckPossibility {
    public boolean checkPossibility(int[] nums) {
        List<Integer> breaken = findAllBreak(nums);
        if (breaken.size() >= 2) {
            return false;
        }else if(breaken.size()==0){
            return true;
        }
        // 尝试修复唯一的节点  只有一个才能修
        boolean canFix = tryFix(nums,breaken.get(0));
        return canFix;
    }

    private boolean tryFix(int[] nums, Integer brokenHead) {
        int length = nums.length;
        // 边界处理
        if(brokenHead ==0 || brokenHead  ==length-2){
            return true;
        }
        // 全等head
        int[] tryH = {nums[brokenHead-1],nums[brokenHead],nums[brokenHead],nums[brokenHead+2]};
        int brokenLast = brokenHead+1;
        // 全等last
        int[] tryL = {nums[brokenHead-1],nums[brokenLast],nums[brokenLast],nums[brokenLast+1]};
        return easyCheck(tryH) || easyCheck(tryL);
    }

    private boolean easyCheck(int[] nums) {
        if (nums.length<=2){
            return true;
        }
        for (int i = 0; i < nums.length - 1; i++) {
            // rule
            boolean rule = nums[i] <= nums[i + 1];
            if (!rule) {
                return false;
            }
        }
        return true;
    }

    private List<Integer> findAllBreak(int[] nums) {
        List<Integer> breaken = new ArrayList<>();
        for (int i = 0; i < nums.length - 1; i++) {
            // rule
            boolean rule = nums[i] <= nums[i + 1];
            if (!rule) {
                breaken.add(i);
            }
        }
        return breaken;
    }
}
