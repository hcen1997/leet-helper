package leetcode.easy.rand2;

import leetcode.Utils;
import org.junit.Test;

import static org.junit.Assert.*;

public class SlowestKeyTest extends SlowestKey {

    @Test
    public void testSlowestKey() {
        char spuda = slowestKey(Utils.stringToIntegerArray("[12,23,36,46,62]"),
                "spuda");
        System.out.println("spuda = " + spuda);
    }
}