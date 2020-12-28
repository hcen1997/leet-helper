package leetcode.level.easy.rand4;

// fixme: 超时
public class SumAfterQuery {
    public int[] sumEvenAfterQueries(int[] A, int[][] queries) {
        int[] ans = new int[queries.length];
        int val, index;
        for (int i = 0; i < queries.length; i++) {
            val = queries[i][0];
            index = queries[i][1];
            A[index] += val;
            int sum = sumEven(A);
            ans[i]=sum;
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
}
