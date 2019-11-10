package cn.LinkedListPractice;

public class Solution {
    //1.删除链表中等于给定值 **val** 的所有节点。
    public ListNode removeElements(ListNode head, int val) {
        if (head == null) {
            return null;
        }
        if (head.val == val) {
            head = head.next;
        }
        ListNode prev = head;
        ListNode cur = head.next;
        while (cur != null) {
            if (cur.val == val) {
                prev.next = cur.next;
                cur = prev.next;
            } else {
                prev = cur;
                cur = cur.next;
            }
        }
        return head;
    }

    //2.反转一个单链表=链表匿置(重点)
    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        //当前要翻转的节点
        ListNode cur = head;
        ListNode newHead = null;
        while (cur != null) {
            //记录下一个要翻转的节点
            ListNode curNext = cur.next;
            if (curNext == null) {
                newHead = cur;
            }
            cur.next = prev;
            prev = cur;
            cur = curNext;
        }
        return newHead;
    }

    //3.给定一个带有头结点head的非空单链表，返回链表的中间结点。如果有两个中间结点，则返回第二个中间结点。
    public ListNode middleNode1(ListNode head) {
        int length = size(head);
        int offset = length / 2;
        ListNode cur = head;
        for (int i = 0; i < offset; i++) {
            cur = cur.next;
        }
        return cur;
    }

    public ListNode middleNode(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }

    //计算链表的长度
    public int size(ListNode head) {
        int size = 0;
        for (ListNode cur = head; cur != null; cur = cur.next) {
            size++;
        }
        return size;
    }

    //4.输入一个链表，输出该链表中倒数第k个结点。
    public ListNode FindKthToTail(ListNode head, int k) {
        int length = size(head);
        if (head == null || k < 0 || k > length) {
            return null;
        }
        int offset = length - k;
        ListNode cur = head;
        for (int i = 0; i < offset; i++) {
            cur = cur.next;
        }
        return cur;
    }

    //5.将两个有序链表合并为一个新的有序链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。(重点)
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode newHead = new ListNode(-1);
        ListNode newTail = newHead;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                newTail.next = l1;
                l1 = l1.next;
                newTail = newTail.next;
            } else {
                newTail.next = l2;
                l2 = l2.next;
                newTail = newTail.next;
            }
        }
        if (l1 != null) {
            newTail.next = l1;
        }
        if (l2 != null) {
            newTail.next = l2;
        }
        return newHead.next;
    }

    //6.编写代码，以给定值x为基准将链表分割成两部分，所有小于x的结点排在大于或等于x的结点之前给定一个链表的头指针 ListNode* pHead，
    // 请返回重新排列后的链表的头指针。注意：分割以后保持原来的数据顺序不变。
    public ListNode partition(ListNode pHead, int x) {
        if (pHead == null) {
            return null;
        }
        if (pHead.next == null) {
            return pHead;
        }
        ListNode smallHead = new ListNode(-1);
        ListNode smallTail = smallHead;
        ListNode bigHead = new ListNode(-1);
        ListNode bigTail = bigHead;
        for (ListNode cur = pHead; cur != null; cur = cur.next) {
            if (cur.val < x) {
                smallTail.next = new ListNode(cur.val);
                smallTail = smallTail.next;
            } else {
                bigTail.next = new ListNode(cur.val);
                bigTail = bigTail.next;
            }
        }
        smallTail.next = bigHead.next;
        return smallHead.next;
    }

    //7.在一个排序的链表中，存在重复的结点，请删除该链表中重复的结点，重复的结点不保留，返回链表头指针。
    // 例如，链表1->2->3->3->4->4->5 处理后为 1->2->5
    //例如：链表1->1->2->3->3->4->4->5处理后为 2->5
    public ListNode deleteDuplication(ListNode pHead) {
        if (pHead == null) {
            return null;
        }
        //创建虚拟节点
        ListNode newHead = new ListNode(-1);
        ListNode newTail = newHead;
        ListNode cur = pHead;
        while (cur != null) {
            //1-2-2-3-5
            //1-2-2-3-3
            //1-2-2-3-5-5
            //cur.next != null---只有一个节点
            if (cur.next != null && cur.val == cur.next.val) {
                while (cur.next != null && cur.val == cur.next.val) {
                    cur = cur.next;
                }
                cur = cur.next;
                newTail.next = cur;
            } else {
                newTail.next = new ListNode(cur.val);
                newTail = newTail.next;
                cur = cur.next;
            }
        }
        return newHead.next;
    }

    //8.对于一个链表，请设计一个时间复杂度为O(n),额外空间复杂度为O(1)的算法，判断其是否为回文结构。
    //给定一个链表的头指针A，请返回一个bool值，代表其是否为回文结构。保证链表长度小于等于900。
    //测试样例：1->2->2->1;返回：true
    //测试样例：1->2->3->2->1
    public boolean chkPalindrome(ListNode A) {
        if (A == null) {
            return false;
        }
        if (A.next == null) {
            return true;
        }
        ListNode fast = A;
        ListNode slow = A;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        //测试样例：1->2->2->1;返回：true
        //测试样例：1->2->3->2->1---逆置思想
        ListNode p = slow.next;
        while (p != null) {
            ListNode pNext = p.next;
            p.next = slow;
            slow = p;
            p = pNext;
            if (p != null) {
                pNext = p.next;
            }
        }
        //3.进行判断
        while (A != slow) {
            //奇数个数情况
            if (A.val != slow.val) {
                return false;
            }
            //偶数
            if (A.next == slow) {
                return true;
            }
            A = A.next;
            slow = slow.next;
        }
        return true;
    }

    //9.输入两个链表，找出它们的第一个公共结点.
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int lenA = size(headA);
        int lenB = size(headB);
        if (lenA > lenB) {
            int offset = lenA - lenB;
            for (int i = 0; i < offset; i++) {
                headA = headA.next;
            }
        } else {
            int offset = lenB - lenA;
            for (int i = 0; i < offset; i++) {
                headB = headB.next;
            }
        }
        while (headA != null && headB != null) {
            if (headA == headB) {
                return headA;
            }
            headA = headA.next;
            headB = headB.next;
        }
        return null;
    }

    //10.给定一个链表，判断链表中是否有环（重点）。时间复杂度：O(N);空间复杂度：O(1)
    /*基本思路：快慢指针：快指针一次走两步，慢指针一次走一步
    1.如果链表不带环，快指针一定先到达末尾；如果链表带环，快指针一定会和慢指针重合。
    2.在使用快慢指针时：如果快慢指针的速度差值是1，可以重合，否则就不行。
    * */
    public boolean hasCycle(ListNode head) {
        if (head == null) {
            return false;
        }
        ListNode fast = head;
        ListNode slow = head;
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
    // 核心：从链表头部出发, 到入口点的距离,和从快慢指针的交汇处出发, 到入口点的距离相等.
    public ListNode detectCycle(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode fast = head;
        ListNode slow = head;
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
        while (head != slow) {
            head = head.next;
            slow = slow.next;
        }
        return slow;
    }

}
