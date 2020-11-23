import sun.net.www.http.HttpClient;

public class StaticTest {
    static StaticTest s=new StaticTest();
    static {
        System.out.println("in static");
    }
    private  StaticTest ss =new StaticTest();
    StaticTest() {
        System.out.println("im coming");
    }

    public static void main(String[] args) {
        System.out.println("in main ");
        for (int i = 0; i < Integer.MAX_VALUE; i++) {
//            new StaticTest();
//            HttpClient
        }
    }
}
