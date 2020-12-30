package leetcode.level.easy.rand4;

public class DistributeCandies {
    public int distributeCandies(int[] candyType) {
        // 最大也就一半的种类
        int max = candyType.length / 2;
        int allType = getAllType(candyType);
        return Math.min(max, allType);
    }

    int getAllType(int[] candyType) {
        boolean[] typeSpace = new boolean[200_0010];
        int sum = 0;
        for (int candy : candyType) {
            var candyIndex = candy+100_000;
            if (!typeSpace[candyIndex]) {
                typeSpace[candyIndex]=true;
                sum++;
            }
        }
        return sum;
    }
}
