package leetcode.level.easy.rand3;

import java.util.Arrays;

public class SortLog {
    public String[] reorderLogFiles(String[] logs) {
        Arrays.sort(logs, (o1, o2) -> {
            String[] s = o1.split(" ");
            String[] ss = o2.split(" ");
            boolean alS = Character.isAlphabetic(s[1].charAt(0));
            boolean alSs = Character.isAlphabetic(ss[1].charAt(0));
//            所有 字母日志 都排在 数字日志 之前。
//            字母日志 在内容不同时，忽略标识符后，按内容字母顺序排序；在内容相同时，按标识符排序；
//            数字日志 应该按原来的顺序排列。
            if (alS && alSs) {
                if (eqSub(s, ss, 1)) {
                    return lexCompare(s[0], ss[0]);
                } else {
                    for (int i = 1; ; i++) {
                        if (s.length == i || ss.length == i) {
                            return s.length - ss.length;
                        } else {
                            int d = lexCompare(s[i], ss[i]);
                            if (d != 0) {
                                return d;
                            }
                        }
                    }
                }
            } else if (!alS && !alSs) {
                return 0;
            } else if (!alS) {
                return 1;
            } else {
                return -1;
            }
        });
        return logs;
    }

    /**
     * s.length ,ss.length > 0
     */
    private int lexCompare(String s, String ss) {
        for (int i = 0; ; i++) {
            if (s.length() == i || ss.length() == i) {
                return s.length() - ss.length();
            } else {
                int d = s.charAt(i) - ss.charAt(i);
                if (d != 0) {
                    return d;
                }
            }
        }
    }

    private boolean eqSub(String[] s, String[] ss, int start) {
        if (s.length != ss.length) {
            return false;
        }
        for (int i = start; i < s.length; i++) {
            if (!s[i].equals(ss[i])) {
                return false;
            }
        }
        return true;
    }

}
