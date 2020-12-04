package leetcode.easy.rand;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SelfDivNumber {
    public List<Integer> selfDividingNumbers(int left, int right) {
        ArrayList<Integer> integers = new ArrayList<>();
        for (int i = left; i <= right; i++) {
            if (isSDN(i)) {
                integers.add(i);
            }
        }
        return integers;
    }

    boolean isSDN(int n) {
        String s = Integer.toString(n);
        if (s.contains("0")) {
            return false;
        }
        char[] chars = s.toCharArray();
        int[] ints = new int[chars.length];
        for (int i = 0; i < ints.length; i++) {
            ints[i] = chars[i] - '0';
        }
        for (int anInt : ints) {
            if (n % anInt != 0) {
                return false;
            }
        }
        return true;
    }
}
