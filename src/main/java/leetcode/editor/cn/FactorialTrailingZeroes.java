package leetcode.editor.cn;


import java.util.*;

/**
 * 计算n!有多少个尾0
 */
public class FactorialTrailingZeroes {
    // 1*10 2*5 4*5 6*5 8*5
    // 从小往大数

    public int trailingZeroes(int n) {
        int sum = 0;

        int mapIndex = 1;
        Map<Integer, Integer> p5 = get5p();
        for (int i = 1; i <= n; i++) {
            if (i >= p5.get(mapIndex)) {
                mapIndex++;
            }
            for (int j = mapIndex; j >= 1; j--) {
                if (i % p5.get(j) == 0) {
                    sum += j;
                    break;
                }
            }
        }
        return sum;
    }

    Map<Integer, Integer> get5p() {
        HashMap<Integer, Integer> _5p = new HashMap<>();
        int tmp = 1;
        for (int i = 1; i <= 13; i++) {
            tmp *= 5;
            _5p.put(i, tmp);
        }
        _5p.put(0, 1);
        return _5p;
    }

// 这里注意 小区间是4个
//   1     5              = M5
    // 这之间有3个位置是+1 其他的是 没有
//   2     25     = M25 + 3*P5
    // 这之间有3个位置是+2 其他的是
    // 在每一个小区间中 4个位置是 +1  // 一共有4个小区间
//   3     125    = M(125) + 3*M25 + 4*4*M5 + P25 = 31
    // 这之间3个位置是+3 其他是
    //  每一个小区间中 3个位置是+2
    // 每一个小区间中 3个位置是+1
//   4     625    = M625 + 3*M125 + 4*4*M25 + 4*5*4 + P25
//   5     3125
//   6     15625
//   7     78125
//   8     390625
//   9     1953125
//   10    9765625
//   11    48828125
//   12    244140625
    // 这之间有3个位置是+12 其他的是
//   13    1220703125

    public static void main(String[] args) {
        for (int i = 1; i < 13; i++) {
            FactorialTrailingZeroes factorialTrailingZeroes = new FactorialTrailingZeroes();
            int ii = factorialTrailingZeroes.trailingZeroes(factorialTrailingZeroes.get5p().get(i));
            System.out.print("i = " + i);
            System.out.print(" ii = " + ii + "\n");
        }

    }
}
