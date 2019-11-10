package cn.DLinkedList;

class Node {
    public int data;
    public Node next;
    public Node prev;

    public Node(int data) {
        this.data = data;
    }
}

class DoubleList {

    public Node head;//头
    public Node last;//尾巴

    public DoubleList() {
        this.head = null;
        this.last = null;
    }

    //头插法
    public void addFirst(int data) {
        Node node = new Node(data);
        //1、判断是否是第一次插入
        if (this.head == null) {
            this.head = node;
            this.last = node;
        } else {
            node.next = head;
//            node.next.prev = node;
            this.head.prev = node;
            this.head = node;
        }
    }

    //尾插法
    public void addLast(int data) {
        Node node = new Node(data);
        if (this.head == null) {
            this.head = node;
            this.last = node;
        } else {
            this.last.next = node;
            node.prev = this.last;
            this.last = node;
        }
    }

    private Node searchIndex(int index) {
        int count = 0;
        Node cur = this.head;
        while (count < index) {
            cur = cur.next;
            count++;
        }
        return cur;
    }

    private void checkIndex(int index) {
        if (index < 0 || index > size()) {
            throw new IndexOutOfBoundsException("index不合法");
        }
    }

    //任意位置插入,第一个数据节点为0号下标
    public boolean addIndex(int index, int data) {
        checkIndex(index);
        if (index == 0) {
            addFirst(data);
            return true;
        }
        if (index == size()) {
            addLast(data);
            return true;
        }
        Node node = new Node(data);
        Node cur = searchIndex(index);
        node.next = cur;
        node.prev = cur.prev;
        cur.prev = node;
        node.prev.next = node;
        return true;
    }

    //查找是否包含关键字key是否在双向链表当中
    public boolean contains(int key) {
        Node cur = this.head;
        while (cur != null) {
            if (cur.data == key) {
                return true;
            }
            cur = cur.next;
        }
        return false;
    }

    //删除第一次出现关键字为key的节点
    public int remove(int key) {
        Node cur = this.head;
        int oldData = -1;
        while (cur != null) {
            if (cur.data == key) {
                oldData = cur.data;
                //删除的节点是头节点
                if (cur == this.head) {
                    this.head = cur.next;
                    this.head.prev = null;
                } else {
                    //不是头节点
                    if (cur.next != null) {
                        cur.next.prev = cur.prev;
                    } else {
                        this.last = cur.prev;
                    }
                    cur.prev.next = cur.next;
                }
                return oldData;
            }
            cur = cur.next;
        }
        return oldData;
    }

    //删除所有值为key的节点
    public void removeAllKey(int key) {
        Node cur = this.head;
        while (cur != null) {
            if (cur.data == key) {
                //删除的节点是头节点
                if (cur == this.head) {
                    this.head = cur.next;
                    this.head.prev = null;
                } else {
                    //不是头节点
                    if (cur.next != null) {
                        cur.next.prev = cur.prev;
                    } else {
                        this.last = cur.prev;
                    }
                    cur.prev.next = cur.next;
                }
            }
            cur = cur.next;
        }
    }

    //得到单链表的长度
    public int size() {
        Node cur = this.head;
        int count = 0;
        while (cur != null) {
            count++;
            cur = cur.next;
        }
        return count;
    }

    public void display() {
        Node cur = this.head;
        while (cur != null) {
            System.out.print(cur.data + " ");
            cur = cur.next;
        }
        System.out.println();
    }

    public void clear() {
//        this.head = null;     //这么写会发生内存泄漏
        Node cur = head;
        while (cur != null) {
            Node curNext = cur.next;
            cur.prev = null;
            cur.next = null;
            cur = cur.next;
        }
        this.head = null;
        this.last = null;
    }
}