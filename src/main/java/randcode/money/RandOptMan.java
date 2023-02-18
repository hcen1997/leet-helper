package randcode.money;

import org.junit.Test;

import java.util.Date;
import java.util.Random;

public class RandOptMan {
    private static Random randG = new Random(new Date().getTime());

    private final RandOptMan[] market;
    private final int n;
    private final int me;
    private int money = 0; // 串行程序不需要多线程对象


    /**
     * 本类由外部批量初始化, 并且交易依靠外部的数组来获取位置和交易
     */
    public RandOptMan(RandOptMan[] market, int i, int money) {
        this.market = market;
        this.n = market.length;
        this.me = i;
        this.money = money;
    }

    public void randTrade() {
        int target;
        while ((target = randG.nextInt(n)) == me) ;
        this.money -= 1;
        market[target].money += 1;  // 内部使用不需要get
    }

    public int getMoney() {
        return money;
    }
}
