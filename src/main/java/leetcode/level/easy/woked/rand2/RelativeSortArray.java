package leetcode.level.easy.woked.rand2;

import java.util.Arrays;

public class RelativeSortArray {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        if (arr1.length == 0) {
            return arr1;
        }
        if (arr2.length == 0) {
            int[] clone = arr1.clone();
            Arrays.sort(clone);
            return clone;
        }
        int validA1 = 0;
        int[] a1c = arr1.clone();
        for (int i = 0; i < arr2.length; i++) {
            int target = arr2[i];
            // find has
            for (int j = validA1; j < a1c.length; j++) {
                if (a1c[j] == target) {
                    swap(a1c, validA1, j);
                    if (i != arr2.length - 1) {
                    }
                        validA1++;
                }
            }
        }
        if (validA1 < a1c.length - 1) {
            Arrays.sort(a1c, validA1, a1c.length );
        }
        return a1c;
    }

    void swap(int[] a, int x, int y) {
        int tmp = a[x];
        a[x] = a[y];
        a[y] = tmp;
    }
}
