package leetcode.rand;


import leetcode.Utils;
import org.junit.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;

public class TimeNeedAllEmployeeTest extends TimeNeedAllEmployee {

    @Test
    public void map(){
        HashMap<Integer, Integer> integerIntegerHashMap = new HashMap<>();
        integerIntegerHashMap.put(1,1);
        integerIntegerHashMap.put(1,2);
        System.out.println();
    }


    @Test
    public void numOfMinutes() throws IOException {
        String s = Files.readString(Path.of("C:\\Users\\panze\\IdeaProjects\\Leet-code-helper\\src\\test\\java\\leecode\\easy\\rand\\", "timeEmpl.txt"));
        String[] split = s.split("\n");
        int n = 49610;
        int headId = 4231;
        String m = split[2];
        String i = split[3];
        int[] ints = Utils.stringToIntegerArray(m);
        int[] ints1 = Utils.stringToIntegerArray(i);
        long l = System.currentTimeMillis();
        int i1 = numOfMinutes(n, headId, ints, ints1);
        long l1 = System.currentTimeMillis() - l;
        System.out.println("i1 = " + i1);
        System.out.println("l1 time = " + l1);
    }
    @Test
    public void t2(){
        int n = 1;
        int headId = 0;
        String m = "[-1]";
        String i = "[0]";
        int[] ints = Utils.stringToIntegerArray(m);
        int[] ints1 = Utils.stringToIntegerArray(i);
        int i1 = numOfMinutes(n, headId, ints, ints1);
        System.out.println("i1 = " + i1);
    }
}