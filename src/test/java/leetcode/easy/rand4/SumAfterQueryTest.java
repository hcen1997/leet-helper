package leetcode.easy.rand4;

import leetcode.Utils;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class SumAfterQueryTest extends SumAfterQuery {

    @Test
    public void testSumEvenAfterQueries() {
        int[] ints = Utils.stringToIntegerArray("[1,2,3,4]");
        int[][] ints1 = Utils.stringToInt2dArray("[[1,0],[-3,1],[-4,0],[2,3]]");
        int[] ints2 = sumEvenAfterQueries(ints, ints1);
        System.out.println("Arrays.toString(ints); = " + Arrays.toString(ints2));
    }
}