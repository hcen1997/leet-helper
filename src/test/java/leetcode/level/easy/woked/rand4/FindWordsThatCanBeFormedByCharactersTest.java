package leetcode.level.easy.woked.rand4;

import org.junit.Test;

import static org.junit.Assert.*;

public class FindWordsThatCanBeFormedByCharactersTest extends FindWordsThatCanBeFormedByCharacters {

    @Test
    public void testCountCharacters() {
        int atach = countCharacters(new String[]{"cat", "bt", "hat", "tree"}, "atach");
        assertEquals(6,atach);
    }
}