package leetcode.zozE;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode.cn/problems/remove-sub-folders-from-the-filesystem/
 */
public class DeleteSubDir {
    class Solution {
        public List<String> removeSubfolders(String[] folder) {
            Arrays.sort(folder);
            List<String> ans = new ArrayList<>();
            ans.add(folder[0]);
            int head = 0;
            for (int i = 1; i < folder.length; i++) {
                if (folder[i].startsWith(folder[head] + "/")) {
                    continue;
                } else {
                    ans.add(folder[i]);
                    head = i;
                }
            }
            return ans;
        }
    }
}
