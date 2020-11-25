package leetcode.editor.cn;

public class BestTimeBuySellStockII {
    public int maxProfit(int[] prices) {
        if (prices.length == 1) {
            return 0;
        }
        // 看下一个有没有利益 有就买 明天买
        int sum = 0;
        for (int i = 0; i + 1 < prices.length; i++) {
            int toDay = prices[i];
            int nextDay = prices[i + 1];
            if (nextDay > toDay) {
                sum += nextDay - toDay;
            }
        }
        return sum;
    }
}
