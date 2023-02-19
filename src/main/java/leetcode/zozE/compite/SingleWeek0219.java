package leetcode.zozE.compite;

import org.junit.Test;

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

    @Test
    public void t1() {
        new Solution2().minOperations(39);
    }

    class Solution2 {
        public int minOperations(int n) {
            // 最笨的方法是 直接减  n中每一个bit都减掉对应的2**
            //System.out.println(Integer.toBinaryString(n));

            String s = Integer.toBinaryString(n);
            int i = 0;
            int ans = 0;
            while ((i = hasConnectOne(s)) > 0) {
                int add = 1 << s.length() - 1 - i;
                //System.out.println(add);
                n += add;
                ans++;
                s = Integer.toBinaryString(n);
            }
            return ans + countOne(s);

        }

        private int countOne(String s) {
            int i, ans = 0;
            for (int i1 = 0; i1 < s.length(); i1++) {
                ans += s.charAt(i1) == '1' ? 1 : 0;
            }
            return ans;
        }

        private int hasConnectOne(String s) {
            int i;
            for (i = s.length() - 1; i > 0; i--) {
                if (s.charAt(i) == '1' && s.charAt(i - 1) == '1') {
                    return i;
                }
            }
            return i;
        }
    }
}
