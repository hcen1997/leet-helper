package leetcode.level.easy.woked.rand;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class ReverseVowelChar {
    public String reverseVowels(String s) {
        char[] chars = s.toCharArray();
        Set<Character> vowel = init();
        ArrayList<Integer> vos = new ArrayList<>();
        for (int i = 0; i < chars.length; i++) {
            char aChar = chars[i];
            if (vowel.contains(aChar)) {
                vos.add((int) aChar);
                vos.add(i);
            }
        }
        for (int i = 0; i < vos.size(); i += 2) {
            char ch = (char) (int) vos.get(i);
            int index = vos.get(vos.size() - 1 - i);
            chars[index] = ch;
        }
        return String.valueOf(chars);
    }

    private Set<Character> init() {
        Set<Character> vowel = new HashSet<>();
        vowel.add('a');
        vowel.add('e');
        vowel.add('o');
        vowel.add('u');
        vowel.add('i');
        vowel.add('A');
        vowel.add('E');
        vowel.add('O');
        vowel.add('U');
        vowel.add('I');
        return vowel;
    }
}
