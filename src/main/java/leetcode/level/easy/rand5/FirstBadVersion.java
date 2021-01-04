package leetcode.level.easy.rand5;

public class FirstBadVersion extends VersionControl {
    public FirstBadVersion(VersionControl versionControl) {
        super(versionControl);
    }

    public int firstBadVersion(int n) {
        if (!isBadVersion(n)) {
            return -1;
        }
        if (isBadVersion(1)) {
            return 1;
        }
        if (n < 256) {
            return findNormal(n);
        } else {
            //         2分查找法
            return findBinary(n);
        }
    }

    private int findNormal(int n) {
        return findInRange(1, n);
    }

    private int findInRange(int start, int end) {
//        if(start+1>end){ // 符合语法, 但是应该从来不会被运行到
//            return start;
//        }
        for (int i = end; i >= start + 1; i--) {
            boolean isLastBad = isBadVersion(i);
            boolean isNowBad = isBadVersion(i - 1);
            if (isLastBad && !isNowBad) {
                return i;
            }
        }
        return start;
    }

    private int findBinary(int n) {
        // 二分查找
        return findBinary(1, n);
    }

    /**
     * 假设第一次二分时, end必然为坏版本, start必然为好版本
     */
    private int findBinary(int start, int end) {
//        当范围缩小到32时使用线性查找
        if (end - start < 32) {
            return findInRange(start, end);
        }
        int mid = (int)(((long) start + (long)end) / 2);
        boolean isMidBad = isBadVersion(mid);
        if (isMidBad) {
            return findBinary(start, mid);
        } else {
            // mid ok
            return findBinary(mid, end);
        }
    }

}
