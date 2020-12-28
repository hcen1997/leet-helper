package leetcode.level.easy.two;

import java.util.ArrayList;
import java.util.HashMap;

public class Intersect {
    public int[] intersect(int[] nums1, int[] nums2) {
        // 使用hashmap
        HashMap<Integer, Integer> m1 = new HashMap<>();
        ArrayList<Integer> ans = new ArrayList<>();
        for (int i : nums1) {
            Integer v;
            if ((v = m1.get(i)) != null) {
                m1.put(i, v + 1);
            } else {
                m1.put(i, 1);
            }
        }
        for (int i : nums2) {
            Integer v;
            if ((v = m1.get(i)) != null) {
                ans.add(i);
                v = v - 1;
                if (v == 0) {
                    m1.remove(i);
                } else {
                    m1.put(i, v);
                }
            }
        }
        return toArray(ans);
    }
    public  int[] toArray(ArrayList<Integer> nums){
        int[] ints = new int[nums.size()];
        for (int i = 0; i < ints.length; i++) {
            ints[i] = nums.get(i);
        }
        return ints;
    }
}

