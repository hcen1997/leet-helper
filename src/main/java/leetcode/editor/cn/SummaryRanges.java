package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

public class SummaryRanges {
    public static void main(String[] args) {
        List<String> strings = new SummaryRanges()
                .summaryRanges(new int[]
                        {0, 2, 3, 4, 6, 8, 9});
        for (String string : strings) {
            System.out.println("string = " + string);
        }
    }

    public List<String> summaryRanges(int[] nums) {
        ArrayList<String> ans = new ArrayList<>();
        if (nums.length == 0) {
            return ans;
        }
        if (nums.length == 1) {
            ans.add(nums[0] + "");
            return ans;
        }
        int left = 0;
        int right = 0;
        int next = 1;
        String sp = "->";
        for (; next < nums.length; next++) {
            if (nums[next] == nums[right] + 1) {
                right++;
            } else {
//                save(left, right);
                String d = "";
                if (left == right) {
                    d = nums[left] + "";
                } else {
                    d = nums[left] + sp + nums[right];
                }
                ans.add(d);
                left = next;
                right = next;
            }
        }
        // 保存边界
        if (left != right && right == nums.length-1) {
            String d = nums[left] + sp + nums[right];
            ans.add(d);
        } else {
            ans.add(nums[left] + "");
        }
//        if (nums[next - 1] == nums[right] + 1) {
//            String remove = ans.remove(ans.size() - 1);
//            if (remove.indexOf(sp) >=0) {
//                int st = remove.indexOf(sp) + sp.length();
//                String d = remove.substring(0, st) + nums[next - 1];
//                ans.add(d);
//            } else {
//                String d = remove + sp+nums[next - 1];
//                ans.add(d);
//            }
//        } else {
//            ans.add(nums[next - 1] + "");
//        }
        return ans;
    }
}
