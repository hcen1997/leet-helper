package leetcode.level.easy.woked.rand2;

import org.junit.Test;

import java.util.*;

public class RepeatElementTest extends RepeatElement {

    @Test
    public void testRepeatedNTimes() {
    }
    @Test
    public void rand() {
        Integer[] ints = new Integer[200];
        for (int i = 0; i < ints.length; i++) {
            ints[i]=i;
        }
        List<Integer> ii = Arrays.asList(ints);
        Collections.shuffle(ii);
        HashSet<Integer> integers = new HashSet<>(ii);
        System.out.println("integers = " + integers.size());
    }
}