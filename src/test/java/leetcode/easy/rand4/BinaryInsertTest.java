package leetcode.easy.rand4;

import org.junit.Test;

import static org.junit.Assert.*;

public class BinaryInsertTest extends BinaryInsert {

    @Test
    public void testInsertBits() {
        int i = insertBits(1024,
                19,
                2,
                6);
    }
    @Test
    public void testInsertBits1() {
        int i = insertBits(2032243561,
                10,
                24,
                29);
        }
}