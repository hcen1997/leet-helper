package leetcode.level.easy.rand4;

import leetcode.Utils;
import org.junit.Test;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;

public class SumAfterQueryTest extends SumAfterQuery {

    @Test
    public void testSumEvenAfterQueries() {
        int[] ints = Utils.stringToIntegerArray("[1,2,3,4]");
        int[][] ints1 = Utils.stringToInt2dArray("[[1,0],[-3,1],[-4,0],[2,3]]");
        int[] ints2 = sumEvenAfterQueries(ints, ints1);
        System.out.println("Arrays.toString(ints); = " + Arrays.toString(ints2));

    }
    @Test
    public void testbigs() throws URISyntaxException, IOException {
        List<String> strings = Files.readAllLines(Path.of("C:\\Users\\hcen\\leet-helper\\src\\test\\resources\\sum_even_test1.txt"));
        int[] ints = Utils.stringToIntegerArray(strings.get(0));
        int[][] ints1 = Utils.stringToInt2dArray(strings.get(1));
        int[] ints2 = sumEvenAfterQueries(ints, ints1);
        System.out.println("Arrays.toString(ints); = " + Arrays.toString(ints2));
    }
}