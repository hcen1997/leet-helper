package leetcode.level.easy.resume2021.rand1;

public class IsRectangleOverlap {
    public boolean isRectangleOverlap(int[] rec1, int[] rec2) {
        // 重合的情况
        if (same(rec1, rec2)) {
            return true;
        }
        // 判断两点的范围
        boolean first = inRange(rec2[0], rec1[0], rec1[2])
                && inRange(rec2[1], rec1[1], rec1[3]);
        boolean second = inRange(rec2[1], rec1[1], rec1[3])
                && inRange(rec2[2], rec1[1], rec1[2]);
        boolean rec2InRec1 =  first || second;

        boolean revFirst = inRange(rec1[0], rec2[0], rec2[2])
                && inRange(rec1[1], rec2[1], rec2[3]);
        boolean revSecond = inRange(rec1[1], rec2[1], rec2[3])
                && inRange(rec1[2], rec2[1], rec2[2]);
        boolean rec1InRec2 =  revFirst || revSecond;

        return rec1InRec2 || rec2InRec1;

        // 此时还有一种可能, 角点不在内部, 但是由交点形成了正方形

//        好麻烦, 算了
    }

    private boolean same(int[] rec1, int[] rec2) {
        return rec1[0] == rec2[0]
                && rec1[1] == rec2[1]
                && rec1[2] == rec2[2]
                && rec1[3] == rec2[3];
    }

    boolean inRange(int target, int lower, int upper) {
        return target > lower && target < upper;
    }
}
