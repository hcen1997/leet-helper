package leetcode.zozz.winter;

import org.junit.Assert;
import org.junit.Test;

/**
 * 一条包含字母 A-Z 的消息通过以下的方式进行了编码：
 * <p>
 * 'A' -> 1
 * 'B' -> 2
 * ...
 * 'Z' -> 26
 * <p>
 * 要 解码 一条已编码的消息，所有的数字都必须分组，然后按原来的编码方案反向映射回字母（可能存在多种方式）。例如，"11106" 可以映射为：
 * <p>
 * "AAJF" 对应分组 (1 1 10 6)
 * "KJF" 对应分组 (11 10 6)
 * <p>
 * 注意，像 (1 11 06) 这样的分组是无效的，因为 "06" 不可以映射为 'F' ，因为 "6" 与 "06" 不同。
 * <p>
 * 除了 上面描述的数字字母映射方案，编码消息中可能包含 '*' 字符，可以表示从 '1' 到 '9' 的任一数字（不包括 '0'）。例如，编码字符串 "1*" 可以表示 "11"、"12"、"13"、"14"、"15"、"16"、"17"、"18" 或 "19" 中的任意一条消息。对 "1*" 进行解码，相当于解码该字符串可以表示的任何编码消息。
 * <p>
 * 给你一个字符串 s ，由数字和 '*' 字符组成，返回 解码 该字符串的方法 数目 。
 * <p>
 * 由于答案数目可能非常大，返回对 109 + 7 取余 的结果。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "*"
 * 输出：9
 * 解释：这一条编码消息可以表示 "1"、"2"、"3"、"4"、"5"、"6"、"7"、"8" 或 "9" 中的任意一条。
 * 可以分别解码成字符串 "A"、"B"、"C"、"D"、"E"、"F"、"G"、"H" 和 "I" 。
 * 因此，"*" 总共有 9 种解码方法。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/decode-ways-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class decode_ways_ii {

    @Test
    public void tt() {
        Solution s = new Solution();
        Assert.assertEquals(s.numDecodings("*"), 9);


    }

    class Solution {
        // 一次读一个, 一次读两个
        // 读一个 0种解码, 1种解码 9种解码
        // 读2个 0种解码, 1种解码 n种解码
        // 定义  f[i] 为考虑以  s[i] 为结尾的字符串，共有多少种解码方案。
        public int numDecodings(String s) {
            if (s.length() == 0 || s.startsWith("0")) {
                return 0;
            }
            int ceiling = 1000_000_000 + 7;
            int sum = 1 % ceiling;
            char[] chars = s.toCharArray();
            for (int i = 0; i < chars.length; i++) {
                char aChar = chars[i];
                if (aChar - '0' >= 3) {
                    continue;
                } else if (aChar == '1') {
                    if (i == chars.length - 1 || chars[i + 1] == '0') {
                    } else if (chars[i + 1] != '*') {
                        sum = sum * 2 % ceiling;
                    } else if (chars[i + 1] == '*') {
                        sum = sum * 18 % ceiling;
                    }
                } else if (aChar == '2') {
                    if (i == chars.length - 1 || chars[i + 1] == '0') {
                    } else if (chars[i + 1] - '0' >= 1 && chars[i + 1] - '0' <= 6) {
                        sum = sum * 2 % ceiling;
                    } else if (chars[i + 1] == '*') {
                        sum = sum * 15 % ceiling;
                    }
                } else if (aChar == '*') {
                    if (i == chars.length - 1) {
                    } else if (chars[i + 1] == '0') {
                        sum = sum * 2 % ceiling;
                    } else {
                        if (chars[i + 1] != '*') {
                            sum = sum * 2 % ceiling;
                        } else {
                            sum = sum * 9 % ceiling;
                        }
                    }
                }
            }
            return sum;
        }
        // 分解的格式  ->  有2k种分法
        // 每种分法有多少种排列   综合

        // 先不考虑*
        // 0 0
        // 0* 0
        // 1-9 1
        // *1, *2, ** 9
        // 10 1  20 1
        // 1[1-9] 2
        // 2[1-6] 12
        // 2[7-9]
        // 3-9  不取2个
        private int numDecodings(char[] chars, int i) {

            return 0;
        }
    }
}
