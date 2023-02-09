package leetcode.zozE;

import java.util.HashSet;
import java.util.Set;

/**
 * https://leetcode.cn/problems/valid-sudoku/
 */
public class CheckSodu {


    class Solution {
        public boolean isValidSudoku(char[][] board) {
            Set<Character> cnt = new HashSet<>();
            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    char c = board[i][j];
                    if (c != '.') {
                        if (!cnt.contains(c)) {
                            cnt.add(c);
                        } else {
                            return false;
                        }
                    }
                }
                cnt.clear();
            }
            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    char c = board[j][i];
                    if (c != '.') {
                        if (!cnt.contains(c)) {
                            cnt.add(c);
                        } else {
                            return false;
                        }
                    }
                }
                cnt.clear();
            }
            for (int s = 0; s < 9; s++) {
                for (int i = s / 3 * 3; i < (s / 3 + 1) * 3; i++) {
                    for (int j = s % 3 * 3; j < (s % 3 + 1) * 3; j++) {
                        //                        System.out.println(i + "" + j);
                        char c = board[i][j];
                        if (c != '.') {
                            if (!cnt.contains(c)) {
                                cnt.add(c);
                            } else {
                                return false;
                            }
                        }
                    }
                }
                //                System.out.println("out");
                cnt.clear();
            }


            return true;
        }
    }

}
