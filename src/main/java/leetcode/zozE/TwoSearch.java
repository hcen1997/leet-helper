package leetcode.zozE;


import java.util.Arrays;

public class TwoSearch {
    class Solution {
        public int search(int[] nums, int target) {
//            Arrays.binarySearch()
            int head = 0;
            int last = nums.length - 1;

            while (head <= last) {
                int mid = last + (head - last) / 2;
                if (nums[mid] == target) {
                    return mid;
                } else if (nums[mid] < target) {
                    head = mid + 1;
                } else if (nums[mid] > target) {
                    last = mid - 1;
                }
            }
            return -1;
        }
    }
}
