package leetcode.level.easy.resume2021.rand1;

import leetcode.Utils;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class IsRectangleOverlapTest extends IsRectangleOverlap {
    @Test
    public void test1() {
        int[] rec1 = Utils.stringToIntegerArray("[2,17,6,20]");
        int[] rec2 = Utils.stringToIntegerArray("[3,8,6,20]");
        boolean rectangleOverlap = isRectangleOverlap(rec1, rec2);
        assertEquals(true,rectangleOverlap);
    }

}