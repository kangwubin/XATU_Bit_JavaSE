package Queue;

/**
 * Description:用单链表实现队列
 *
 * @author: KangWuBin
 * @Date: 2019/11/13
 * @Time: 11:01
 */
class Node {
    public int data;
    public Node next;

    public Node(int data) {
        this.data = data;
    }
}

class MyQueue {
    public Node head;
    public Node tail;
    public int usedSize;

    //入队
    public void offer(int data) {
        //第一次入队
        Node node = new Node(data);
        if (this.head == null) {
            this.head = node;
            this.tail = node;
        } else {
            this.tail.next = node;
            this.tail = this.tail.next;
        }
        this.usedSize++;
    }

    //出队
    public int poll() {
        if (this.head == null) {
            return -1;
        }
        int oldData = this.head.data;
        this.head = this.head.next;
        this.usedSize--;
        return oldData;
    }

    //得到对头元素，不删除
    public int peek() {
        if (this.head == null) {
            return -1;
        }
        int oldData = this.head.data;
        return oldData;
    }

    public boolean isEmpty() {
        return usedSize == 0;
    }

    public int size() {
        return this.usedSize;
    }
}

public class MyQueueDemo {
    public static void main(String[] args) {
        MyQueue myQueue = new MyQueue();
    }
}
