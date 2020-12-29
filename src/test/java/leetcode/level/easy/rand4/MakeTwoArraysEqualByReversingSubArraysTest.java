package leetcode.level.easy.rand4;

import leetcode.Utils;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class MakeTwoArraysEqualByReversingSubArraysTest extends MakeTwoArraysEqualByReversingSubArrays {

    @Test
    public void testRev() {
        int[] ints = Utils.stringToIntegerArray("[1,2,3,4,5]");
        rev(ints,0,3);
        assertEquals("[4, 3, 2, 1, 5]",Arrays.toString(ints));
    }
    @Test
    public void testCanBeEqual() {
        int[] target = Utils.stringToIntegerArray("[1,2,3,4]");
        int[] arr = Utils.stringToIntegerArray("[2,4,1,3]");
        boolean b = canBeEqual(target, arr);
        assertEquals(b,true);
    }
    @Test
    public void testCanBeEqual1() {
        int[] target = Utils.stringToIntegerArray("[7]");
        int[] arr = Utils.stringToIntegerArray("[7]");
        boolean b = canBeEqual(target, arr);
        assertEquals(b,true);
    }
    @Test
    public void testCanBeEqual11() {
        int[] target = Utils.stringToIntegerArray("[1,12]");
        int[] arr = Utils.stringToIntegerArray("[12,1]");
        boolean b = canBeEqual(target, arr);
        assertEquals(b,true);
    }
    @Test
    public void testCanBeEqual111() {
        int[] target = Utils.stringToIntegerArray("[3,7,9]");
        int[] arr = Utils.stringToIntegerArray("[3,7,11]");
        boolean b = canBeEqual(target, arr);
        assertEquals(b,false);
    }
    @Test
    public void testCanBeEqual1111() {
        int[] target = Utils.stringToIntegerArray("[1,1,1,1,1]");
        int[] arr = Utils.stringToIntegerArray("[1,1,1,1,1]");
        boolean b = canBeEqual(target, arr);
        assertEquals(b,true);
    }
}