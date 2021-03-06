package leetcode.level.easy.woked.rand4;

import java.util.Arrays;

public class CountLargestGroup {
    public int countLargestGroup(int n) {
        final int maxInput = 10_000;
        // 经测试 最大40组
        int[] group = new int[40];
        for (int i = 1; i <= n; i++) {
            int gr = sumIntByDecimal(i);
            group[gr]++;
        }
        // 统计最大
        int asInt = Arrays.stream(group).max().getAsInt();
//        int hasVal = Arrays.stream(group).map(value -> value > 0 ? 1 : 0).sum();
//        System.out.println("hasVal = " + hasVal);
        int ans =0;
        for (int gr : group) {
            if(gr==asInt){
                ans++;
            }
        }
        return ans;
    }
    int sumIntByDecimal(int n){
        String s = n + "";
        char[] chars = s.toCharArray();
        int sum = 0;
        for (char aChar : chars) {
            sum+=aChar-'0';
        }
        return sum;
    }
}
