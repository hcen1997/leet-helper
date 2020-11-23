package leetcode.editor.cn;
//给你一个字符串 s 和一个字符规律 p，请你来实现一个支持 '.' 和 '*' 的正则表达式匹配。
//
// 
// '.' 匹配任意单个字符 
// '*' 匹配零个或多个前面的那一个元素 
// 
//
// 所谓匹配，是要涵盖 整个 字符串 s的，而不是部分字符串。 
// 
//
// 示例 1： 
//
// 
//输入：s = "aa" p = "a"
//输出：false
//解释："a" 无法匹配 "aa" 整个字符串。
// 
//
// 示例 2: 
//
// 
//输入：s = "aa" p = "a*"
//输出：true
//解释：因为 '*' 代表可以匹配零个或多个前面的那一个元素, 在这里前面的元素就是 'a'。因此，字符串 "aa" 可被视为 'a' 重复了一次。
// 
//
// 示例 3： 
//
// 
//输入：s = "ab" p = ".*"
//输出：true
//解释：".*" 表示可匹配零个或多个（'*'）任意字符（'.'）。
// 
//
// 示例 4： 
//
// 
//输入：s = "aab" p = "c*a*b"
//输出：true
//解释：因为 '*' 表示零个或多个，这里 'c' 为 0 个, 'a' 被重复一次。因此可以匹配字符串 "aab"。
// 
//
// 示例 5： 
//
// 
//输入：s = "mississippi" p = "mis*is*p*."
//输出：false 
//
// 
//
// 提示： 
//
// 
// 0 <= s.length <= 20 
// 0 <= p.length <= 30 
// s 可能为空，且只包含从 a-z 的小写字母。 
// p 可能为空，且只包含从 a-z 的小写字母，以及字符 . 和 *。 
// 保证每次出现字符 * 时，前面都匹配到有效的字符 
// 
// Related Topics 字符串 动态规划 回溯算法 
// 👍 1687 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean isMatch(String s, String p) {
        int sp = 0;
        int pp = 0;
        for (; sp < s.length(); ) {
            final String sS = s.substring(sp);
            final String pS = nextMatcher(p, pp);
            if (pS.length() == 0) {
                break;
            }
            final int matchNum = match(sS, pS);
            if (matchNum == -1) {
                break;
            }
            sp += matchNum;
            pp += pS.length();
        }
        return sp == s.length();
    }

    /**
     * @return a-z . a*-z* .*
     */
    private String nextMatcher(String p, int pp) {
        if (pp >= p.length()) {
            return "";
        }
        if (pp + 1 < p.length() && p.charAt(pp + 1) == '*') {
            return p.substring(pp, pp + 2);
        } else {
            return p.substring(pp, pp + 1);
        }
    }

    private int match(String sS, String pS) {
        final char[] sCs = sS.toCharArray();
        final char[] pCs = pS.toCharArray();
        final char pC = pCs[0];
        if (pCs.length == 2) {
            int maNum = 0;
            for (; maNum < sCs.length; maNum++) {
                if (!match(sCs[maNum], pC)) {
                    break;
                }
            }
            return maNum;
        } else {
            return match(sCs[0], pC) ? 1 : -1;
        }
    }

    private boolean match(char s, char p) {
        return s == p || p == '.';
    }
}
//leetcode submit region end(Prohibit modification and deletion)
