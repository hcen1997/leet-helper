package leetcode.level.easy.two;

public class PowerOfThree {
    public static void main(String[] args) {
        PowerOfThree powerOfThree = new PowerOfThree();
        long st = System.currentTimeMillis();
        for (int i = 0;i!=1888000; i++) {
            powerOfThree.isPowerOfThree(i);
        }
        System.out.println("run time: "+ (System.currentTimeMillis()-st));
    }
    public boolean isPowerOfThree2(int n) {
        return n > 0 && 1162261467%n == 0;
    }
    public boolean isPowerOfThree(int n) {
        int[] threes = initThreePower();
        // 二分优化 没啥用
        int s = 0, e = threes.length-1;
        int mid = (s + e) / 2;
        while (s <= e) {
            if (n == threes[mid]) {
                return true;
            } else if (n > threes[mid]) {
                s = mid + 1;
            } else {
                e = mid - 1;
            }
            mid = (s + e) / 2;
        }
        return false;
    }

    private int[] initThreePower() {
        return new int[]{
                1,
                3,
                9,
                27,
                81,
                243,
                729,
                2187,
                6561,
                19683,
                59049,
                177147,
                531441,
                1594323,
                4782969,
                14348907,
                43046721,
                129140163,
                387420489,
                1162261467,
        };
    }
}
