package NowCoder_单链表;

/**
 * Description:
 *
 * @author: KangWuBin
 * @Date: 2019/11/12
 * @Time: 9:06
 */
public class Main_FindKthToTail {
    static class ListNode {
        int val;
        ListNode next = null;

        public ListNode(int val) {
            this.val = val;
        }
    }

    public ListNode FindKthToTail(ListNode head, int k) {
        ListNode cur = head;
        int len = length(head);
        int offset = len - k;
        for (int i = 0; i < offset; i++) {
            cur = cur.next;
        }
        return cur;
    }

    public int length(ListNode head) {
        int size = 0;
        for (ListNode cur = head; cur != null; cur = cur.next) {
            size++;
        }
        return size;
    }

    public ListNode FindKthToTail1(ListNode head, int k) {
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }
        return null;
    }
}
