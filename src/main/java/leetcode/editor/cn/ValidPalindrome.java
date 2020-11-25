package leetcode.editor.cn;

/**
 * @author panze
 */
public class ValidPalindrome {
    public static void main(String[] args) {
        String s = "A man, a plan, a canal: Panama";
        boolean palindrome = new ValidPalindrome().isPalindrome(s);
        System.out.println("palindrome = " + palindrome);
    }
    public boolean isPalindrome(String s) {
        if (s.length() == 0) {
            return true;
        }
        char[] chars = s.toCharArray();
        // 生成纯净的字符串
        int size = 0;
        char[] pr = new char[chars.length];
        for (int i = 0; i < chars.length; i++) {
            char c = chars[i];
            if (c <= 'Z' && c >= 'A') {
                c = (char) ('a' + c - 'A');
            }
            if ((c >= '0' && c <= '9')
                    || (c >= 'a' && c <= 'z')) {
                pr[size] = c;
                size++;
            }
        }
        int front = 0;
        int back = size - 1;
        boolean isP = true;
        if (size % 2 == 0) {
            while (front < back) {
                if (pr[front] != pr[back]) {
                    isP = false;
                    break;
                }
                front++;
                back--;
            }
        } else {
            while (front != back) {
                if (pr[front] != pr[back]) {
                    isP = false;
                    break;
                }
                front++;
                back--;
            }
        }
        return isP;
    }
}

