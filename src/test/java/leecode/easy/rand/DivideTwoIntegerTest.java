package leecode.easy.rand;

import org.junit.Test;

import static org.junit.Assert.*;

public class DivideTwoIntegerTest {

    DivideTwoInteger d2 = new DivideTwoInteger();

    @Test
    public void divide() {
        int[][] ii = {
                {1, 1},
                {11, 1},
                {115, 1},
                {-2, 2},
                {0x7fffffff, 1},
                {0x7fffffff, 2},
                {0x80000000, 2},
                {0x80000000, -2},
                {0, -2},
                {-2, -2},
                {-3, -2},
                {-1, -2},
                {-1, 2},
        };
        for (int[] i : ii) {
            assertEquals(d2.divide(i[0], i[1]), i[0] / i[1]);
        }
        assertEquals(d2.divide(0x80000000, -1), 0x7fffffff);
        assertEquals(d2.divide(0x80000000, 1), 0x80000000);
        assertEquals(d2.divide(0x80000000, 0x80000000), 1);
        assertEquals(d2.divide(0x7fffffff, 0x80000000), 0);
    }

    @Test
    public void plantDiv() {
        assertEquals(d2.plantDiv(0, 1), 0);
        assertEquals(d2.plantDiv(1, 1), 1);
        assertEquals(d2.plantDiv(999, 1), 999);
        assertEquals(d2.plantDiv(45, 5), 9);
        assertEquals(d2.plantDiv(3, 5), 0);
        assertEquals(d2.plantDiv(0x7fffffff, 2), 0x7fffffff / 2);
    }
}