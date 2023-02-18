package randcode.money;

import org.junit.Test;

public class OptTest {
    @Test
    public void t1(){
        System.out.println("这个测试用来模拟10个用户的随机交易");

        // 把交易表写在人里面了
        RandOptMan[] market = new RandOptMan[10];
        for (int i = 0; i < 10; i++) {
            market[i] = new RandOptMan(market,i,100);
        }

        System.out.println("5000次模拟开始");
        for (int i = 0; i < 5000; i++) {
            for (RandOptMan man :market){
                man.randTrade();
            }
            printMarketInfo(market);
        }

        System.out.println("5000次模拟结束");


    }

    StringBuilder stmp = new StringBuilder();
    private void printMarketInfo(RandOptMan[] market) {
        // [m1,m2,...]
        stmp.delete(0,stmp.length());
        stmp.append("[");
        for (RandOptMan randOptMan : market) {
           stmp.append(randOptMan.getMoney());
           stmp.append(", ");
        }
        if(market.length>0){
            stmp.deleteCharAt(stmp.length()-1);
        }
        stmp.append("]");
        System.out.println(stmp.toString());
    }
}
