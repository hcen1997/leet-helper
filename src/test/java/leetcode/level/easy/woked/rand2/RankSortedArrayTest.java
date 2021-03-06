package leetcode.level.easy.woked.rand2;

import leetcode.Utils;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class RankSortedArrayTest extends RankSortedArray {

    @Test
    public void testArrayRankTransform() {
        int[] ints = arrayRankTransform(Utils.stringToIntegerArray("[40,10,20,30]"));
        String ans = Arrays.toString(ints);
        assertEquals(ans, "[4,1,2,3]");
    }

    @Test
    public void testArrayRankTransform1() {
        String input = "[37,12,28,9,100,56,80,5,12]";
        int[] ints = arrayRankTransform(Utils.stringToIntegerArray(input));
        System.out.println("Arrays.toString(ints) = " + Arrays.toString(ints));
    }
}