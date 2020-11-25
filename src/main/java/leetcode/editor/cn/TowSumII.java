package leetcode.editor.cn;

import java.util.Arrays;

public class TowSumII {
    public static void main(String[] args) {
        int[] ints = {2, 7, 11, 15};
        int t = 9;
        int[] ints1 = new TowSumII().twoSum(ints, t);
        System.out.println("Arrays.toString(ints1) = " + Arrays.toString(ints1));
    }
    public int[] twoSum(int[] numbers, int target) {
        int i=0;
        int j=1;
        int big = numbers.length-1;
        for (int k = 0; k < numbers.length; k++) {
            if(numbers[k]>target){
                big=k;
                break;
            }
        }

        http:
        for (i = big; i >0; i--) {
            for ( j = 0; j < i; j++) {
                if(numbers[i]+numbers[j]==target){
                    break http;
                }
            }
        }
        int [] ans = {j + 1, i + 1};
        return ans;
    }
}
