package leetcode.editor.cn;

public class HammingWight {
    // 分治法求解 HammingWight
    // n = b0 + b1*2 +b2*2^2 + ... + b31*2^31
    // n>>>1 = b1 + b2*2^1 + ... + b31*2^30
    // n>>>1 & 0x55555555 (0101) =  xx =
    //     b1 + b3*2^2 + b5*2^4 + ... + b31*2^30
    // n&0x55555555 =  xxy  =
    //     b0 + b2*2^2 + ... + b30*2^30
    //  n = xxy + xx + xx

    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int ans = 0;
        for (int i = 0; i < 32; i++) {
            int last = n&1;
            ans +=last;
            n = n >> 1;
        }
        return ans;
    }

    // you need to treat n as an unsigned value
    public int hammingWeight1(int n) {
        int i = n;

        i = i - ((i >>> 1) & 0x55555555);
        i = (i & 0x33333333) + ((i >>> 2) & 0x33333333);
        i = (i + (i >>> 4)) & 0x0f0f0f0f;
        i = i + (i >>> 8);
        i = i + (i >>> 16);
        return i & 0x3f;
    }
}
