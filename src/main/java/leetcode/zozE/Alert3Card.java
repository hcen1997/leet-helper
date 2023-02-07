package leetcode.zozE;

import leetcode.Utils;
import org.junit.Assert;
import org.junit.Test;

import java.util.*;

public class Alert3Card {
    @Test
    public void tt() {
        Solution solution = new Solution();
        Assert.assertEquals(
                solution.alertNames(Utils.stringToStringArray("[\"daniel\",\"daniel\",\"daniel\",\"luis\",\"luis\",\"luis\",\"luis\"]"),
                        Utils.stringToStringArray("[\"10:00\",\"10:40\",\"11:00\",\"09:00\",\"11:00\",\"13:00\",\"15:00\"]")),
                List.of("daniel"));

    }


    class Solution {
        public List<String> alertNames(String[] keyName, String[] keyTime) {
            // 1. 处理原始数据, 转换为 每个员工的所有有序时间记录 2. 判断时间是否发送警告
            Map<String, List<Integer>> card3 = new HashMap<>();
            for (int i = 0; i < keyName.length; i++) {
                String name = keyName[i];
                String time = keyTime[i];
                card3.putIfAbsent(name, new ArrayList<>());
                int timeI = Integer.parseInt(time.substring(0, 2)) * 60 + Integer.parseInt(time.substring(3, 5));
                card3.get(name).add(timeI);
            }
            List<String> ans = new ArrayList<>();
            for (String name : card3.keySet()) {
                List<Integer> times = card3.get(name);
                Collections.sort(times);
                for (int i = 0; i < times.size() - 2; i++) {
                    if (times.get(i + 2) - times.get(i) <= 60) {
                        ans.add(name);
                        break;
                    }
                }
            }
            Collections.sort(ans);
            return ans;
        }
    }
}
