package Queue;

/**
 * Description:
 *
 * @author: KangWuBin
 * @Date: 2019/11/13
 * @Time: 11:52
 */

public class MyQueueCycle {
    public int[] elem;
    public int front;//队头
    public int rear;//队尾

    public MyQueueCycle() {
        this.elem = new int[10];
        this.front = 0;
        this.rear = 0;
    }

    //判断满
    public boolean isFull() {
        if ((this.rear + 1) % this.elem.length == this.front) {
            return true;
        }
        return false;
    }

    //入队
    public boolean enQueue(int value) {
        if (isFull()) {
            return false;
        }
        this.elem[this.rear] = value;
        this.rear = (this.rear + 1) % this.elem.length;
        return true;
    }

    public boolean isEmpty() {
        if (this.front == this.rear) {
            return true;
        }
        return false;
    }

    //出队
    public boolean deQueue() {
        if (isEmpty()) {
            return false;
        }
        this.front = (this.front + 1) % this.elem.length;
        return true;
    }

    //得到队头元素
    public int Front() {
        if (isEmpty()) {
            return -1;
        }
        return this.elem[front];
    }

    //得到队尾元素
    public int Rear() {
        if (isEmpty()) {
            return -1;
        }
        int index = 0;
        if (this.rear == 0) {
            index = this.elem.length - 1;
        } else {
            index = this.rear - 1;
        }
        return this.elem[index];
    }
}
