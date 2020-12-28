package leetcode.level.mid.rand;

import java.util.ArrayList;
import java.util.List;

public class Permutations {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {

        }
        return ans;
    }

    List<Integer> doPermute(int[] sub, int head){
return null;
    }

    int[] getExclude(int[] n, int i) {
        int[] clone = new int[n.length - 1];
        int ii = 0;
        for (int j = 0; j < n.length; j++) {
            if (i != n[j]) {
                clone[ii] = n[j];
                ii++;
            }
        }
        return clone;
    }
}
