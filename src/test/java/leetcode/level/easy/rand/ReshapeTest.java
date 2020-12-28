package leetcode.level.easy.rand;

import leetcode.Utils;
import org.junit.Test;

public class ReshapeTest extends Reshape {

    @Test
    public void testMatrixReshape() {
        int[][] ints = Utils.stringToInt2dArray("[[1],[2],[3],[4]]");
        int[][] ints1 = matrixReshape(ints, 2, 2);
    }
}