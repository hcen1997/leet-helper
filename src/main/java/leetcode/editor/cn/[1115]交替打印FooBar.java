package leetcode.editor.cn;
//我们提供一个类：
//
// 
//class FooBar {
//  public void foo() {
//    for (int i = 0; i < n; i++) {
//      print("foo");
//    }
//  }
//
//  public void bar() {
//    for (int i = 0; i < n; i++) {
//      print("bar");
//    }
//  }
//}
// 
//
// 两个不同的线程将会共用一个 FooBar 实例。其中一个线程将会调用 foo() 方法，另一个线程将会调用 bar() 方法。 
//
// 请设计修改程序，以确保 "foobar" 被输出 n 次。 
//
// 
//
// 示例 1: 
//
// 
//输入: n = 1
//输出: "foobar"
//解释: 这里有两个线程被异步启动。其中一个调用 foo() 方法, 另一个调用 bar() 方法，"foobar" 将被输出一次。
// 
//
// 示例 2: 
//
// 
//输入: n = 2
//输出: "foobarfoobar"
//解释: "foobar" 将被输出两次。
// 
// 👍 79 👎 0


import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicBoolean;

//leetcode submit region begin(Prohibit modification and deletion)
class FooBar {
    private Semaphore lock_FooBar;
    private Semaphore lock_BarFoo;
    private int n;

    public FooBar(int n) {
        this.n = n;
        lock_FooBar = new Semaphore(0);
        lock_BarFoo = new Semaphore(1);
    }

    public void foo(Runnable printFoo) throws InterruptedException {

        for (int i = 0; i < n; i++) {
            lock_BarFoo.acquire();
            printFoo.run();
            lock_FooBar.release();
        }
    }

    public void bar(Runnable printBar) throws InterruptedException {

        for (int i = 0; i < n; i++) {
            lock_FooBar.acquire();
            printBar.run();
            lock_BarFoo.release();
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
