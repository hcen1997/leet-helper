package leecode.easy.rand;

import java.util.*;

public class TimeNeedAllEmployee {

    public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
        int max = 0;
        // 模拟
        Map<Integer, List<Integer>> parentToChildren = new LinkedHashMap<>();
        for (int son = 0; son < n; son++) {
            int parent = manager[son];
            List<Integer> children = parentToChildren.get(parent);
            if (children == null) {
                children = new ArrayList<>();
            }
            children.add(son);
            parentToChildren.put(parent, children);
        }
        Queue<Integer> parents = new LinkedList<>();
        parents.add(headID);

        while (parents.size() != 0) {
            int parent = parents.remove();
            List<Integer> children = parentToChildren.get(parent);
            for (int child : children) {
                if (informTime[child] == 0) {
                    informTime[child] += informTime[parent];
                    max = Math.max(informTime[child], max);
                } else {
                    parents.add(child);
                    informTime[child] += informTime[parent];
                }
            }
        }
        return max;
    }
}
