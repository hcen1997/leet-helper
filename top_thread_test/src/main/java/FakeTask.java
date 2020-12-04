public class FakeTask implements Runnable {
    public void run() {
        long sum = 0;
        // if integer.max_value and i++;i++ it will never end
        for (int i = 0; i < Integer.MAX_VALUE; i++) {
            for (int j = 0; j < 10; j++) {
                sum +=i+j;
            }
        }
        System.out.println(Thread.currentThread().getName()+" is ok.");
        System.out.println("sum is "+sum);
    }
}
