package leetcode.editor.cn;

import java.util.Stack;

class MyQueue {
    Stack<Integer> stack;
    Stack<Integer> queue;
    boolean isStack;

    /**
     * Initialize your data structure here.
     */
    public MyQueue() {
        queue = new Stack<>();
        stack = new Stack<>();
        isStack = true;
    }

    /**
     * Push element x to the back of queue.
     */
    public void push(int x) {
        if (isStack) {
            stack.push(x);
        } else {
            isStack = !isStack;
            revertStack(queue, stack);
            queue.push(x);
        }
    }

    /**
     * Removes the element from in front of queue and returns that element.
     */
    public int pop() {
        if (isStack) {
            isStack = !isStack;
            revertStack(stack, queue);
            return queue.pop();
        } else {
            return queue.pop();
        }
    }

    /**
     * Get the front element.
     */
    public int peek() {
        if (isStack) {
            isStack = !isStack;
            revertStack(stack, queue);
            return queue.peek();
        } else {
            return queue.peek();
        }
    }

    private void revertStack(Stack<Integer> a, Stack<Integer> b) {
        int size = a.size();
        for (int i = 0; i < size; i++) {
            System.out.println("a.peek() = " + a.peek()  + " i"+i);
            b.push(a.pop());
        }
    }

    /**
     * Returns whether the queue is empty.
     */
    public boolean empty() {
        if (isStack) {
            return stack.size() == 0;
        } else {
            return queue.size() == 0;
        }
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */