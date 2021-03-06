package leetcode.level.easy.woked.rand5;

import leetcode.Utils;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BinarySearchTest extends BinarySearch {
    @Test
    public void testZero() {
        int search = search(new int[]{}, 0);
        assertEquals(-1, search);
    }

    @Test
    public void testSearch10() {
        // 测试长度数组， 根据
        int[] ints = Utils.stringToIntegerArray("[1,2,3,4,5,6]");
        int target = 5;
        int search = search(ints, target);
        assertEquals(4,search);
    }
    @Test
    public void testSearch102() {
        // 测试长度数组， 根据
        int[] ints = Utils.stringToIntegerArray("[2,5]");
        int target = 0;
        int search = search(ints, target);
        assertEquals(-1,search);
    }
    @Test
    public void testSearch1() {
        // 测试长度数组， 根据
        for (int i = 1; i <= 1000; i++) {
            testArr(i);
        }
    }
    @Test
    public void testSearch100_0000() {
        testArr(100_0000);
    }
    @Test
    public void testSearch100_0000_000() {
        testArr(100_0000_00);
    }

    private void testArr(int i) {
        int[] arr = new int[i];
        for (int j = 0; j < i; j++) {
            arr[j] = j;
        }
        for (int item : arr) {
            int search = search(arr, item);
            assertEquals(item,search);
        }
    }

}