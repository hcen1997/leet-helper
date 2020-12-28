package leetcode.level.easy.rand;

import java.util.Arrays;

public class HeightChecker {
    public int heightChecker(int[] heights) {
        int[] h = Arrays.copyOf(heights, heights.length);
        Arrays.sort(h);
        int sum = 0;
        for (int i = 0; i < h.length; i++) {
            if(h[i]!=heights[i]){
                sum++;
            }
        }
        return sum;
    }
}
