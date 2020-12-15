package leetcode.hard;

import java.util.Arrays;

public class LastSubInLexOrd {
        public String lastSubstring(String s) {
            int[] minPosi = new int[26];
            Arrays.fill(minPosi,s.length()+1);
            for (int i = 0; i < s.length(); i++) {
                int ch = s.charAt(i)-'a';
                minPosi[ch] = Math.min(i,minPosi[ch]);
            }
            int max = 0;
            for (int i = minPosi.length-1; i >=0; i--) {
                if(minPosi[i]!=s.length()+1){
                    max = i;
                    break;
                }
            }
            return s.substring(minPosi[max]);
        }
}
