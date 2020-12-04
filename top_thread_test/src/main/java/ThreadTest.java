
import java.util.concurrent.*;

/**
 * this project has 1 class
 * this demonstrate how java creat thread
 */
public class ThreadTest {
    final ExecutorService threadPool ;

    ThreadTest(){
        // Executors will quit when finish, but ThreadPoolExecutor will not by
        // default
        threadPool = Executors.newCachedThreadPool();
    }

    public void run(){
        for (int i = 0; i < 10; i++) {
            threadPool.execute(new FakeTask());
        }
    }
    public static void main(String[] args) {
        ThreadTest threadTest = new ThreadTest();
        threadTest.run();
    }
}
