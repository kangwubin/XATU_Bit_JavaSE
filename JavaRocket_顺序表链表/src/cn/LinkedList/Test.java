package cn.LinkedList;

public class Test {
    //5.将两个有序链表合并为一个新的有序链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。(重点)
    public static Node mergeTwoLists(Node headA, Node headB) {
        Node newHead = new Node(-1);
        Node newTail = newHead;
        while (headA != null && headB != null) {
            if (headA.data < headB.data) {
                newTail.next = headA;
                headA = headA.next;
                newTail = newTail.next;
            } else {
                newTail.next = headB;
                headB = headB.next;
                newTail = newTail.next;
            }
        }
        //判断为空
        if (headA != null) {
            newTail.next = headA;
        }
        if (headB != null) {
            newTail.next = headB;
        }
        return newHead.next;
    }

    public static void main(String[] args) {
        LinkedList linkedList = new LinkedList();
        linkedList.addLast(1);
        linkedList.addLast(12);
        linkedList.addLast(33);

        LinkedList linkedList2 = new LinkedList();
        linkedList2.addLast(10);
        linkedList2.addLast(21);
        linkedList2.addLast(31);
        linkedList2.addLast(41);
        Node node = mergeTwoLists(linkedList.head, linkedList2.head);
        linkedList.display2(node);
    }

    //9.输入两个链表，找出它们的第一个公共结点.
    public static Node getIntersectionNode(Node headA, Node headB) {
        int lenA = 0;
        int lenB = 0;
        Node pL = headA;
        Node pS = headB;
        while (pL != null) {
            lenA++;
            pL = pL.next;
        }
        while (pS != null) {
            lenB++;
            pS = pS.next;
        }
        pL = headA;
        pS = headB;
        int len = lenA - lenB;
        if (len < 0) {
            pL = headB;
            pS = headA;
            len = lenB - lenA;
        }
        //pL指向最长的单链表；PS指向最短的单链表
        for (int i = 0; i < len; i++) {
            pL = pL.next;
        }
        //
        while (pL != null && pS != null && pL != pS) {
            pL = pL.next;
            pS = pS.next;
        }
        if (pL == null || pS == null) {
            return null;
        }
        return pL;
    }

    //创建相交
    public static void createCut(Node headA, Node headB) {
        headA.next = headB.next.next;
    }

    public static void main3(String[] args) {
        LinkedList linkedList = new LinkedList();
        linkedList.addLast(1);
        linkedList.addLast(2);
        linkedList.addLast(3);
        linkedList.addLast(4);

        LinkedList linkedList2 = new LinkedList();
        linkedList2.addLast(10);
        linkedList2.addLast(21);
        linkedList2.addLast(31);
        linkedList2.addLast(41);

        createCut(linkedList.head, linkedList2.head);
        Node node = getIntersectionNode(linkedList.head, linkedList2.head);
        System.out.println(node.data);
    }

    public static void main2(String[] args) {
        LinkedList linkedList = new LinkedList();
        linkedList.addLast(1);
        linkedList.addLast(2);
        linkedList.addLast(3);
        linkedList.addLast(4);
        linkedList.addLast(5);
        linkedList.createCycle();
        System.out.println(linkedList.hasCycle());
//        linkedList.display();
//        Node node = linkedList.middleNode();
//        System.out.println(node.data);
//        Node node = linkedList.reverseList();
//        linkedList.display2(node);
    }

    public static void main1(String[] args) {
        LinkedList linkedList = new LinkedList();
        linkedList.addFirst(1);
        linkedList.addFirst(2);
        linkedList.addFirst(3);
        linkedList.addFirst(4);
        linkedList.addIndex(0, 99);
        linkedList.display();
        System.out.println("====================");
        LinkedList linkedList1 = new LinkedList();
        linkedList1.addLast(1);
        linkedList1.addLast(2);
        linkedList1.addLast(3);
        linkedList1.addLast(4);
        linkedList1.display();
        System.out.println("====================");
    }
}
