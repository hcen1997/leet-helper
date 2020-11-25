package leetcode.editor.cn;

public class PowerOfTwo {
    public static void main(String[] args) {
        boolean powerOfTwo = new PowerOfTwo().isPowerOfTwo(64);
        System.out.println("powerOfTwo = " + powerOfTwo);
    }
    public boolean isPowerOfTwo(int n) {
        if (n <= 0) {
            return false;
        }
        int has1 = 0;
        while (n>0) {
            has1 += n & 1;
            n = n >> 1;
        }
        return has1==1;
    }
}
