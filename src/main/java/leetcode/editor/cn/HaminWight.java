package leetcode.editor.cn;

public class HaminWight {
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
}
