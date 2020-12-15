package leetcode.mid;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class DicOrder {
    public List<Integer> lexicalOrder(int n) {
        LinkedList<Integer> ans = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            ans.add(i);
        }
        Collections.sort(ans, (a, b) -> -lexComp(a, b));
        return ans;
    }

    static int lexComp(int a, int b) {
        return lexComp(String.valueOf(a), String.valueOf(b));
    }

    private static int lexComp(String a, String b) {
        // 如果a的长度是0 返回1
        // 如果b的长度是0 返回-1
        // 如果都不等于0
        // 如果不能得到指定的位 返回 b.length-a.length
        // 返回b0-a0
        for (int i = 0; ; i++) {
            if (i == a.length() || i == b.length()) {
                return b.length() - a.length();
            } else {
                int d = b.charAt(i) - a.charAt(i);
                if (d != 0) {
                    return d;
                }
            }
        }
    }

}
