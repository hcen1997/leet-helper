import org.junit.Test;

public class SolutionTest {

    /**
     * @return 0
     *          非法输入
     * @return [INT_MIN, INT_MAX]
     *         正常输入范围
     */
    public int myAtoi(String s) {
        // 按字符处理
        // 字符处理循环 处理非空
        //
        return 0;
    }

    @Test
    public void initTest(){
        Integer i = new Integer(0);
        System.out.println(i);
    }

    @Test
    public void nanTest(){
        System.out.println(0/0);
    }

    public static void main(String[] args) {
        double d = 0.0;
        double c = 0.0;
        double a = 1.0;
        System.out.println(d/c);
        System.out.println(a/c);
        Character.isJavaIdentifierPart(0x005D);
//        Double.NaN;
//        Double.isInfinite();
//        Double.isFinite();
//        Double.isNaN();
        System.out.println(2.0-1.9);
        char dd= '\u1234';
    }
}