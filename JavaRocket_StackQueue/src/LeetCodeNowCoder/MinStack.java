package LeetCodeNowCoder;

import java.util.Stack;

/**
 * Description:
 *
 * @author: KangWuBin
 * @Date: 2019/11/13
 * @Time: 22:55
 */
public class MinStack {
    // stack 用来表示正常的栈中的数据.
    // minStack 用来存储每一层 A 栈帧中对应的最小值
    private Stack<Integer> stack = new Stack<>();
    private Stack<Integer> minStack = new Stack<>();

    public void push(int x) {
        //1、stack栈内一定会入栈
        stack.push(x);
        //2、第一次minStack一定会放元素，其余的每次
        if (minStack.isEmpty()) {
            minStack.push(x);
            return;
        }
        //往stack栈-》和minStack栈顶比较
        // x <= minStack.peek()--->minStack.push(x);
        int min = minStack.peek();
        if (x < min) {
            min = x;
        }
        minStack.push(min);
    }

    public void pop() {
        if (stack.isEmpty()) {
            return;
        }
        int num = stack.pop();
        if (num == minStack.peek()) {
            minStack.pop();
        }
    }

    public int top() {
        if (stack.isEmpty()) {
            return -1;
        }
        return stack.peek();
    }

    public int getMin() {
        if (minStack.isEmpty()) {
            return -1;
        }
        return minStack.peek();
    }
}
