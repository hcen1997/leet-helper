package leetcode.easy.two;

public class PowerOfFour {
    public static void main(String[] args) {
        PowerOfFour powerOfFour = new PowerOfFour();
        powerOfFour.printP();
        int[] iiaa = powerOfFour.iiaa();
        for (int i : iiaa) {
            boolean powerOfFour1 = powerOfFour.isPowerOfFour(i);
            System.out.println("powerOfFour1 = " + powerOfFour1);
        }
    }

    void printP() {
        int sum = 1;
        while (sum > 0) {
            System.out.println(Integer.toBinaryString(sum).length() + ",");
            System.out.println(Integer.lowestOneBit(sum)+ ",");
            // 1 3 5 ... 31
            sum = sum * 4;
        }
    }

    // 使用硬件电路实现是最快的
    // 数字拿进来 1分10 然后与门 只要两个时钟周期
    public boolean isPowerOfFour(int n) {
        if(n<=0 || Integer.bitCount(n) !=1) {
            return false;
        }
        int[] iiaa = iiaa();
        for (int i : iiaa) {
            if(n ==i){
                return true;
            }
        }
        return false;
    }

    private int[] iiaa() {
        return new int[]{
                1,
                4,
                16,
                64,
                256,
                1024,
                4096,
                16384,
                65536,
                262144,
                1048576,
                4194304,
                16777216,
                67108864,
                268435456,
                1073741824,
        };
    }
}
