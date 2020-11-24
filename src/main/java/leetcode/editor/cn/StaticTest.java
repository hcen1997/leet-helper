package leetcode.editor.cn;

import org.junit.Test;

public class StaticTest {
    static {
        System.out.println("in static");
    }

    public static void main(String[] args) {
        System.out.println("in main ");

    }

    @Test
   public void testThreeSum(){
        int[] ints = {-1, 0, 1, 2, -1, -4, 12, 2, -2, 4, 5, 6, 7, 8, 2, -3, 4, -4};
        ThreeSum threeSum = new ThreeSum();
        threeSum.threeSum(ints);
    }
}
