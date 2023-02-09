package leetcode.zozE;

import java.util.*;

public class GroupAnagrams {


    class Solution {
        // 找到一个容器, 可以代表一个字符串的整体情况, 然后
        public void genPrime(int[] table) {
            int c = 0;
            for (int i = 0; i < 1000; i++) {
                boolean find = false;
                for (int j = 2; j < i; j++) {
                    if (i % j == 0) {
                        find = true;
                        break;
                    }
                }
                if (!find) {
                    table[c] = i;
                    c++;
                    if (c > 27) {
                        break;
                    }
                }
            }
        }

        public List<List<String>> groupAnagrams(String[] strs) {
            int[] table = new int[29];
            genPrime(table);
            System.out.println(Arrays.toString(table));
            Map<Long, List<String>> cache = new HashMap<>();

            for (String str : strs) {
                long key = wordToInt(str, table);
                cache.putIfAbsent(key, new ArrayList<>());
                cache.get(key).add(str);
            }
            List<List<String>> ans = new ArrayList<>();
            for (Long aLong : cache.keySet()) {
                ans.add(cache.get(aLong));
            }

            return ans;
        }

        public long wordToInt(String s, int[] table) {
//            BitSet ans = new BitSet(26);
            long ans = 1;
            for (int i = 0; i < s.length(); i++) {
                ans *= table[s.charAt(i) - 'a' + 1];
            }
            return ans;
        }
    }
}
