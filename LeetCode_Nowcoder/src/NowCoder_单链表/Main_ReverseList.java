package NowCoder_单链表;

import java.util.Scanner;

/**
 * Description:
 *
 * @author: KangWuBin
 * @Date: 2019/11/11
 * @Time: 17:49
 */
public class Main_ReverseList {
    static class ListNode {
        int val;
        ListNode next = null;

        public ListNode(int val) {
            this.val = val;
        }
    }

    /*
     * 对于一个链表 L: L0→L1→…→Ln-1→Ln,将其翻转成 L0→Ln→L1→Ln-1→L2→Ln-2→…
     * 输入是一串数字，请将其转换成单链表格式之后，再进行操作;
     * 输入：1,2,3,4,5；输出：1,5,2,4,3*/
    public static ListNode reverseList(ListNode head) {
        if (head == null) {
            return null;
        }
        if (head.next == null) {
            return head;
        }
        ListNode prev = null;
        ListNode cur = head;
        ListNode newHead = null;
        while (cur != null) {
            ListNode next = cur.next;
            if (cur.next == null) {
                newHead = cur;
            }
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        return newHead;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
    }
}
