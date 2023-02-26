package leetcode.zozE;

import java.util.Arrays;

public class MaxScoreWords {
    class Solution {

        public int maxScoreWords(String[] words, char[] letters, int[] score) {
            int n = words.length;
            int [] key = new int[26];
            for (char c : letters) {
                key[c-'a'] ++;
            }
            // 2进制表示  子集生成 顺序查找判断  加速计算缓存
            int target = 1<<n;
            int max = 0;
            for (int i = 1; i < target; i++) {
                max = canMakeWordGetScore(words,i,key,score);
            }
            return max;
        }

        private int canMakeWordGetScore(String[] words, int i, int[] key, int[] score) {
            int ans = 0;int v;
            int [] cache = Arrays.copyOf(key,key.length);
            int index = 0;
            while ((1<<index)<=i ){ // 不能全部放置就返回0 不然返回所有值
                if(((1<<index) & i) >0){
                    String t =  words[index];
                    for (int i1 = 0; i1 < t.length(); i1++) {
                        v = t.charAt(i1) - 'a';
                        if(cache[v]>0){
                            cache[v]--;
                            ans += score[v];
                        }else {
                            return 0;
                        }
                    }
                }
               index ++;
            }
            return ans;
        }
    }
}
