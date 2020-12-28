package leetcode.level.easy.two;

import java.util.Arrays;


public class ValidAnagram {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        int[] sh = hash(s);
        int[] th = hash(t);
        // 如果有unicode呢? HashMap<char,int>
        return Arrays.equals(sh, th);
    }

    private int[] hash(String s) {
        int[] alpha = new int[26];
        char[] chars = s.toCharArray();
        for (char aChar : chars) {
            int index = aChar - 'a';
            alpha[index]++;
        }
        return alpha;
    }
}
