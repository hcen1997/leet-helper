package leetcode.level.easy.rand3;

import leetcode.Utils;
import org.junit.Test;

import java.util.Arrays;

public class SortLogTest extends SortLog {

    @Test
    public void testReorderLogFiles() {
        String[] strings = Utils.stringToStringArray("[\"dig1 8 1 5 1\",\"let1 art can\",\"dig2 3 6\",\"let2 own kit dig\",\"let3 art zero\"]");
        String[] strings1 = reorderLogFiles(strings);
        String s = Arrays.toString(strings1);
        System.out.println("s = " + s);
    }
}