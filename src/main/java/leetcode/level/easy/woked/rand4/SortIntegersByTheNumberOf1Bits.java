package leetcode.level.easy.woked.rand4;

import java.util.ArrayList;

public class SortIntegersByTheNumberOf1Bits {
    public int[] sortByBits(int[] arr) {
        ArrayList<Integer> integers = new ArrayList<>();
        for (int i : arr) {
            integers.add(i);
        }
        integers.sort(this::compare);
        for (int i = 0; i < integers.size(); i++) {
            arr[i] = integers.get(i);
        }
        return arr;
    }

    int compare(int o1, int o2) {
        int count = count(o1);
        int count1 = count(o2);
        if(count!=count1){
            return count - count1;
        }
        return o1 - o2;
    }

    int count(int i) {
        String s = Integer.toBinaryString(i);
        int count = 0;
        char[] chars = s.toCharArray();
        for (char aChar : chars) {
            if (aChar == '1') {
                count++;
            }
        }
        return count;
    }
}
