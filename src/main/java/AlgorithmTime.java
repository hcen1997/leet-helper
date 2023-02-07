import java.math.BigInteger;

public class AlgorithmTime {

    public static void main(String[] args) {
        System.out.println("这个代码作为我leetcode的下一站, 下一站的开始");
        System.out.println("代码中的基础时间计算");
        System.out.println("算法中的基础速度有Oln_n,On,OnLn_,On*n,ON!");

        System.out.println("如果基础计算是每秒一百万次, 让我们看看不同数量级的数据的" +
                "完成一件事情的操作需要消耗多长时间");
        System.out.println("这些当然重要, 因为如果是在要求性能的场合" +
                "(比如大型互联网软件, 每次用户操作都要做到一些事情), 那么每次都会操作代码和数据, 如果用户等太久," +
                "就非常影响体验.");

        float oprate_time = 0.000001f;
        Long answer = 1000L;
        System.out.println("Oln_n 的一千次操作是" + oprate_time * Math.log(answer));
        System.out.println("On算法的操作时间是" + oprate_time * answer);
        System.out.println("Onln算法的操作时间是" + oprate_time * answer * Math.log(answer));
        System.out.println("On2算法的操作时间是" + oprate_time * answer * answer);
        System.out.println("On!算法的操作时间是" + nto1(BigInteger.valueOf(answer)));
        System.out.println(100L * 99L * 98L * 97L * 96L * 95L);

        System.out.println("可以看出, Oln的基本上不需要时间, onln的算法都是可以接受的");
        System.out.println("但是nn的算法是不可接受的, 当数据量增大的时候, 使用哪怕最基本的数据结构和算法, 也要应用算法");
    }

    private static BigInteger nto1(BigInteger n) {
        return n.equals(BigInteger.ZERO) ? BigInteger.ONE : n.multiply(n.subtract(BigInteger.ONE));
    }
}
