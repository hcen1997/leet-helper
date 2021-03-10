package leetcode.level.easy.resume2021.rand1;

import leetcode.Utils;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class CheckPossibilityTest extends CheckPossibility {
    @Test
    public void test1(){
        int[] ints = Utils.stringToIntegerArray("[3,4,2,3]");
        boolean b = checkPossibility(ints);
        Assert.assertSame(b,false);
    }
    @Test
    public void test2(){
        int[] ints = Utils.stringToIntegerArray("[5,7,1,8]");
        boolean b = checkPossibility(ints);
        Assert.assertSame(b,true);
    }
    @Test
    public void test3(){
        int[] ints = Utils.stringToIntegerArray("[-1,4,2,3]");
        boolean b = checkPossibility(ints);
        Assert.assertSame(b,true);
    }
    @Test
    public void test4(){
        int[] ints = Utils.stringToIntegerArray("[1,-1,0,4,5,6,7,8]");
        boolean b = checkPossibility(ints);
        Assert.assertSame(b,true);
    }
    @Test
    public void test5(){
        int[] ints = Utils.stringToIntegerArray("[0,1,-1,0,4,5,6,7,8]");
        boolean b = checkPossibility(ints);
        Assert.assertSame(b,false);
    }

}