package leetcode.level.easy.woked.rand2;

import leetcode.Utils;
import org.junit.Test;

import java.util.Arrays;

public class RelativeSortArrayTest extends RelativeSortArray {

    @Test
    public void relativeSortArray() {
        int[] ints = relativeSortArray(
                Utils.stringToIntegerArray(
                        "[2,3,1,3,2,4,123,1234,12345,6,7,9,2,19]"),
                Utils.stringToIntegerArray(
                        "[2,1,4,3,9,6]")
        );
        System.out.println("Arrays.toString(ints) = " + Arrays.toString(ints));
    }
    @Test
    public void relativeSortArray1() {
        int[] ints = relativeSortArray(
                Utils.stringToIntegerArray(
                        "[26,21,11,20,50,34,1,18]"),
                Utils.stringToIntegerArray(
                        "[21,11,26,20]")
        );
        System.out.println("Arrays.toString(ints) = " + Arrays.toString(ints));
    }
}