package leetcode.easy.rand;

/**
 *
 */
public class Reshape {
    public int[][] matrixReshape(int[][] nums, int r, int c) {
        // cal possible
        int size = nums.length * nums[0].length;
        if (r * c != size) {
            return nums;
        }
        int[][] ans = new int[r][c];
        for (int i = 0; i < nums.length; i++) {
            int[] num = nums[i];
            for (int j = 0; j < num.length; j++) {
                int index = i * nums[0].length + j;
                int x = (index) / c;
                int y = index - x * c;
                ans[x][y] = nums[i][j];
            }
        }
        return ans;
    }
}
