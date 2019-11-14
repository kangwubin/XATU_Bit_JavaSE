package LeetCodeNowCoder;

import java.util.Stack;

/**
 * Description:使用栈实现队列的下列操作：
 * push(x) -- 将一个元素放入队列的尾部。
 * pop() -- 从队列首部移除元素。
 * peek() -- 返回队列首部的元素。
 * empty() -- 返回队列是否为空。
 *
 * @author: KangWuBin
 * @Date: 2019/11/13
 * @Time: 22:55
 */
public class MyQueue {
    public Stack<Integer> stack;
    public Stack<Integer> stackTmp;

    /**
     * Initialize your data structure here.
     */
    public MyQueue() {
        stack = new Stack<>();
        stackTmp = new Stack<>();
    }

    /**
     * Push element x to the back of queue.
     */
    public void push(int x) {
        stack.push(x);
    }

    /**
     * Removes the element from in front of queue and returns that element.
     */
    public int pop() {
        if (stackTmp.empty()) {
            //将stack 栈当中的所有元素全部倒入 stackTmp;
            while (!stack.empty()) {
                stackTmp.push(stack.pop());
            }
        }
        if (!stackTmp.empty()) {
            //将stackTmp 的栈顶元素弹出-》出栈stackTmp.pop
            return stackTmp.pop();
        }
        return -1;
    }

    /**
     * Get the front element.
     */
    public int peek() {
        if (stackTmp.empty()) {
            //将stack 栈当中的所有元素全部倒入 stackTmp;
            while (!stack.empty()) {
                stackTmp.push(stack.pop());
            }
        }
        if (!stackTmp.empty()) {
            //将stackTmp 的栈顶元素弹出-》出栈stackTmp.pop
            return stackTmp.peek();
        }
        return -1;
    }

    /**
     * Returns whether the queue is empty.
     */
    public boolean empty() {
        if (stack.empty() && stackTmp.empty()) {
            return true;
        }
        return false;
    }
}
