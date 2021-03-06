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
                && inRange(rec2[2], rec1[2], rec1[4]);
        return first || second;
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
