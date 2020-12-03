package leetcode.rand;

public class ThirdMaxNumber {
    public int thirdMax(int[] nums) {
        Three three = new Three();
        for (int i = 0; i < nums.length; i++) {
            update(nums[i], three);
        }

        if (three.three == null) {
            return three.fir;
        } else {
            return three.three;
        }
    }

    private void update(int num, Three three) {
        if (three.fir == null) {
            three.fir = num;
            return;
        } else if (num >= three.fir) {
            if (num > three.fir) {
                int tmp = three.fir;
                three.fir = num;
                update(tmp,three);
            }
            return;
        }
        if (three.sec == null) {
            three.sec = num;
            return;
        } else if (num >= three.sec) {
            if (num > three.sec) {
                int tmp = three.sec;
                three.sec = num;
                update(tmp,three);
            }
            return;
        }
        if (three.three == null) {
            three.three = num;
            return;
        } else if (num >= three.three) {
            three.three = num;
            return;
        }
    }

    class Three {
        Integer fir = null;
        Integer sec = null;
        Integer three = null;
    }
}
