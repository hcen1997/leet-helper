package leetcode.editor.cn;

import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class ContainDupl {
    public boolean containsDuplicate(int[] nums) {
        ArrayList<Integer> integers = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            integers.add(nums[i]);
        }
        HashSet<Integer> integers1 = new HashSet<>(integers);
        return integers.size() != integers1.size();
    }
}
