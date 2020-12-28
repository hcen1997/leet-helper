package leetcode.level.easy.rand2;

import leetcode.Utils;
import org.junit.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;

public class SlidingWindowMaxTest extends SlidingWindowMax {

    @Test
    public void testMaxSlidingWindow() {
        int[] ints = Utils.stringToIntegerArray("[1,3,-1,-3,5,3,6,7]");
        int[] ints1 = maxSlidingWindow(ints, 3);
        System.out.println("Arrays.toString(ints1) = " + Arrays.toString(ints1));
    }

    @Test
    public void t2() throws IOException {
        String s = Files.readString(Path.of("C:\\Users\\panze\\IdeaProjects\\Leet-code-helper\\src\\main\\java\\leetcode\\easy\\rand2\\bigInts.txt"));
        s = s.split("\n")[0];
        int[] ints = Utils.stringToIntegerArray(s);
        long l = System.currentTimeMillis();
        int[] ints1 = maxSlidingWindow(ints, 50000);
        long l1 = System.currentTimeMillis() - l;
        System.out.println("ints1 = " + Arrays.toString(ints1));
        System.out.println("ints.length = " + ints.length);
        System.out.println("l1 = " + l1);
        for (int i = 0; i < ints1.length; i++) {
            if (ints1[i] != 9999) {
                System.out.println("dfdfff");
            }
        }
    }
    @Test
    public void t3() throws IOException {
        String s = Files.readString(Path.of("C:\\Users\\panze\\IdeaProjects\\Leet-code-helper\\src\\main\\java\\leetcode\\easy\\rand2\\big1.txt"));
        String[] s1 = s.split("\n");
        int[] ints = Utils.stringToIntegerArray(s1[0]);
        int aa = Integer.parseInt(s1[1]);
        long l = System.currentTimeMillis();
        int[] ints1 = maxSlidingWindow(ints, aa);
        long l1 = System.currentTimeMillis() - l;
        System.out.println("ints1 = " + Arrays.toString(ints1));
        System.out.println("ints.length = " + ints.length);
        System.out.println("l1 = " + l1);
        for (int i = 0; i < ints1.length; i++) {
            if (ints1[i] != 10000) {
                System.out.println("dfdfff");
            }
        }
    }
}