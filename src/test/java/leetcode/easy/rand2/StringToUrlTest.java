package leetcode.easy.rand2;

import org.junit.Test;

import static org.junit.Assert.*;

public class StringToUrlTest extends StringToUrl {

    @Test
    public void testReplaceSpaces() {
        replaceSpaces("Mr John Smith    ",13);
    }
    @Test
    public void testReplaceSpaces1() {


        replaceSpaces("ds sdfs afs sdfa dfssf asdf             ",27);
    }
}