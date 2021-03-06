package leetcode.level.easy.woked.rand3;

import java.util.ArrayList;
import java.util.List;

public class FizzBuzz {
    public List<String> fizzBuzz(int n) {
        ArrayList<String> ans = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            boolean b3 = i % 3 == 0;
            boolean b5 = i % 5 == 0;
            if (b3 && b5) {
                ans.add("FizzBuzz");
            } else if (b3) {
                ans.add("Fizz");
            } else if (b5) {
                ans.add("Buzz");
            } else {
                ans.add(String.valueOf(i));
            }
        }
        return ans;
    }
}
