package leetcode.easy.rand3;

public class DeepDarkFriction {
    public int[] fraction(int[] cont) {
        int l = cont.length - 1;
        int[] upDown = cal(cont[l - 1], 1, cont[l]);
        for (int i = l; i >= 0; i--) {
            upDown = cal(cont[i], upDown[1], upDown[0]);
        }
        return upDown;
    }

    private int[] cal(int left, int up, int down) {
        int[] ints = new int[2];
        int upT = left * down + up;
        int downT = down;
        ints[0] = upT;
        ints[1] = downT;
        return ints;
    }
}
