package Stack;

/**
 * Description:用数组实现栈
 *
 * @author: KangWuBin
 * @Date: 2019/11/13
 * @Time: 10:21
 */
class MyStack {
    public int[] elem;//整型元素
    public int top;//入栈指针---可以存放数组元素的下标

    public MyStack() {
        this.elem = new int[10];
    }

    //判断栈是否是满了
    public boolean isFull() {
        if (this.top == this.elem.length) {
            return true;
        }
        return false;
    }

    //入栈
    public void push(int data) {
        if (isFull()) {
            return;
        }
        this.elem[top] = data;
        this.top++;
    }

    //出栈
    public int pop() {
        if (isEmpty()) {
            return -1;//标志-1为栈空的时候返回的元素
        }
//        int num = this.elem[--this.top];
//        this.top--;
//        this.top = this.top - 1;
        int num = this.elem[this.top - 1];
        this.top--;
        return num;
    }

    //取栈顶元素，但是不删除
    public int peek() {
        if (isEmpty()) {
            return -1;//
        }
        int num = this.elem[this.top - 1];
        return num;
    }

    public int size() {
        return this.top;
    }

    public boolean isEmpty() {
        if (this.top == 0) {
            return true;
        }
        return false;
    }
}

public class MyStackDemo {
    public static void main(String[] args) {
        MyStack myStack = new MyStack();
        myStack.push(1);
        myStack.push(2);
        myStack.push(3);
        myStack.push(4);
    }
}
