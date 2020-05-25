package NowCoder_单链表;

import java.util.Scanner;

/**
 * Description:
 *
 * @author: KangWuBin
 * @Date: 2019/11/11
 * @Time: 15:45
 */
public class Main_mergeTwoLists {
    public static class ListNode {
        int val;
        ListNode next = null;

        public ListNode(int val) {
            this.val = val;
        }
    }

    /*请编写一段代码，实现两个单向有序链表的合并
     *输入：第一行一个链表，如1 2 3 4 5；第二行一个链表，如2 3 4 5 6；
     *输出：1 2 2 3 3 4 4 5 5 6*/
    public static void mergeTwoLists(ListNode headA, ListNode headB) {
        ListNode newHead = new ListNode(-1);
        ListNode newTail = newHead;
        while (headA != null && headB != null) {
            if (headA.val < headB.val) {
                newTail.next = headA;
                headA = headA.next;
                newTail = newTail.next;
            } else {
                newTail.next = headB;
                headB = headB.next;
                newTail = newTail.next;
            }
        }
        if (headA != null) {
            newTail.next = headA;
        }
        if (headB != null) {
            newTail.next = headB;
        }
        newTail = newHead.next;
        //遍历输出单链表
        while (newTail != null) {
            System.out.print(newTail.val + " ");
            newTail = newTail.next;
        }
    }

    public static ListNode getListNode(String s) {
        ListNode head = new ListNode(-1);
        ListNode node = head;
        for (String num : s.split(" ")) {
            int v = Integer.parseInt(num);
            node.next = new ListNode(v);
            node = node.next;
        }
        return head.next;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ListNode head1 = getListNode(sc.nextLine());
        ListNode head2 = getListNode(sc.nextLine());
        mergeTwoLists(head1, head2);
    }
    //2.方法二：使用集合与排序
}
