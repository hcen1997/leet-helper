package leetcode.level.easy.woked.rand2;

import leetcode.Utils;
import org.junit.Test;

import static org.junit.Assert.*;

public class ValidMountainArrayTest extends ValidMountainArray {

    @Test
    public void testValidMountainArray() {
        assertEquals(validMountainArray(Utils.stringToIntegerArray(
                "[9,8,7,6,5,4,3,2,1,0]"
        )), false);
    }
}