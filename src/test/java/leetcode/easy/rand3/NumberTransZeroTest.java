package leetcode.easy.rand3;

import org.junit.Test;

import static org.junit.Assert.*;

public class NumberTransZeroTest extends NumberTransZero {

    @Test
    public void testNumberOfSteps() {
        String s = Integer.toBinaryString(14);
        System.out.println("s = " + s);

        numberOfSteps(0);
    }
}