package leetcode.zozE.compite;

import java.util.ArrayList;
import java.util.List;

public class SingleWeek0219 {
    class Solution {
        public int[][] mergeArrays(int[][] nums1, int[][] nums2) {
            List<int[]> ans = new ArrayList<>();
            int n1 = 0, n2 = 0;
            while (n1 < nums1.length && n2 < nums2.length) {
                if (nums1[n1][0] == nums2[n2][0]) {
                    nums1[n1][1] = nums1[n1][1] + nums2[n2][1];
                    ans.add(nums1[n1]);
                    n1++;
                    n2++;
                } else if (nums1[n1][0] < nums2[n2][0]) {
                    ans.add(nums1[n1]);
                    n1++;
                } else {
                    ans.add(nums2[n2]);
                    n2++;
                }
            }
            while (n1 < nums1.length) {
                ans.add(nums1[n1]);
                n1++;
            }
            while (n2 < nums2.length) {
                ans.add(nums2[n2]);
                n2++;
            }

            return ans.toArray(new int[0][0]);
        }
    }
}
