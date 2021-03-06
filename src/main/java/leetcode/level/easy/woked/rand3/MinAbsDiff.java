package leetcode.level.easy.woked.rand3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MinAbsDiff {
    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        Arrays.sort(arr);
        int min = Integer.MAX_VALUE;
        List<List<Integer>> ans = new ArrayList<>();
        int dif, tmp=min;
        for (int i = 0; i < arr.length - 1; i++) {
            dif = arr[i + 1] - arr[i];
            min = Math.min(dif, min);
            if(min!=tmp){
                ans.clear();
            }
            if(min==dif){
                ans.add(List.of(arr[i],arr[i+1]));
            }
            // if min change
            tmp = min;
        }
        return ans;
    }
}
