package leetcode.level.easy.woked.rand4;

import org.junit.Test;

import java.util.Arrays;

public class RunningSumOf1DArrayTest extends RunningSumOf1DArray {

    @Test
    public void testRunningSum() {
        int[] mMap = {31, 28, 31,
                30, 31, 30,
                31, 31, 30,
                31, 30, 31};
        int[] ints = runningSum(mMap);
        System.out.println("Arrays.toString(ints) = " + Arrays.toString(ints));
    }
}