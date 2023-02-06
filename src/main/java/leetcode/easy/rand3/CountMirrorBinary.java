package leetcode.easy.rand3;

import java.util.*;

public class CountMirrorBinary {
    // 先根据种子 找到所有种子的位置
    // 然后根据种子的位置 增长 直到搜不到级下一个
    public int countBinarySubstrings(String s) {
        int ans = 0;
        ArrayList<Integer> todo = new ArrayList<>();
        ArrayList<Integer> target = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            target.add(i);
        }
        todo.addAll(target);
        int level = 2;
        while (todo.size() > 0) {
            Iterator<Integer> iterator = todo.iterator();
            target.clear();
            String[] seed = calSeed(level);
            int i;
            while (iterator.hasNext()) {
                i = iterator.next();
                if (match(s, i, seed)) {
                    ans++;
                    target.add(i);
                }
            }
            level += 2;
            todo.clear();
            todo.addAll(target);
        }
        return ans;
    }
    private String sub(String s, int st,int en){
        if(en>s.length()){
            return s.substring(st);
        }else if(st<0) {
            return s.substring(0,en);
        }
        return s.substring(st,en);
    }
    private boolean match(String s, int i, String[] seed) {
        int box = seed[0].length();
        for (String see : seed) {
            if (box == 2) {
                if (sub(s,i, i + box).equals(see)) {
                    return true;
                }
            } else {
                if (sub(s,i - 1, i + box).equals(see)) {
                    return true;
                }
            }

        }
        return false;
    }

    private String[] calSeed(int level) {
        String[] ans = new String[2];
        char[] seed0 = new char[level / 2];
        char[] seed1 = new char[level / 2];
        Arrays.fill(seed0, '0');
        Arrays.fill(seed1, '1');
        ans[0] = String.valueOf(seed0) + String.valueOf(seed1);
        ans[1] = String.valueOf(seed1) + String.valueOf(seed0);
        return ans;
    }


}
