package leetcode.easy.rand4;

public class BinaryWithAlterBits {
    public boolean hasAlternatingBits(int n) {
        String s = Integer.toBinaryString(n);
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length-1; i++) {
            if(chars[i+1]==chars[i]){
                return false;
            }
        }
        return true;
    }
}
