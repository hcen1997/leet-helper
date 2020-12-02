package leecode.easy.rand;

import java.util.LinkedList;
import java.util.Queue;

public class TimeNeedAllEmployee {

    public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
        int max = 0;
        // 模拟
        int notKnow = n;
        Queue<Integer> queue = new LinkedList<>();
        queue.add(headID);
        // 处理n个人
//            update(manager,informTime,headID)
        while (queue.size() != 0) {
            int parent = queue.remove();
            for (int j = 0; j < n; j++) {// 这里可以不用for 用 树
                if (manager[j] == parent) {
                    if (informTime[j] == 0) {
                        informTime[j] += informTime[parent];
                        max = Math.max(informTime[j], max);
                    } else {
                        queue.add(j);
                        informTime[j] += informTime[parent];
                    }
                }
            }
        }
        // 找到最大值
        return max;
    }
}
