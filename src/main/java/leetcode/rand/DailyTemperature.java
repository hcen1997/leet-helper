package leetcode.rand;

import java.util.Arrays;

public class DailyTemperature {
    public static void main(String[] args) {
        DailyTemperature dt = new DailyTemperature();
        int[] tt = {73, 74, 75, 71, 69, 72, 76, 73};
        int[] ints = dt.dailyTemperatures(tt);
        System.out.println("Arrays.toString(ints) = " + Arrays.toString(ints));
    }

    public int[] dailyTemperatures(int[] T) {
        int[] waitDays = new int[T.length];
        for (int i = 0; i < T.length; i++) {
            int biggerTempIndex = findBiggerTemp(T, i);
            if (biggerTempIndex == -1) {
                waitDays[i] = 0;
            } else {
                waitDays[i] = biggerTempIndex - i;
            }
        }
        return waitDays;
    }

    private int findBiggerTemp(int[] t, int i) {
        if (i == t.length - 1
                || t[i] == 100) {
            return -1;
        }
        for (int i1 = i + 1; i1 < t.length; i1++) {
            if (t[i1] > t[i]) {
                return i1;
            }
        }
        return -1;
    }
}
