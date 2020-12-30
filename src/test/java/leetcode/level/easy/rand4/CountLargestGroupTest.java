package leetcode.level.easy.rand4;

import org.junit.Test;

import static org.junit.Assert.*;

public class CountLargestGroupTest extends CountLargestGroup {

    @Test
    public void testCountLargestGroup() {
        int i = countLargestGroup(13);
        assertEquals(4,i);
    }

    @Test
    public void testSumIntByDecimal() {
        int i = sumIntByDecimal(12);
        assertEquals(3,i);
    }
}