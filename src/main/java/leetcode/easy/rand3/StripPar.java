package leetcode.easy.rand3;

import java.util.stream.IntStream;

public class StripPar {
    public String removeOuterParentheses(String S) {
        int outStack = 0;
        int inStack = 0;
        int outHead = 0;
        char[] chars = S.toCharArray();
        String ans = "";
        for (int i = 0; i < chars.length; i++) {
            char aChar = chars[i];
            if (aChar == '(') {
                if (outStack == 0) {
                    outHead = i;
                    outStack++;
                } else {
                    inStack++;
                }
            } else if (aChar == ')') {
                if (inStack != 0) {
                    inStack--;
                } else {
                    outStack--;
                }
                if (outStack == 0) {
                    ans += S.substring(outHead + 1, i);
                }
            }
        }
        return ans;
    }
}
