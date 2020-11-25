package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;

public class HappyNumber {
    public static void main(String[] args) {
        HappyNumber happyNumber = new HappyNumber();
        for (int i = 1; i < 1000; i++) {
            boolean happy = happyNumber.isHappy(i);
        }
        int[] digits = happyNumber.getDigits(Integer.MAX_VALUE);
//        System.out.println("Arrays.toString(di) = " + Arrays.toString(digits));
        happyNumber.printSum();
    }
    public void printMix(){
        int i = 1;


    }
    public void printSum(){
        for (int i = 1; i < 10; i++) {
            for (int j = 1; j < 10; j++) {
                System.out.print(i*i+j*j+" ");
            }
            System.out.println();
        }
    }
    public boolean isHappy(int n) {
        int pp = n;
        boolean isH = false;
        while (true) {
            int[] digits = getDigits(pp);
            pp = calDigitsSq(digits);
            if (pp == 1 || pp == 4) {
                isH = pp == 1;
                break;
            }
        }
        return isH;
    }

    int calDigitsSq(int[] dig) {
        int sum = 0;
        for (int value : dig) {
            sum += value * value;
        }
        return sum;
    }

    int[] getDigits(int n) {
        if (n < 10) {
            return new int[]{n};
        }
        ArrayList<Integer> digits = new ArrayList<>();
        do {
            digits.add(n % 10);
        } while ((n = n / 10) > 0);
        return digits.stream().mapToInt(Integer::intValue).toArray();
    }
}
