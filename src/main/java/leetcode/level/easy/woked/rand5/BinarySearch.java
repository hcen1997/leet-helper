package leetcode.level.easy.woked.rand5;

public class BinarySearch {
    public int search(int[] nums, int target) {
        if (nums.length == 0) {
            return -1;
        } else {
            return searchO(nums, target);
        }
    }

    int searchO(int[] nums, int target) {
        // nums is sorted
        int mid, start, end;
        int p;
        start = 0;
        end = nums.length - 1;
        mid = (start + end) / 2;
        while ((p = nums[mid]) != target) {
            // 边界条件 找不到的跳出循环
            if (start >= end) {
                return -1;
            }
            if (p < target) {
                start = mid + 1;
            } else if (p > target) {
                end = mid - 1;
            }
            mid = (start + end) / 2;
        }
        return mid;
    }
}
