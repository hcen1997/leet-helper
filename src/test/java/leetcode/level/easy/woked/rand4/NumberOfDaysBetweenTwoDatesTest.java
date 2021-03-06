package leetcode.level.easy.woked.rand4;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class NumberOfDaysBetweenTwoDatesTest extends NumberOfDaysBetweenTwoDates {

    @Test
    public void testDaysBetweenDates() {
        String d1 = "5-1-1";
        String d2 = "1-1-1";
        int i = daysBetweenDates(d1, d2);
        assertEquals(1461, i);
    }
    @Test
    public void testDaysBetweenDates1() {
        String d1 = "4-1-1";
        String d2 = "1-1-1";
        int i = daysBetweenDates(d1, d2);
        assertEquals(1095, i);
    }
    @Test
    public void testDaysBetweenDates11() {
        String d1 = "100-1-1";
        String d2 = "1-1-1";
        int i = daysBetweenDates(d1, d2);
        assertEquals(36159, i);
    }
    @Test
    public void testDaysBetweenDates111() {
        String d1 = "101-1-1";
        String d2 = "1-1-1";
        int i = daysBetweenDates(d1, d2);
        assertEquals(36159+365, i);
    }
    @Test
    public void testDaysBetweenDates1111() {
        String d1 = "400-1-1";
        String d2 = "1-1-1";
        int i = daysBetweenDates(d1, d2);
        assertEquals(145731, i);
    }
    @Test
    public void testDaysBetweenDates1211() {
        String d1 = "401-1-1";
        String d2 = "1-1-1";
        int i = daysBetweenDates(d1, d2);
        assertEquals(145731+366, i);
    }
    @Test
    public void testDaysBetweenDates12111() {
        String d1 = "2020-01-15";
        String d2 = "2019-12-31";
        int i = daysBetweenDates(d1, d2);
        assertEquals(15, i);
    }
    @Test
    public void testDaysBetweenDates121111() {
        String d1 = "2009-08-18";
        String d2 = "2080-08-08";
        int i = daysBetweenDates(d1, d2);
        assertEquals(25923, i);
    }

}