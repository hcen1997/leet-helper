package randcode;

import org.junit.Test;

public class LeetcodeHat {
    @Test
    public void tt() {
        int coinOneMouth = 30 * 1 + 30 + 30 * 20;
        System.out.println(coinOneMouth);
        int mounth = 5400 / coinOneMouth;
        System.out.println(mounth);
    }
    @Test
    public void t1(){
        System.out.println(Math.log10(10000)); // 4.0
        System.out.println(Math.log(20000)); // 9.9
    }

    private double rate (int a,int b){
        double h = (b-a)/400.0;
        return 1/(1+Math.exp(h* Math.log(10)));
    }
    @Test
    public void pob(){
        for (int i = 1000; i <=2300; i+=100) {
            for (int j = 0; j <=2300; j+=100) {
                System.out.printf("%d %d %.3f\n",i,j,rate(i,j));
            }
        }
    }
}
