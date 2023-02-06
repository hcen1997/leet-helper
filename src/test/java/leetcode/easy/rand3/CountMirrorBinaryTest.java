package leetcode.easy.rand3;

import org.junit.Test;

import static org.junit.Assert.*;

public class CountMirrorBinaryTest extends CountMirrorBinary {
    @Test
    public void test(){
        int i = countBinarySubstrings("00110011");
        System.out.println("i = " + i);
    }

}