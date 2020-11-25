package leetcode.editor.cn;

import java.util.ArrayList;

public class SameStrucString {
    public boolean isIsomorphic(String s, String t) {
        char[] sc = s.toCharArray();
        char[] tc = t.toCharArray();
        ArrayList<Character> si = new ArrayList<>(1 << Character.SIZE);
        ArrayList<Character> ti = new ArrayList<>(1 << Character.SIZE);
        hashChars(sc, si);
        hashChars(tc, ti);
        boolean isI = true;
        for (int i = 0; i < sc.length; i++) {
            if( si.indexOf(sc[i])!=ti.indexOf(tc[i])){
                isI = false;
                break;
            }
        }
        return isI;
    }

    private void hashChars(char[] cc, ArrayList<Character> ii) {
        for (int i = 0; i < cc.length; i++) {
            Character c = cc[i];
            if (!ii.contains(c)) {
                ii.add(c);
            }
        }
    }
}
