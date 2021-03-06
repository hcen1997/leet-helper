package leetcode.level.easy.resume2021.rand1;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class AddDigits {
    public int addDigits(int num) {
        if (num < 0) {
            return num;
        }
        if (num < 10) {
            return num;
        }
        int sum = 0;
        List<Integer> digs = getDigs(num);
        sum = sumL(digs);
//        sum = digs.stream().flatMapToInt(IntStream::of).sum();
        return getAnsIn100(sum);
    }

    private int sumL(List<Integer> digs) {
        int sum = 0;
        int size = digs.size();
        for (int i = 0; i < size; i++) {
            sum = sum+digs.get(i);
        }
        return sum;
    }

    private List<Integer> getDigs(int num) {
        List<Integer> digs = new ArrayList<>();
        String n = num + "";
        for (int i = 0; i < n.length(); i++) {
            char c = n.charAt(i);
            digs.add(c - '0');
        }
        return digs;
    }

    private int getAnsIn100(int num) {
        int[] ansSet = {0,
                1, 2, 3, 4, 5, 6, 7, 8, 9, 1, 2, 3, 4, 5, 6, 7, 8, 9, 1, 2,
                3, 4, 5, 6, 7, 8, 9, 1, 2, 3, 4, 5, 6, 7, 8, 9, 1, 2, 3, 4,
                5, 6, 7, 8, 9, 1,
                2, 3, 4, 5, 6, 7, 8, 9, 1, 2, 3, 4, 5, 6, 7, 8, 9, 1, 2, 3,
                4, 5, 6, 7, 8, 9, 1, 2, 3, 4, 5, 6, 7, 8, 9, 1, 2, 3, 4, 5, 6, 7, 8,
                9, 1, 2, 3, 4, 5, 6, 7, 8, 9, 1,};
        return ansSet[num];
    }
}
