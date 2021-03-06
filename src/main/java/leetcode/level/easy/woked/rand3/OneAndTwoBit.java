package leetcode.level.easy.woked.rand3;

public class OneAndTwoBit {
    public boolean isOneBitCharacter(int[] bits) {
        // 排除最后一个 其他必须从头开始可以被编码
        return isEncode(bits, 0, bits.length - 1);
    }

    boolean isEncode(int[] bits, int s, int e) {
        int index = 0;
        while (index < e) {
            if (bits[index] == 1 && index + 1 == e) {
                return false;
            }
            if (bits[index] == 0) {
                index++;
            } else {
                // b[i] = 1
                index++;
                index++;
            }
        }
        return true;
    }
}
