package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PTriII {
    public static void main(String[] args) {
        PTriII pTriII = new PTriII();
        List<Integer> row = pTriII.getRow(4);
        Object[] objects = row.toArray();
        System.out.println("Arr = " + Arrays.toString(objects));
    }
    public List<Integer> getRow(int rowIndex) {
        List<Integer> ans = new ArrayList<>();
        if (rowIndex == 0) {
            ans.add(1);
            return ans;
        } else if (rowIndex == 1) {
            ans.add(1);
            ans.add(1);
            return ans;
        } else {
            ans.add(1);
            List<Integer> last = getRow(rowIndex - 1);
            for (int i = 1; i < rowIndex ; i++) {
                ans.add(last.get(i - 1) + last.get(i));
            }
            ans.add(1);
            return ans;
        }
    }
}
