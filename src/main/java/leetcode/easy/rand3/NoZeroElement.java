package leetcode.easy.rand3;

public class NoZeroElement {
    public int[] getNoZeroIntegers(int n) {
        int[] ans = new int[2];
        for (int i = 1; i <= n/2; i++) {
            if(!hasZero(i)){
                if(!hasZero(n-i)){
                    ans[0] = i;
                    ans[1] = n-i;
                    break;
                }
            }
        }
        return ans;
    }

    private boolean hasZero(int i) {
        return String.valueOf(i).contains("0");
    }
}
