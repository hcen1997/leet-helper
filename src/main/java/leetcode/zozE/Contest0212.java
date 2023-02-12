package leetcode.zozE;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Contest0212 {
    class Solution1 {
        public long findTheArrayConcVal(int[] nums) {
            int first = 0;
            int last = nums.length - 1;
            long ans = 0;
            while (first <= last) {
                if (first != last) {
                    ans += Long.parseLong(Integer.toString(nums[first]) + Integer.toString(nums[last]));
                } else {
                    ans += nums[first];
                }
                first++;
                last--;
            }
            return ans;
        }
    }

    class Solution2 {
        public long countFairPairs(int[] nums, int lower, int upper) {
            Arrays.sort(nums);
            long ans = 0;
            for (int i = 0; i < nums.length; i++) {
                int lo = lower - nums[i];
                int up = upper - nums[i];
                int il = Arrays.binarySearch(nums, lo);
                int iu = Arrays.binarySearch(nums, up);
            }
            return ans;
        }
    }

    class Solution3 {
        public int[][] substringXorQueries(String s, int[][] queries) {
            int[][] ans = new int[queries.length][2];
            Map<String, Integer> cache = new HashMap<>();
            genCache(cache, s);
            for (int i = 0; i < queries.length; i++) {
                int target = queries[i][1] ^ queries[i][0];
                int st = -1;
                int ed = -1;
                String b = Integer.toBinaryString(target);
                int start = cache.getOrDefault(b, -1);
                if (start >= 0) {
                    st = start;
                    ed = start + b.length() - 1;
                }
                ans[i][0] = st;
                ans[i][1] = ed;
            }
            return ans;
        }

        // 返回s上找到i字符串的索引  on logn 算法
        private void genCache(Map<String, Integer> cache, String s) {
            // 32位长
            cache.put("0", s.indexOf('0'));
            cache.put("1", s.indexOf('1'));
            for (int i = 2; i <= 32; i++) {
                int cnt = 1 << i;
                for (int j = 0; j < s.length(); j++) {
                    if (s.charAt(j) == '0') continue;
                    if (j + i > s.length()) break;
                    if (cnt == 0) break;
                    String substring = s.substring(j, j + i);
                    if (cache.containsKey(substring)) continue;
                    cache.put(substring, j);
                    cnt--;
                }
            }
        }
    }
}
