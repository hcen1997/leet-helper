package leetcode.easy.rand4;

public class BinaryInsert {
    public int insertBits(int N, int M, int i, int j) {
        String n = Integer.toBinaryString(N);
        String m = Integer.toBinaryString(M);
        if (n.length() != 32) {
            n = "0".repeat(32 - n.length()) + n;
        }
        if (m.length() != j - i + 1) {
            m = "0".repeat(j - i + 1 - m.length()) + m;
        }
        int ri = n.length()  - i;
        int rj = n.length() - 1 - j;
        String substring = n.substring(0, rj);
        String substring1 = n.substring(ri);
        String ans = substring + m + substring1;
        int i1 = Integer.parseInt(ans, 2);
        return i1;
    }
}
