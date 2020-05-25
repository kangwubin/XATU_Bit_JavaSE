package NowCoder_单链表;

/**
 * Description:
 *
 * @author: KangWuBin
 * @Date: 2019/11/12
 * @Time: 9:14
 */
public class Main_ChkPalindrome {
    static class ListNode {
        int val;
        ListNode next = null;

        public ListNode(int val) {
            this.val = val;
        }
    }

    //8.对于一个链表，请设计一个时间复杂度为O(n),额外空间复杂度为O(1)的算法，判断其是否为回文结构。
    //给定一个链表的头指针A，请返回一个bool值，代表其是否为回文结构。保证链表长度小于等于900。
    //测试样例：1->2->2->1;返回：true
    //测试样例：1->2->3->2->1
    public boolean chkPalindrome(ListNode head) {
        if (head == null) {
            return true;
        }
        if (head.next == null) {
            return true;
        }
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        ListNode p = slow.next;
        return true;
    }
}
