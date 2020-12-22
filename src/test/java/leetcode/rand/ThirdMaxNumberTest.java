package leetcode.rand;

import leetcode.Utils;
import org.junit.Test;

public class ThirdMaxNumberTest  extends ThirdMaxNumber{

    @Test
    public void thirdMax() {
        String s = "[3,2,1]";
        int[] ints = Utils.stringToIntegerArray(s);
        int i = thirdMax(ints);
        System.out.println("i = " + i);
    }
    @Test
    public void thirdMax1() {
        String s = "[2,2,3,1]";
        int[] ints = Utils.stringToIntegerArray(s);
        int i = thirdMax(ints);
        System.out.println("i = " + i);
    }
}