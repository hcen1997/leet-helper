package leecode.easy.rand;

import leetcode.Utils;
import org.junit.Test;

import static org.junit.Assert.*;

public class FriendCirclesTest extends FriendCircles {

    @Test
    public void findCircleNum() {
        int[][] ints = Utils.stringToInt2dArray(
                "[[1,0,0,1]," +
                "[0,1,1,0]," +
                "[0,1,1,1]," +
                "[1,0,1,1]]");
        int circleNum = findCircleNum(ints);
        System.out.println("circleNum = " + circleNum);
    }
}