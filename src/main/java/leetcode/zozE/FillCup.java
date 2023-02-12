package leetcode.zozE;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;

public class FillCup {
    class Solution {


        public int fillCups(int[] amount) {
            int cnt = 0;
            int sum = amount[0] + amount[1] + amount[2];
            while (sum > 0) {
                Arrays.sort(amount);
                if (amount[2] > 0 && amount[1] > 0) {
                    amount[2]--;
                    amount[1]--;
                    sum -= 2;
                } else {
                    amount[2]--;
                    sum--;
                }
                cnt++;
            }
            return cnt;
        }

        public int fillCups2(int[] amount) {
            Arrays.sort(amount);
            if (amount[2] > amount[0] + amount[1]) {
                return amount[2];
            }else {
                // 剩下一个偶数
//                return amount[2] + (amount[0]+amount[1]-amount[2])/2;
//                // 剩下一个奇数
//                return amount[2] + (amount[0] + amount[1] - amount[2])/2 + 1;
                // 如果是偶数, +1/2不影响结果
                // 如果是奇数. +1/2 == /2 +1
                return (amount[2]+amount[0]+amount[1] + 1)/2;
            }
        }
    }
}
