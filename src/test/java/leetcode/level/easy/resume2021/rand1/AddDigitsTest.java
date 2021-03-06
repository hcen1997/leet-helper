package leetcode.level.easy.resume2021.rand1;

import org.junit.Test;

public class AddDigitsTest extends AddDigits {
    // 一次增加后, 最大不会超过100
    // 缓存100以内的所有值的答案就可以了
    @Test
    public void addDTest100() {
//        int n = Integer.MAX_VALUE;
        int n = 101;
        for (int i = 0; i < n; i++) {
            int i1 = addDigits(i);
//            System.out.print("i = " + i);
            System.out.println(" " + i1 + ",");
        }
    }



    @Test
    public void addDTest() {
//        int n = Integer.MAX_VALUE;
        int n = 999999999;
        for (int i = n - 100; i < n; i++) {
            int i1 = addDigits(i);
            System.out.print("i = " + i);
            System.out.println(" i1 = " + i1);
        }
    }

    @Test
    public void addDTestMax() {
        int n = Integer.MAX_VALUE;
        int max = 0;
        for (int i = 0; i < n; i++) {
            int i1 = addDigits(i);
            max = Math.max(i1, max);
        }
        System.out.println("max = " + max);
    }
}