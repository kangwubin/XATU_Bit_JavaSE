package Stack;

/**
 * Description:泛型类型的栈
 *
 * @author: KangWuBin
 * @Date: 2019/11/13
 * @Time: 10:21
 */
class MyStack1<T> {
    public T[] elem;//整型元素
    public int top;//入栈指针---可以存放数组元素的下标

    public MyStack1() {
        this.elem = (T[]) new Object[10];
    }

    //判断栈是否是满了
    public boolean isFull() {
        if (this.top == this.elem.length) {
            return true;
        }
        return false;
    }

    //入栈
    public void push(T data) {
        if (isFull()) {
            return;
        }
        this.elem[top] = data;
        this.top++;
    }

    //出栈
    public T pop() {
        if (isEmpty()) {
            return null;//标志-1为栈空的时候返回的元素
        }
//        int num = this.elem[--this.top];
//        this.top--;
//        this.top = this.top - 1;
        T num = this.elem[this.top - 1];
        this.top--;
        return num;
    }

    //取栈顶元素，但是不删除
    public T peek() {
        if (isEmpty()) {
            return null;//
        }
        T num = this.elem[this.top - 1];
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

public class MyStackDemo1 {
    public static void main(String[] args) {
        MyStack1<Integer> myStack = new MyStack1<>();
        myStack.push(1);
        myStack.push(2);
        myStack.push(3);
        myStack.push(4);
    }
}
