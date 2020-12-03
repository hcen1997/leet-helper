package leetcode.rand;

import java.util.Arrays;

public class Search2dMatrixII {
    public boolean searchMatrix(int[][] matrix, int target) {
        for (int i = 0; i < matrix.length; i++) {
            if (matrix[i][0] <= target
                    && matrix[i][matrix[i].length - 1] >= target) {
                if (Arrays.binarySearch(matrix[i], target)>=0) {
                    return true;
                }
            }
        }
        return false;
    }
}
