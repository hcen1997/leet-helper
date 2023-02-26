package leetcode.zozE.compite;

import leetcode.Utils;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SingleWeek334 {
    class Solution {
        public int[] divisibilityArray(String word, int m) {
            // 快速整除 拆数法  有一部分可以被整除, 剩下的部分可以吗?  // 这个思路是百度出来的, 因为我意识到需要一种方法快速判断是否符合规则,
            int n = word.length();
            long c = 0;
            int[] ans = new int[n];
            for (int i = 0; i < n; i++) {
                c = c * 10 + (long) (word.charAt(i) - '0');
                if (c % m == 0) {
                    ans[i] = 1;
                    c = 0;
                } else {
                    ans[i] = 0;
                    c = c % m;
                }
            }
            return ans;
        }
    }
    @Test
    public void t1(){
        int [] a = Utils.stringToIntegerArray("[42,83,48,10,24,55,9,100,10,17,17,99,51,32,16,98,99,31,28,68,71,14,64,29,15,40]");
//        new Solution2().maxNumOfMarkedIndices(a);
//        a = Utils.stringToIntegerArray("[3,5,2,4]");
//        new Solution2().maxNumOfMarkedIndices(a);
//        a = Utils.stringToIntegerArray("[9,2,5,4]");
//        new Solution2().maxNumOfMarkedIndices(a);
//        a = Utils.stringToIntegerArray("[7,6,8]");
//        new Solution2().maxNumOfMarkedIndices(a);
        a = Utils.stringToIntegerArray("[1,78,27,48,14,86,79,68,77,20,57,21,18,67,5,51,70,85,47,56,22,79,41,8,39,81,59,74,14,45,49,15,10,28,16,77,22,65,8,36,79,94,44,80,72,8,96,78,39,92,69,55,9,44,26,76,40,77,16,69,40,64,12,48,66,7,59,10]");
        new Solution2().maxNumOfMarkedIndices(a);
    }


    class Solution2 {
        private int bsearch(int[] n,int a,int b ,int t){
            int mid = a + (b-a)/2;
            while (a<=b){
                mid = a + (b-a)/2;
                if(n[mid]==t){
                    return mid;
                }else if(n[mid]<t){
                    a = mid+1;
                }else {
                    b = mid-1;
                }
            }
            while ( mid < n.length && n[mid]<t) mid++;
            return mid;
        }
        public int maxNumOfMarkedIndices(int[] nums) {
            int n = nums.length;
            // 整道题就是2分搜索, 等等
            // 最大次数是 n/2*2
            // 匹配策略是 最小的
            Arrays.sort(nums);
            int[] sig = new int[n];
            int i1 = 0, i2 = 0;

            for (;i2 < n && i2<(n+1)/2;i2++){
                int b = bsearch(nums,0,n-1,nums[i2]*2);
                if(b!=-1 && b!=n){
                    fill(sig,b);
                    sig[i2] = 1;
                }
            }
            int ans= 0;
            for (int i = 0; i < sig.length; i++) {
                if(sig[i]>0) ans ++;
            }

            return ans/2 *2;
        }

        private void fill(int[] sig, int b) {
            for (int i = b;i<sig.length;i++){
                sig[i]++;
            }
        }
    }
}
