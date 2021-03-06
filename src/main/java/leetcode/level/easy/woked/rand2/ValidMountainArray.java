package leetcode.level.easy.woked.rand2;

public class ValidMountainArray {
    public boolean validMountainArray(int[] arr) {
        if (arr.length < 3) {
            return false;
        }
        boolean pr = true;

        int ii = 0;
        int tC = 0;
        int fC = 0;
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] == arr[i + 1]) {
                return false;
            }
            boolean now = arr[i] < arr[i + 1];
            tC += now ? 1 : 0;
            fC += now ? 0 : 1;
            if (pr != now) {
                ii++;
            }
            if (ii > 1) {
                return false;
            }
            pr = now;
        }
        return ii == 1&& tC>0 && fC>0;
    }
}
