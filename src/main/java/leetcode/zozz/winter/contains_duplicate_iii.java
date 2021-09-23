package leetcode.zozz.winter;

import leetcode.Utils;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.TreeSet;

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
        // 使用tree set 速度从1800降到300
        long st = System.currentTimeMillis();
        Assert.assertEquals(solution.containsNearbyAlmostDuplicate(
                Utils.stringToIntegerArray(
                        Utils.getLongTextIn("E:\\git\\leet-helper\\src\\main\\java\\leetcode\\zozz\\longtext\\longArray.txt",
                                1)
                )
                , 10000, 0
        ), false);
        System.out.println("total " + (System.currentTimeMillis() - st));
        Assert.assertEquals(solution.containsNearbyAlmostDuplicate(Utils.stringToIntegerArray("[1,2]"),
                0,
                1
        ), false);
    }

    //        在 nums.length> 1000, k =1000, t=0的时候， 非常慢
    class Solution {
        public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
            return treeSetButFast(nums, k, t);
        }


        private boolean treeSetButFast(int[] nums, int k, int t) {
            TreeSet<Long> treeSet = new TreeSet<>();

            for (int i = 0; i < nums.length; i++) {
                Long ceiling = treeSet.ceiling((long) ((long) nums[i] - (long) t));
                if (ceiling != null && ceiling <= (long) nums[i] + (long) t) {
                    return true;
                }

                // treeSet 有重复的小问题, 但是在添加之前存在的话, 应该就返回true了
                treeSet.add((long) nums[i]);
                if (treeSet.size() == k + 1) {
                    treeSet.remove((long) nums[i - k]);
                }
            }
            return false;
        }

        // 这种滑动窗口， 只是减小了1/3的循环
        // 为什么还是慢？ 要解决什么问题？？
        // 遍历数组， 增加数字肯定是要做的
        // 但是k变大的话， O(n)的单独（的查找算法太慢了
        // 所以需要一个有序的, 删除, 添加, 查找速度都在log(n) 的数据结构,
        // 就是tree set
        private boolean complexButFast(int[] nums, int k, int t) {
            // 滑动窗口
            // 1. k中
            // 1 2 3 4 5 6 7 8
            long count = 0;
            for (int i = Math.min(k, nums.length - 1); i < nums.length; i++) {
                for (int j = 1; i - j >= 0 && j <= k; j++) {
                    count++;
                    if (Math.abs((long) nums[i] - (long) nums[i - j]) <= t) {
                        return true;
                    }
                }
            }
            System.out.println("count = " + count);
            return false;
        }

        private boolean simpleButSlow(int[] nums, int k, int t) {
            long count = 0;
            for (int i = 0; i < nums.length; i++) {
//                窗口
                int st = Math.max(i - k, 0);
                int ed = Math.min(i + k, nums.length - 1);
                for (int j = st; j != i && j <= ed; j++) {
                    // 考虑到负数
                    count++;
                    if (Math.abs((long) nums[i] - (long) nums[j]) <= t) {
                        return true;
                    }
                }
            }
            System.out.println("count = " + count);
            return false;
        }
    }
}
