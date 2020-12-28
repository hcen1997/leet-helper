package leetcode.level.easy.rand2;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class RankSortedArray {
    public int[] arrayRankTransform(int[] arr) {
        int[] arrSorted = arr.clone();
        Arrays.sort(arrSorted);
        Map<Integer,Integer> varIndex = new HashMap<>(arr.length*8/10);
        int j=0;
        for (int i = 0; i < arrSorted.length; i++) {
            if(varIndex.containsKey(arrSorted[i])){
                continue;
            }
            varIndex.put(arrSorted[i],j);
            j++;
        }
        int[] ans = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            int index = varIndex.get(arr[i]);
            ans[i]= index+1;
        }
        return ans;
    }
}
