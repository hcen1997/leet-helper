package leetcode.level.mid;

import org.junit.Test;

import java.util.List;

public class DicOrderTest extends DicOrder {

    @Test
    public void testLexicalOrder() {
        List<Integer> integers = lexicalOrder(20);
        for (int i = 0; i < integers.size(); i++) {
            System.out.println("integers = " + integers.get(i));
        }
    }
}