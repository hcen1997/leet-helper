package leetcode.level.easy.resume2021.rand1;

public class FindJudge {


    public int findJudge(int N, int[][] trust) {
        boolean[] relations = new boolean[N];
        int[] counts = new int[N];
        initRelation(relations, counts, trust);
//        小镇的法官不相信任何人。
        // 划掉标记  // 可以用高级数据结构
        int theOne;
        if ((theOne = onlyOneNoRelation(relations)) == -1) {
            return -1;
        }
//        每个人（除了小镇法官外）都信任小镇的法官。
        // 指向计数
        int theTwo;
        if ((theTwo = hasNMO(counts, N)) == -1) {
            return -1;
        }
        // 只有一个人
        if (theOne != theTwo) {
            return -1;
        }
        return theOne + 1;
    }

    private int hasNMO(int[] counts, int n) {
        int ans = -1;
        for (int i = 0; i < counts.length; i++) {
            int count = counts[i];
            if (count == n - 1) {
                ans = i;
            }
        }
        return ans;
    }

    private int onlyOneNoRelation(boolean[] relations) {
        int count = 0, index = -1;
        for (int i = 0; i < relations.length; i++) {
            boolean relation = relations[i];
            if (relation) {
                count++;
            } else {
                index = i;
            }
        }
        boolean onlyOneNoRelation = relations.length - count == 1;
        return onlyOneNoRelation ? index : -1;
    }

        private void initRelation(boolean[] relations, int[] counts, int[][] trust) {
            for (int i = 0; i < trust.length; i++) {
                int[] relation = trust[i];
                // 信任他人
                relations[relation[0]-1] = true;
                // 被信任计数
                counts[relation[1]-1] += 1;
            }
        }

}
