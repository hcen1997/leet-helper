package leetcode.zozz.winter;

import org.junit.Test;

import java.util.concurrent.ThreadLocalRandom;

public class sum_of_two_integers {
    //    给你两个整数 a 和 b ，不使用 运算符 + 和 - ​​​​​​​，计算并返回两整数之和。
    @Test
    public void tt() {
        Solution solution = new Solution();
        int i = -1000;
        while (i <= 1000) {
            int j = -1000;
            while (j <= 1000) {
                i += ThreadLocalRandom.current().nextInt(0, 3);
                j += ThreadLocalRandom.current().nextInt(0, 3);
                int sum = solution.forfor(i, j);
                if (sum != i + j) {
                    System.out.println("i,j,i+j " + i + " " + j + "  " + (i + j) + " sum " + solution.getSum(i, j));
                    debug = true;
                    solution.getSum(i, j);
                    System.out.println("i+j = " + Integer.toBinaryString(i + j));
                    System.out.println();
                    debug = false;
                }
            }
        }
    }

    boolean debug = false;

    class Solution {
        public int getSum(int a, int b) {
            int c = a ^ b;
            int cr = (a & b) << 1;
            if (debug) {
                System.out.println("a=" + Integer.toBinaryString(a));
                System.out.println("b=" + Integer.toBinaryString(b));
                System.out.println("(a^b)=" + Integer.toBinaryString(c));
                System.out.println("(a&b)<<1=" + Integer.toBinaryString(cr));
                System.out.println("(a ^ b) | ((a & b) << 1)=" + Integer.toBinaryString(c | cr));
            }
            if (cr != 0) {
                return getSum(c, cr);
            } else {
                return c;
            }
        }

        // 循环方式 可以用++
        public int forfor(int a, int b) {
            int ans = 0, t = 0;
            for (int i = 0; i < Integer.SIZE; i++) {
                int u1 = (a >> i) & 1, u2 = (b >> i) & 1;
                if (u1 == 0 && u2 == 0) {
                    ans = ans | (t << i);
                    t = 0;
                } else if (u1 == 1 && u2 == 1) {
                    ans = ans | (t << i);
                    t = 1;
                } else {
                    // 有一个是1
                    ans = ans | ((1 ^ t) << i);
                }
            }

            return ans;
        }

    }
}


