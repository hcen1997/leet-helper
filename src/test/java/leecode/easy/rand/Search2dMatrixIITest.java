package leecode.easy.rand;

import leetcode.Utils;
import org.junit.Test;

import static org.junit.Assert.*;

public class Search2dMatrixIITest extends Search2dMatrixII {

    @Test
    public void searchMatrix() {
        int[][] ints = Utils.stringToInt2dArray("[[1,4,7,11,15],[2,5,8,12,19],[3,6,9,16,22],[10,13,14,17,24],[18,21,23,26,30]]");
        boolean b = searchMatrix(ints, 20);
    }
}