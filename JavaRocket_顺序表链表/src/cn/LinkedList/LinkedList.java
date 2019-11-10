package cn.LinkedList;

class Node {
    public int data;
    public Node next;   //next:引用类型

    //空构造
    public Node() {
    }

    //
    public Node(int data) {
        this.data = data;
    }
}

public class LinkedList {
    //单链表的头，是一个引用类型
    public Node head;

    //打印单链表
    public void display() {
        Node cur = this.head;
        while (cur != null) {
            System.out.print(cur.data + " ");
            cur = cur.next;
        }
        System.out.println();
    }

    //获取链表长度
    public int getLength() {
//        int count = 0;
//        Node cur = this.head;
//        while (cur != null){
//            count++;
//            cur = cur.next;
//        }
//        return count;
        int size = 0;
        for (Node cur = this.head; cur != null; cur = cur.next) {
            size++;
        }
        return size;
    }

    //头插法
    public void addFirst(int data) {
        //创建节点，给data域赋值
        Node node = new Node(data);
        //如果单链表为空
        if (this.head == null) {
            this.head = node;
            return;
        }
        node.next = this.head;
        this.head = node;
        return;
    }

    //尾插法
    public void addLast(int data) {
        //创建节点
        Node node = new Node(data);
        //如果是空链表，直接把这个节点放上去
        if (this.head == null) {
            this.head = node;
            return;
        }
        //非空，需要先找到最后一个节点
        Node cur = this.head;
        //这个循环结束，cur就是最后一个节点
        while (cur.next != null) {
            cur = cur.next;
        }
        //循环结束，cur指向最后一个节点
        cur.next = node;
    }

    /**
     * 找到index-1位置的节点
     * 返回的是index-1位置的节点的引用
     *
     * @param index
     * @return
     */
    private Node searchIndex(int index) {
        int count = 0;
        Node cur = this.head;
        while (count < index - 1) {
            cur = cur.next;
            count++;
        }
        return cur;
    }

    //检查下标是否越界异常
    private void checkIndex(int index) {
        if (index < 0 || index > getLength()) {
            throw new IndexOutOfBoundsException("下标不合法！");
        }
    }

    //2.任意位置插入,第一个数据节点为0号下标
    public boolean addIndex(int index, int data) {
        int len = getLength();
        //校验合法性
        if (index < 0 || index > getLength()) {
            return false;
        }
        //处理头插
        if (index == 0) {
            addFirst(data);
            return true;
        }
        //1、找到index位置的前驱
        Node cur = searchIndex(index);
        //2、插入
        Node node = new Node(data);
        node.next = cur.next;
        cur.next = node;
        return true;
    }

    //清空单链表
    public void clear() {
        this.head = null;
        //不clear，会出现内存泄漏
    }

    //=============================================链表习题==============================
    //找前驱节点
    private Node searchPrev(int key) {
        //判断是否为空链表
        if (head == null) {
            return null;
        }
        //从头开始遍历单链表，找前驱节点
        Node prev = this.head;
        while (prev.next != null) {
            if (prev.next.data == key) {
                return prev;
            }
            prev = prev.next;
        }
        return null;
    }

    //删除第一次出现关键字为key的节点
    public void remove(int key) {
        //1、删除的节点是头节点
        if (this.head.data == key) {
            this.head = this.head.next;
            return;
        }
        //2、不是头节点
        Node prev = searchPrev(key);
        if (prev == null) {
            return;
        }
        Node del = prev.next;
        prev.next = del.next;
    }

    //1.删除所有值为key的节点---前驱节点与当前节点
    public void removeAllKey(int key) {
        Node prev = this.head;//cur的前驱
        Node cur = this.head.next;//要删除的节点
        while (cur != null) {
            if (cur.data == key) {
                prev.next = cur.next;
                cur = prev.next;  //cur = cur.next;
            } else {
                prev = cur;
                cur = cur.next;   //cur = prev.next;
            }
        }
        if (this.head.data == key) {
            this.head = this.head.next;
            return;
        }
    }

    //2.反转一个单链表=链表匿置(重点)---前驱节点、当前节点、下一个节点
    public Node reverseList() {
        Node prev = null;
        //当前要翻转的节点
        Node cur = this.head;
        Node newHead = null;
//        Node curNext = cur.next;
        while (cur != null) {
            //记录下一个要翻转的节点
            Node curNext = cur.next;
            if (curNext == null) {
                newHead = cur;
            }
            cur.next = prev;
            prev = cur;
            cur = curNext;
        }
        return newHead;
    }

    public void display2(Node newHead) {
        Node cur = newHead;
        while (cur != null) {
            System.out.print(cur.data + " ");
            cur = cur.next;
        }
        System.out.println();
    }

    //3.给定一个带有头结点head的非空单链表，返回链表的中间结点。如果有两个中间结点，则返回第二个中间结点。
    //方式一： //得到链表的长度；int steps = size(head) / 2;根据长度的一半移动cur
    public Node middleNode1() {
        return null;
    }

    //方式二：快慢指针---让快指针和慢指针都从head开始走，快指针走两步，慢指针走一步
    public Node middleNode() {
        Node fast = this.head;
        Node slow = this.head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;      //fast走两步
            slow = slow.next;           //slow走一步
        }
        return slow;
    }

    //4.输入一个链表，输出该链表中倒数第k个结点。
    /*(1)判断链表与K值是否合法.
    (2)求链表的长度(size)，用size-k就是从前往后数第几个，然后让指针从前往后走几步
     * */
    public Node FindKthToTail(int k) {
        if (this.head == null || k == 0) {
            return null;
        }
        Node fast = this.head;
        Node slow = this.head;
        while (k - 1 > 0) {
            if (fast.next != null) {
                fast = fast.next;
                k--;
            } else {
                System.out.println("没有此节点！");
                return null;
            }
        }
        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }
        return slow;
    }

    //5.将两个有序链表合并为一个新的有序链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。(重点)

    //6.编写代码，以给定值x为基准将链表分割成两部分，所有小于x的结点排在大于或等于x的结点之前给,
    // 定一个链表的头指针 ListNode* pHead，
    // 请返回重新排列后的链表的头指针。注意：分割以后保持原来的数据顺序不变。
    public Node partition(int x) {
        return null;
    }

    //7.在一个排序的链表中，存在重复的结点，请删除该链表中重复的结点，重复的结点不保留，返回链表头指针。
    // 例如，链表1->2->3->3->4->4->5 处理后为 1->2->5
    public Node deleteDuplication() {
        Node newHead = new Node(-1);
        Node newTail = newHead;
        Node cur = this.head;
        while (cur != null) {
            if (cur.next != null && cur.data == cur.next.data) {
                while (cur.next != null && cur.data == cur.next.data) {
                    cur = cur.next;
                }
                cur = cur.next;
                newTail.next = cur;
            } else {
                newTail.next = cur;
                newTail = newTail.next;
                cur = cur.next;
            }
        }
        return newHead.next;
    }

    //8.对于一个链表，请设计一个时间复杂度为O(n),额外空间复杂度为O(1)的算法，判断其是否为回文结构。
    //给定一个链表的头指针A，请返回一个bool值，代表其是否为回文结构。保证链表长度小于等于900。
    //测试样例：1->2->2->1;返回：true

    /**
     * 1、定义两个引用，目的：找到单链表的中间位置
     * 2、进行翻转，翻转的是后半部分
     * 3、一个head从头开始走，slow从尾巴开始走
     * 4、只要发现对应的data不相同，那么就不是回文
     *
     * @return
     */
    public boolean chkPalindrome() {
        if (this.head == null) {
            return false;
        }
        if (this.head.next == null) {
            return true;
        }
        Node fast = this.head;
        Node slow = this.head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        //2.翻转
        Node p = slow.next;
        while (p != null) {     //p可能为空
            Node pNext = p.next;
            p.next = slow;
            slow = p;
            p = pNext;
            if (p != null) {
                pNext = p.next;
            }
        }
        //3.进行判断
        while (this.head != slow) { //head != slow判断head与slow是否相遇
            //奇数个数情况
            //1-2-3-2-1
            if (this.head.data != slow.data) {
                return false;
            }
            //偶数---1-2-2-1
            if (this.head.next == slow) {
                return true;
            }
            this.head = this.head.next;
            slow = slow.next;
        }
        return true;
    }

    //9.输入两个链表，找出它们的第一个公共结点.
    public Node getIntersectionNode() {
        return null;
    }

    //10.给定一个链表，判断链表中是否有环（重点）。时间复杂度：O(N);空间复杂度：O(1)
    /*基本思路：快慢指针：快指针一次走两步，慢指针一次走一步
    1.如果链表不带环，快指针一定先到达末尾；如果链表带环，快指针一定会和慢指针重合。
    2.在使用快慢指针时：如果快慢指针的速度差值是1，可以重合，否则就不行。
    * */
    //创造一个环
    public void createCycle() {
        Node cur = this.head;
        while (cur.next != null) {
            cur = cur.next;
        }
        cur.next = this.head.next.next;
    }

    public boolean hasCycle() {
        if (this.head == null) {
            return false;
        }
        Node fast = this.head;
        Node slow = this.head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                return true;
            }
        }
        return false;
    }

    //11.给定一个链表，返回链表开始入环的第一个节点。 如果链表无环，则返回 null。
    public Node detectCycle() {
        if (this.head == null) {
            return null;
        }
        Node fast = this.head;
        Node slow = this.head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                break;
            }
        }
        if (fast == null || fast.next == null) {
            return null;
        }
        //相遇之后让fast或slow为head
        fast = this.head;
        while (fast != slow) {
            fast = fast.next;
            slow = slow.next;
        }
        return fast;
    }

}

