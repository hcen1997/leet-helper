package leetcode.level.easy.rand3;

import java.util.Arrays;

public class MaxSumKNeg {
    public int largestSumAfterKNegations(int[] A, int K) {
        int sum = 0;
        int[] a = A.clone();
        Arrays.sort(a);
        int negCount = -1;
        for (int i = 0; i < a.length; i++) {
            if (a[i] >= 0) {
                negCount = i;
                break;
            }
        }

        //  取到k个负数
        //     n个负数  k>n
        // k-n = 1 + 2i  取一个最小的正数 取反 然后其他都是2次
        // k-n = 2i // 无影响

        //     n个负数  k < n
        // 取最小的k个负数
        if (K == negCount) {
            neg(a, 0, K);
        } else if (K > negCount) {
            if((K-negCount)%2==1){
                neg(a,0,negCount+1);
            }else {
                neg(a, 0, negCount);
            }
        } else {
            neg(a, 0, K);
        }

        sum = Arrays.stream(a).sum();
        return sum;
    }

    private void neg(int[] a, int i, int k) {
        for (int j = 0; j < k; j++) {
            a[j + i] = -a[j + i];
        }
    }
}
