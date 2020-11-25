package leetcode.editor.cn;

public class ReverseBits {
    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        int ans = 0;
        for (int i = 0; i < 32; i++) {
            int last = n & 1;
            ans = (ans<<1)+last;
            n = n>>1;
        }
        return ans;
    }
}
