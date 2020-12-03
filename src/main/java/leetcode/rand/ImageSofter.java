package leetcode.rand;

public class ImageSofter {
    // 为什么不加一圈呢??
    public int[][] imageSmoother(int[][] M) {
        int h = M.length;
        int w = M[0].length;
        if (h == w && h == 1) {
            return M;
        }
        int[][] ans = new int[h][w];
        Mask mask = init();
        if (h == 1) {
//            mask.singleCol
            transMask(M, ans, mask.singleRow[0], 0, 0);
            transMask(M, ans, mask.singleRow[2], 0, w - 1);
            if (w > 2) {
                for (int i = 1; i < w - 1; i++) {
                    transMask(M, ans, mask.singleRow[1], 0, i);
                }
            }
            return ans;
        }
        if (w == 1) {
//            mask.singleRow
            transMask(M, ans, mask.singleCol[0], 0, 0);
            transMask(M, ans, mask.singleCol[2], h - 1, 0);
            if (h > 2) {
                for (int i = 1; i < h - 1; i++) {
                    transMask(M, ans, mask.singleCol[1], i, 0);
                }
            }
            return ans;
        }
        // 4 conner
        int[] conner = {
                0, 0,
                h - 1, 0,
                h - 1, w - 1,
                0, w - 1,
        };
        for (int i = 0; i < 4; i++) {
            transMask(M, ans, mask.conner[i],
                    conner[i * 2], conner[i * 2 + 1]);
        }
        if (h == 2 && w == 2) {
            return ans;
        }
        // only  side up down
        for (int i = 1; i < w - 1; i++) {
            transMask(M, ans, mask.side[3], 0, i);
            transMask(M, ans, mask.side[1], h - 1, i);
        }
        if (h == 2) {
            return ans;
        }
        // only  side left right
        for (int i = 1; i < h - 1; i++) {
            transMask(M, ans, mask.side[0], i, 0);
            transMask(M, ans, mask.side[2], i, w - 1);
        }
        if (w == 2) {
            return ans;
        }

        // has mid
        calMid(M, h, w, mask, ans);
        return ans;
    }

    private void calMid(int[][] M, int h, int w, Mask mask, int[][] ans) {
        for (int i = 1; i < h - 1; i++) {
            for (int j = 1; j < w - 1; j++) {
                transMask(M, ans, mask.mid, i, j);
            }
        }
    }

    private void transMask(int[][] m, int[][] t, int[] mask, int x, int y) {
        int sum = 0;
        for (int i = 0; i < mask.length; i += 2) {
            sum += m[x + mask[i]][y + mask[i + 1]];
        }
        t[x][y] = sum/(mask.length/2);
    }

    private Mask init() {
        int[] mid = {
                -1, -1, -1, 0, -1, 1,
                0, -1, 0, 0, 0, 1,
                1, -1, 1, 0, 1, 1,
        };
        int[][] side = {// 左下右上
                {
                        -1, 0, -1, 1,
                        0, 0, 0, 1,
                        1, 0, 1, 1,
                },
                {
                        -1, -1, -1, 0, -1, 1,
                        0, -1, 0, 0, 0, 1,
                },
                {
                        -1, -1, -1, 0,
                        0, -1, 0, 0,
                        1, -1, 1, 0,
                },
                {
                        0, -1, 0, 0, 0, 1,
                        1, -1, 1, 0, 1, 1,
                },
        };
        int[][] conner = { // 左上角先 逆时针
                {
                        0, 0, 0, 1,
                        1, 0, 1, 1,
                },
                {
                        -1, 0, -1, 1,
                        0, 0, 0, 1,
                },
                {
                        -1, -1, -1, 0,
                        0, -1, 0, 0,
                },
                {
                        0, -1, 0, 0,
                        1, -1, 1, 0,
                },
        };
        int[][] singleRow = {
                {0, 0, 0, 1},
                {0, -1, 0, 0, 0, 1},
                {0, -1, 0, 0},
        };
        int[][] singleCol = {
                {
                        0, 0,
                        1, 0,
                },
                {
                        -1, 0,
                        0, 0,
                        1, 0,
                },
                {
                        -1, 0,
                        0, 0,
                },
        };
        Mask mask = new Mask();
        mask.mid = mid;
        mask.conner = conner;
        mask.side = side;
        mask.singleRow = singleRow;
        mask.singleCol = singleCol;
        return mask;
    }

    class Mask {
        int[] mid;
        int[][] conner;
        int[][] side;
        int[][] singleRow;
        int[][] singleCol;
    }
}
