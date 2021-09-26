package leetcode.zozz.winter.jiangzhioffer;

import org.junit.Test;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;

/**
 * 用两个栈实现一个队列。队列的声明如下，请实现它的两个函数 appendTail 和 deleteHead ，分别完成在队列尾部插入整数和在队列头部删除整数的功能。(若队列中没有元素，deleteHead 操作返回 -1 )
 * <p>
 * 输入：
 * ["CQueue","appendTail","deleteHead","deleteHead"]
 * [[],[3],[],[]]
 * 输出：[null,null,3,-1]
 */
public class yong_liang_ge_zhan_shi_xian_dui_lie_lcof {
    @Test
    public void tt() {
        CQueue obj = new CQueue();
        obj.appendTail(1);
        int param_2 = obj.deleteHead();
    }

    class CQueue {

        Deque<Integer> main = new ArrayDeque<>();
        Deque<Integer> sub = new ArrayDeque<>();

        public CQueue() {
            // 取的时候, 放到另一个栈里面去
        }

        public void appendTail(int value) {
            sub.push(value);
        }

        public int deleteHead() {
            if (main.isEmpty()) {
                while (!sub.isEmpty()) {
                    main.push(sub.pop());
                }
                if (main.isEmpty()) return -1;
                return main.pop();
            }
            return main.pop();
        }
    }

/**
 * Your CQueue object will be instantiated and called as such:
 * CQueue obj = new CQueue();
 * obj.appendTail(value);
 * int param_2 = obj.deleteHead();
 */
}
