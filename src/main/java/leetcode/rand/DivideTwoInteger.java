package leetcode.rand;

public class DivideTwoInteger {
    /**
     * @param dividend [−231,  231 − 1]
     * @param divisor  [−231,  231 − 1]  without 0
     * @return dend/disor . 2^31-1 if overflow
     */
    public int divide(int dividend, int divisor) {
        // 1/1 1/-1 -1/1 -1/-1
        int sigA = Integer.signum(dividend);
        int sigB = Integer.signum(divisor);
        // 处理溢出
        int sigOverflow = Integer.MAX_VALUE;
        if(divisor==1){
            return dividend;
        }
        if (divisor == Integer.MIN_VALUE) {
            if (dividend == Integer.MIN_VALUE) {
                return 1;
            }
            return 0;
        }
        if (dividend == Integer.MIN_VALUE && divisor == -1) {
            return sigOverflow;
        }else if(dividend == Integer.MIN_VALUE) {
            int big =  -divide(Integer.MAX_VALUE,divisor);
            big += divide(-2,divisor);
            return big;
        }
        int absA = Math.abs(dividend);
        int absB = Math.abs(divisor);
        int ans = plantDiv(absA, absB);
        return sigA + sigB != 0 ? ans : -ans;
    }

    /**
     * @param a >=0
     * @param b > 0
     * @return a/b
     */
    int plantDiv(int a, int b) {
        // 除法的本质是 看a中能容纳下几个b
        if (a == b) {
            return 1;
        }
        if (a < b) {
            return 0;
        }
        return plantDivFast(a, b);
    }

    /**
     * 位运算加速
     *
     * @param a a>b
     * @param b
     * @return
     */
    int plantDivFast(int a, int b) {
        int sb = Integer.numberOfLeadingZeros(b);
        int ans = 0;
//        System.out.print("a = " + a);
//        System.out.println(" b = " + b);
        for (int i = sb - 1; a >= b; i--) {
            if (b << i > a) {
                continue;
            } else {
                a = a - (b << i);
                ans += 1 << i;
//            System.out.print("i = " + i);
//            System.out.print(" a = " + a);
//            System.out.print(" b = " + b);
//            System.out.println(" ans = " + ans);
            }
        }
        return ans;
    }

}
