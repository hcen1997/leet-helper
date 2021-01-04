package leetcode.level.easy.rand4;

import java.util.ArrayList;
import java.util.List;

/**
 * 给出一个整数数组 A 和一个查询数组 queries。
 * <p>
 * 对于第 i 次查询，有 val = queries[i][0], index = queries[i][1]，
 * 我们会把 val 加到 A[index] 上。然后，第 i 次查询的答案是 A 中偶数值的和。
 * <p>
 * （此处给定的 index = queries[i][1] 是从 0 开始的索引，每次查询都会永久修改数组 A。）
 * <p>
 * 返回所有查询的答案。你的答案应当以数组 answer 给出，answer[i] 为第 i 次查询的答案。
 * <p>
 * // A 大小1w
 */
public class SumAfterQuery {
    // 偶数加偶数是偶数
    // 偶数加奇数是奇数
    // 奇数加奇数是偶数

    public int[] sumEvenAfterQueries(int[] A, int[][] queries) {
        List<Boolean> isEvenArr = new ArrayList<>();
        int[] ans = new int[queries.length];
        int allEvenSum = 0;
        for (int value : A) {
            boolean e = isEven(value);
            if (e) {
                isEvenArr.add(true);
                allEvenSum += value;
            }
        }
        int val, index;
        for (int[] query : queries) {
            val = query[0];
            index = query[1];
            boolean isValEven = isEven(val);
            boolean isArrItemEven = isEvenArr.get(index);
            // 偶数加偶数是偶数
            if (isValEven) {
                if (isArrItemEven) {

                }
            }
            // 偶数加奇数是奇数
            // 奇数加奇数是偶数

        }
    }

    // 模拟法太慢了, 需要使用分析来优化运行时间
    int[] 模拟法(int[] A, int[][] queries) {
        int[] ans = new int[queries.length];
        int val, index;
        for (int i = 0; i < queries.length; i++) {
            val = queries[i][0];
            index = queries[i][1];
            A[index] += val;
            int sum = sumEven(A);
            ans[i] = sum;
        }
        return ans;
    }

    private int sumEven(int[] a) {
        int sum = 0;
        for (int i : a) {
            if (i % 2 == 0) {
                sum += i;
            }
        }
        return sum;
    }

    boolean isEven(int i) {
        return i / 2 == 0;
    }
}
