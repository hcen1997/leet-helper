package leetcode.level.easy.two;

import java.util.Arrays;

public class Rotate {
    public static void main(String[] args) {
        int[] n = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12};
        Rotate rotate = new Rotate();
        rotate.rotate(n, 10);
        System.out.println("Arrays.toString(n) = " + Arrays.toString(n));

    }

    public void rotate(int[] nums, int k) {
        int d = k % nums.length;
        if (d == 0) {
            return;
        }
        if (nums.length % 2 == 0 && nums.length / 2 == d) {
            // 半组 移动
            for (int i = 0; i < d; i++) {
                swap(nums, i, i + d);
            }
            return;
        }
//        if (d == 1) {
//            one(nums);
//        }
        if (nums.length % d == 0) {
            // 不涉及组外转换
            int men = nums.length / d;
            for (int i = 0; i < d; i++) {
                int target = d;
                for (int j = 0; j < men - 1; j++) {
                    swap(nums, i, i + target);
                    target += d;
                }
            }
        } else if (d < nums.length / 2 || maxSh(nums.length, d) == 1) {
            // 这个只能做到互质的两个数
            int size = nums.length;
            int target = 0;
            for (int i = 0; i < size - 1; i++) {
                target = (target + d) % size;
                swap(nums, 0, target);
            }
        } else {
            int s = maxSh(nums.length, d);
            int count = d/s;
            for (int i = 0; i < count; i++) {
                rotate(nums,s);
            }
        }
    }

    private int maxSh(int bb, int b) {
        if (bb % b   == 0) {
            return b;
        } else {
            return maxSh(b, bb % b);
        }
    }

    private void one(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            swap(nums, 0, i);
        }
    }

    void swap(int[] n, int a, int b) {
        n[a] = n[a] ^ n[b];
        n[b] = n[a] ^ n[b];
        n[a] = n[a] ^ n[b];
    }
}
