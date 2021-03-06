package leetcode.level.easy.woked.rand3;

import leetcode.Utils;
import org.junit.Test;

import java.awt.*;

public class FindWayInKTest extends FindWayInK {
    @Override
    public int numWays(int n, int[][] relation, int k) {
        return super.numWays(n, relation, k);
    }

    @Override
    int hasWayInK(int s, int e, int[][] re, int k) {
        System.out.print("s = " + s);
        System.out.println(" k = " + k);
        return super.hasWayInK(s, e, re, k);
    }

    @Test
    public void testNumWays() {
        String input = "[[0,2],[2,1],[3,4],[2,3],[1,4],[2,0],[0,4]]";
        System.out.println("input = " + input);
        int[][] re = Utils.stringToInt2dArray(input);
        int i = numWays(5, re, 3);
        System.out.println("i = " + i);
    }

    @Test
    public void testHasWayInK() throws AWTException {
        Robot robot=new Robot();
        int k=10;
        int x=666;
        int y=666;
        while((--k)>0)
        {
            robot.mouseMove(x,y);
        }
    }
}
