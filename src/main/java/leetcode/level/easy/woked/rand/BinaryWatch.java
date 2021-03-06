package leetcode.level.easy.woked.rand;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiConsumer;

public class BinaryWatch {
    /// 这是简单题? 这是简单题
    // 一开始想的是 生成比特 计算
    // 后来发现 可以不用生成比特 判断一下就行
    public List<String> readBinaryWatch(int num) {
        if (num < 0) {
            return new ArrayList<>();
        }
        if (num == 0) {
            ArrayList<String> strings = new ArrayList<>();
            strings.add("0:00");
            return strings;
        }
        if (num > 8) {
            return readBinaryWatch(-1);
        }

        List<String> ans = new ArrayList<>();
        // 分配一下n 上下
        ArrayList<ArrayList<Integer>> upDown = genUpDown(num);
        // 生成一下数字
        upDown.forEach(condition -> {
            int upBit = condition.get(0);
            int downBit = condition.get(1);
            List<Integer> possibleH = genNumByBitCount(upBit, 11);
            List<Integer> possibleM = genNumByBitCount(downBit, 59);
            List<String> set = doubleFor(possibleH, possibleM, this::getTime);
            ans.addAll(set);
        });
        return ans;
    }

    private List<String> doubleFor(List<Integer> possibleH, List<Integer> possibleM,
                                   BiConsumer<Integer, Integer> getTime) {
        ArrayList<String> ans = new ArrayList<>();
        possibleH.forEach(h ->
                possibleM.forEach(m ->
                        ans.add(getTime(h, m))
                ));
        return ans;
    }

    /**
     * up 最大 3位
     * down 最大 5位
     */
    ArrayList<ArrayList<Integer>> genUpDown(int num) {
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        for (int i = num; i >= 0; i--) {
            if (i > 3 || num - i > 5) {
                continue;
            }
            ArrayList<Integer> upDown = new ArrayList<>();
            upDown.add(i);
            upDown.add(num - i);
            ans.add(upDown);
        }
        return ans;
    }

    // 这个是没有用的 h = sumH
    String getTime(int h, int m) {
        String M = m < 10 ? "0" + m : "" + m;
        return h + ":" + M;
    }

    // 给定n位 输出一定范围内的所有可能数
    List<Integer> genNumByBitCount(int n, int max) {
        ArrayList<Integer> ans = new ArrayList<>();
        int start = 0;
        for (int i = 0; i <= max; i++) {
            if (Integer.bitCount(i) == n) {
                ans.add(i);
            }
        }
        return ans;
    }
}
