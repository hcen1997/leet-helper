package leetcode.level.easy.woked.rand5;

public class ToLowerCase {
    public String toLowerCase(String str) {
        char[] chars = str.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            char aChar = chars[i];
            if(isUpperCase(aChar)){
                chars[i]=toLowerCase(aChar);
            }
        }
        return new String(chars);
    }

    private char toLowerCase(char aChar) {
        return (char) ('a' + aChar - 'A');
    }

    private boolean isUpperCase(char aChar) {
        return aChar>='A'&&aChar<='Z';
    }
}
