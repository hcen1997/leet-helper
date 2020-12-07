package leetcode.easy.rand2;

import java.util.Arrays;

public class StringToUrl {
    public String replaceSpaces(String S, int length) {
        char[] s = S.toCharArray();
        char[] sp = {'%', '2', '0'};
        char[] sc = s.clone();
        int j = 0;
        for (int i = 0; i < length; i++) {
            if (s[i] == ' ') {
                copy(sc, sp, j);
                j += sp.length;
            } else {
                sc[j] = s[i];
                j++;
            }
        }
        if (sc[sc.length-1] == ' ') {
            for (j = s.length - 1; j > 0; j--) {
                if (sc[j] == ' ') {
                    break;
                }
            }
            return String.valueOf(sc).substring(0, j-2);
        }
        return String.valueOf(sc);
    }

    void copy(char[] s1, char[] s2, int start) {
        for (int i = 0; i < s2.length; i++) {
            s1[i + start] = s2[i];
        }
    }
}
