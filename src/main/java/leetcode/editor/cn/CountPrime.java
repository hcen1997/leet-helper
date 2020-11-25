package leetcode.editor.cn;

import javax.sound.midi.Instrument;
import java.util.ArrayList;

import sun.instrument.InstrumentationImpl;

import java.util.LinkedHashMap;
import java.util.List;

public class CountPrime {
    boolean isPrimes(int n) {
        // n偶数
        if (n == 2) {
            return true;
        } else if ((n & 1) == 0) {
            return false;
        }
        // n 奇数
        boolean isP = true;

        for (int i = 3; i < n / 2; i += 2) {
            if (n % i == 0) {
                isP = false;
                break;
            }
        }
        return isP;

    }

    public static void main(String[] args) {

//        int pridmes = new CountPrime().countPrimes(499979);
//        System.out.print(" target = " + 499979);
//        System.out.println(" primes = " + pridmes);
        for (int i = 1; i < 12; i++) {
            long st = System.currentTimeMillis();
            int target = 1;
            for (int j = 0; j < i; j++) {
                target *= 10;
            }
            int primes = new CountPrime().countPrimes(target);
            System.out.print(" target = " + target);
            System.out.println(" primes = " + primes);
            long et = System.currentTimeMillis();
            System.out.println("et-st = " + (et - st));
        }
    }

    public int countPrimes(int n) {
        // 小数优化
        if (n <= 1) {
            return 0;
        }
        if (n == 2) {
            return 0;
        }
        if (n == 3) {
            return 1;
        }
        int mapSize = n % 2 == 0 ? n - 1 : n - 2;
        NumArr numArr = new NumArr(mapSize);
        // 不断筛选
        int next;
        while ((next = numArr.next()) != -1) {
            numArr.removePSon(next);
        }
        int count = numArr.count();
        // 因为2没有算
        return count + 1;
    }

    class NumArr {
        boolean[] pri;
        // 起始搜索节点
        int pp = 0;

        NumArr(int n) {
            pri = new boolean[n / 2];
        }

        public int next() {
            int target = -1;
            for (int i = pp; i < pri.length; i++) {
                if (pri[i] == false) {
                    // 排除已经搜索到的节点
                    pp = i + 1;
                    int num = (i + 1) * 2 + 1;
                    return num;
                }
            }
            return -1;
        }

        // 在pri中删除所有pr的孩子
        public void removePSon(int pr) {
            for (int i = 3; ; i += 2) {
                int in = pr * i;
                int pp = (in - 1) / 2 - 1;
                if (pp >= pri.length) {
                    break;
                } else {
                    pri[pp] = true;
                }
            }
        }

        public int count() {
            int sum = 0;
            for (int i = 0; i < pri.length; i++) {
                if (!pri[i]) {
                    sum++;
                }
            }
            return sum;
        }

    }
}
