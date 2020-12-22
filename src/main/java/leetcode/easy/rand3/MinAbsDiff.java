package leetcode.easy.rand3;

import java.util.Arrays;
import java.util.List;

public class MinAbsDiff {
    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        Arrays.sort(arr);
        for (int i = 0; i < arr.length-1; i++) {
            int dif = arr[i]-arr[i];

        }
    }
}
