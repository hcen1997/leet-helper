package leetcode.rand;

import leetcode.Utils;
import org.junit.Test;

public class ImageSofterTest extends ImageSofter{

    @Test
    public void imageSmoother() {
        String s = "[[1,1,1],[1,0,1],[1,1,1]]";
        int[][] ints = Utils.stringToInt2dArray(s);
        int[][] ints1 = imageSmoother(ints);
        System.out.println();
    }
    @Test
    public void imageSmoot1er() {
        String s = "[[1,1]]";
        int[][] ints = Utils.stringToInt2dArray(s);
        int[][] ints1 = imageSmoother(ints);
        System.out.println();
    }
}