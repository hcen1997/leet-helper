package leetcode.zozE.compite;

public class MaxMinDiff {
    class Solution {
        public int minMaxDifference(int num) {
            // 第一感觉是 把前面的值变成0/9
            String n = Integer.toString(num);
            String c = n.substring(0,1);
            int min = Integer.parseInt(n.replaceAll(c,"0"));
            int i=0;
            while ((c = n.substring(i,i+1)).equals("9") && i<n.length()-1) i++;
            if(i>=n.length()){
                return num-min;
            }
            int max = Integer.parseInt(n.replaceAll(c,"9"));
            return max-min;
        }
    }
}
