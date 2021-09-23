package leetcode.zozz.winter;

import leetcode.Utils;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

/**
 * 给你一个整数数组 nums 和两个整数 k 和 t 。请你判断是否存在 两个不同下标 i 和 j，使得 abs(nums[i] - nums[j]) <= t ，同时又满足 abs(i - j) <= k 。
 * <p>
 * 如果存在则返回 true，不存在返回 false。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * 输入：nums = [1,2,3,1], k = 3, t = 0
 * 输出：true
 * <p>
 * 示例 2：
 * 输入：nums = [1,0,1,1], k = 1, t = 2
 * 输出：true
 * <p>
 * 示例 3：
 * 输入：nums = [1,5,9,1,5,9], k = 2, t = 3
 * 输出：false
 * <p>
 * 提示：
 * 0 <= nums.length <= 2 * 104
 * -231 <= nums[i] <= 231 - 1
 * 0 <= k <= 104
 * 0 <= t <= 231 - 1
 * <p>
 * 通过次数64,072
 * 提交次数223,360
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/contains-duplicate-iii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class contains_duplicate_iii {
    @Test
    public void tt() {
        Solution solution = new Solution();
        Assert.assertEquals(solution.containsNearbyAlmostDuplicate(
                Utils.stringToIntegerArray("[1,2,3,1]")
                , 3, 0
        ), true);
        Assert.assertEquals(solution.containsNearbyAlmostDuplicate(
                Utils.stringToIntegerArray("[1,0,1,1]")
                , 1, 2
        ), true);
        Assert.assertEquals(solution.containsNearbyAlmostDuplicate(
                Utils.stringToIntegerArray("[1,5,9,1,5,9]")
                , 2, 3
        ), false);

        Assert.assertEquals(solution.containsNearbyAlmostDuplicate(
                Utils.stringToIntegerArray("[-2147483648,2147483647]")
                , 1, 1
        ), false);
        Assert.assertEquals(solution.containsNearbyAlmostDuplicate(
                Utils.stringToIntegerArray("[2147483646,2147483647]")
                , 3, 3
        ), true);

    }

//        在 nums.length> 1000, k =1000, t=0的时候， 非常慢

    class Solution {
        public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
            for (int i = 0; i < nums.length; i++) {
//                滑动窗口
                int st = Math.max(i - k, 0);
                int ed = Math.min(i + k, nums.length - 1);
                for (int j = st; j != i && j <= ed; j++) {
                    // 考虑到负数
                    if (Math.abs((long) nums[i] - (long) nums[j]) <= t) {
                        return true;
                    }
                }
            }
            return false;
        }
    }
}
