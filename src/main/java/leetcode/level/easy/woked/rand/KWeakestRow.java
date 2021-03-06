package leetcode.level.easy.woked.rand;

import java.util.*;

public class KWeakestRow {
    public int[] kWeakestRows(int[][] mat, int k) {
        List<RowK> rowKs = new ArrayList<>();
        for (int i = 0; i < mat.length; i++) {
            int sum = Arrays.stream(mat[i]).sum();
            rowKs.add(new RowK(i,sum));
        }
        rowKs.sort(Comparator.comparingInt(o -> o.sum));
        int[] ans = new int[k];
        for (int i = 0; i < ans.length; i++) {
            ans[i] = rowKs.get(i).row;
        }
        return  ans;
    }

    int sum(int[] a) {
        return Arrays.stream(a).sum();
    }

    class RowK {
        public int row;
        public int sum;

        public RowK(int i, int s) {
            row= i;
            sum =s;
        }
    }

}
