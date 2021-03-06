package leetcode.level.easy.woked.rand;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class BinaryWatchTest extends BinaryWatch {

    @Test
    public void readBinaryWatch() {
        for (int i = 0; i < 9; i++) {
            System.out.println("i = " + i);
            List<String> strings = readBinaryWatch(i);
            String[] objects = strings.toArray(new String[0]);
            System.out.println("Arrays.toString(ob) = " + Arrays.toString(objects));
            System.out.println();
        }
    }

    @Test
    public void upDown() {
        ArrayList<ArrayList<Integer>> arrayLists1 = genUpDown(1);
        ArrayList<ArrayList<Integer>> arrayLists2 = genUpDown(2);
        ArrayList<ArrayList<Integer>> arrayLists3 = genUpDown(3);
        ArrayList<ArrayList<Integer>> arrayLists4 = genUpDown(4);
        ArrayList<ArrayList<Integer>> arrayLists5 = genUpDown(5);
        ArrayList<ArrayList<Integer>> arrayLists6 = genUpDown(6);
        ArrayList<ArrayList<Integer>> arrayLists7 = genUpDown(7);
        ArrayList<ArrayList<Integer>> arrayLists8 = genUpDown(8);
    }

    @Test
    public void getTime() {
        assertEquals(getTime(0b10,0b10),"2:02");
        assertEquals(getTime(12,3),"12:03");
        assertEquals(getTime(8,12),"8:12");
        assertEquals(getTime(0,0),"0:00");
    }
}