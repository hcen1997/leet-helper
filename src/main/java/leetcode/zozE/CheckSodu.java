package leetcode.zozE;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * https://leetcode.cn/problems/valid-sudoku/
 */
public class CheckSodu {


    class Solution {
        public boolean isValidSudoku(char[][] board) {
            int[] cnt = new int[10];
//            Set<Character> cnt = new HashSet<>();
            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    char c = board[i][j];
                    if (c != '.') {
                        if (cnt[c - '0'] == 0) {
                            cnt[c - '0'] = 1;
                        } else {
                            return false;
                        }
                    }
                }
                Arrays.fill(cnt, 0);
            }
            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    char c = board[j][i];
                    if (c != '.') {
                        if (cnt[c - '0'] == 0) {
                            cnt[c - '0'] = 1;
                        } else {
                            return false;
                        }
                    }
                }
                Arrays.fill(cnt, 0);
            }
            for (int s = 0; s < 9; s++) {
                for (int i = s / 3 * 3; i < (s / 3 + 1) * 3; i++) {
                    for (int j = s % 3 * 3; j < (s % 3 + 1) * 3; j++) {
                        //                        System.out.println(i + "" + j);
                        char c = board[i][j];
                        if (c != '.') {
                            if (cnt[c - '0'] == 0) {
                                cnt[c - '0'] = 1;
                            } else {
                                return false;
                            }
                        }
                    }
                }
                //                System.out.println("out");
                Arrays.fill(cnt, 0);
            }
            return true;
        }
    }

}
