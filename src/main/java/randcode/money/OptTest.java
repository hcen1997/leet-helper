package randcode.money;

import org.junit.Test;

/**
 * 随机模拟用户交易程序
 * todo: 还有两个程序需要重写, 1. 概率查看软件  2. 修仙世界
 */
public class OptTest {
    @Test
    public void t1() {
        System.out.println("这个测试用来模拟10个用户的随机交易");

        // 把交易表写在人里面了
        RandOptMan[] market = new RandOptMan[10];
        for (int i = 0; i < 10; i++) {
            market[i] = new RandOptMan(market, i, 100,false);
        }

        System.out.println("5000次模拟开始");
        for (int i = 0; i < 5000; i++) {
            for (RandOptMan man : market) {
                man.randTrade();
            }
            if (i % 50 == 0) {
                printMarketInfo(market);
            }
        }

        System.out.println("5000次模拟结束");


    }

    StringBuilder stmp = new StringBuilder();

    private void printMarketInfo(RandOptMan[] market) {
        // [m1,m2,...]
        stmp.delete(0, stmp.length());
        stmp.append("[");
        int crc = 0;
        for (RandOptMan randOptMan : market) {
            crc +=randOptMan.getMoney();
            stmp.append(randOptMan.getMoney());
            stmp.append(", ");
        }
        if (market.length > 0) {
            stmp.deleteCharAt(stmp.length() - 1);
        }
        stmp.append("]");
        stmp.append(" crc=");
        stmp.append(crc);
        System.out.println(stmp.toString());
    }
}
