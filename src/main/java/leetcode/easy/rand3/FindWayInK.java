package leetcode.easy.rand3;

public class FindWayInK {
    public int numWays(int n, int[][] relation, int k) {
        int ans = 0;
        for (int i = 0; i < relation.length; i++) {
            int[] rel = relation[i];
            if (rel[0] == 0) {
                ans += hasWayInK(rel[1], n - 1, relation, k - 1);
            }
        }
        return ans;
    }

    int hasWayInK(int s, int e, int[][] re, int k) {
        // 找到起点
        // 对于所有起点的终点执行hasWIK
        // 处理边界

        // 处理 环 /// 不用处理 因为k-1控制了最大循环次数
        if (k == 0 && s == e) {
            return 1;
        } else if (k == 0 && s != e) {
            return 0;
        } else {
            int sum = 0;
            for (int i = 0; i < re.length; i++) {
                int[] rel = re[i];
                if (rel[0] == s) {
                    sum += hasWayInK(rel[1], e, re, k - 1);
                }
            }
            return sum;
        }
    }
}
