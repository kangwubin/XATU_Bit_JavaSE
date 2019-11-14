package LeetCodeNowCoder;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Description:使用队列实现栈的下列操作：
 * push(x) -- 元素 x 入栈
 * pop() -- 移除栈顶元素
 * top() -- 获取栈顶元素
 * empty() -- 返回栈是否为空
 *
 * @author: KangWuBin
 * @Date: 2019/11/13
 * @Time: 22:55
 */
public class MyStack {
    private Queue<Integer> queue1 = new LinkedList<>();
    private Queue<Integer> queue2 = new LinkedList<>();

    // Push element x onto stack.
    //如果是第一次入栈，指定入到queue1，如果不是第一次，每次入到不为空的队列里面。
    public void push(int x) {
        if (!queue1.isEmpty()) {
            queue1.offer(x);
        } else if (!queue2.isEmpty()) {
            queue2.offer(x);
        } else {
            queue1.offer(x);
        }
    }

    /**
     * Removes the element on top of the stack and returns that element.
     */
    //把不为空的队列里面的元素倒入空的队列，最后一个元素不倒入；
    //如果两个队列都为空的时候，不能出栈了。
    public int pop() {
        if (empty()) {
            return -1;
        }
        int oldData = 0;
        if (!queue1.isEmpty()) {
            //为了保障size不变
            int size = queue1.size();
            for (int i = 0; i < size - 1; i++) { //size - 1--出的元素为size-1
                /*int a = queue1.poll();
                queue2.offer(a);*/
                queue2.offer(queue1.poll());
            }
            oldData = queue1.poll();
        } else if (!queue2.isEmpty()) {
            int size = queue2.size();
            for (int i = 0; i < size - 1; i++) {
                queue1.offer(queue2.poll());
            }
            oldData = queue2.poll();
        }
        return oldData;
    }

    /**
     * Get the top element.
     */
    public int top() {
        if (empty()) {
            return -1;
        }
        int oldData = 0;
        if (!queue1.isEmpty()) {
            int size = queue1.size();
            for (int i = 0; i < size; i++) {
                //保存每次出栈的元素
                oldData = queue1.poll();
                queue2.offer(oldData);
            }
        } else if (!queue2.isEmpty()) {
            int size = queue2.size();
            for (int i = 0; i < size; i++) {
                oldData = queue2.poll();
                queue1.offer(oldData);
            }
        }
        return oldData;
    }

    /**
     * Returns whether the stack is empty.
     */
    public boolean empty() {
        if (queue1.isEmpty() && queue2.isEmpty()) {
            return true;
        }
        return false;
    }
}

