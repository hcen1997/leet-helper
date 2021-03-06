package leetcode.level.easy.woked.rand4;

public class MakeTwoArraysEqualByReversingSubArrays {
    public boolean canBeEqual(int[] target, int[] arr) {
        int i = 0;

        for (; i < target.length; i++) {
            if (target[i] == arr[i]) {
                continue;
            }
            // 在 arr中查找target[i]
            int tar;
            if ((tar = find(arr, target[i], i)) != -1) {
                rev(arr, i, tar);
            } else {
                return false;
            }
        }
        return i == target.length;
    }

    void rev(int[] arr, int i, int tar) {
        int[] clone = arr.clone();
        for (int j = 0; j <= tar - i; j++) {
            arr[i + j] = clone[tar - j];
        }
    }

    private int find(int[] arr, int target, int start) {
        for (int j = start; j < arr.length; j++) {
            if (arr[j] == target) {
                return j;
            }
        }
        return -1;
    }
}
