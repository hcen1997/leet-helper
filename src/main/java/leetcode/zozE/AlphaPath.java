package leetcode.zozE;

import java.util.HashMap;
import java.util.Map;

public class AlphaPath {
    class Solution {
        class XY {
            XY(int x, int y) {
                this.x = x;
                this.y = y;
            }

            public int x;
            public int y;

            public String toXy(XY t) {
                StringBuilder s = new StringBuilder();
                // 优先左下和上右
                int dx = t.x - this.x;
                int dy = t.y - this.y;
                while (dx != 0 || dy != 0) {
                    if (dx < 0) {
                        s.append('U');
                        dx++;
                        continue;
                    }
                    if (dy < 0) {
                        s.append('L');
                        dy++;
                        continue;
                    }
                    if (dx > 0) {
                        s.append('D');
                        dx--;
                        continue;
                    }
                    if (dy > 0) {
                        s.append('R');
                        dy--;
                        continue;
                    }
                }
                s.append('!');
                return s.toString();
            }
        }

        public String alphabetBoardPath(String target) {
            String[] board = {"abcde", "fghij", "klmno", "pqrst", "uvwxy", "z"};
            Map<Character, XY> boardMap = genMap(board);
            XY current = new XY(0, 0);

            StringBuilder ans = new StringBuilder();
            for (char c : target.toCharArray()) {
                XY t = boardMap.get(c);
                String subPath = current.toXy(t);
                ans.append(subPath);
                current = t;
            }
            return ans.toString();
        }

        private Map<Character, XY> genMap(String[] board) {
            Map<Character, XY> ans = new HashMap<>();
            for (int i = 0; i < board.length; i++) {
                for (int i1 = 0; i1 < board[i].length(); i1++) {
                    ans.put(board[i].charAt(i1), new XY(i, i1));
                }
            }
            return ans;
        }
    }
}
