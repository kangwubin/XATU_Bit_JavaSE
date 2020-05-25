package day22_200104;

/**
 * Description:
 * 有两个用链表表示的整数，每个结点包含一个数位。这些数位是反向存放的，也就是个位排在链表的首部。
 * 编写函数对这两个整数求和，并用链表形式返回结果。
 * 给定两个链表ListNode* A，ListNode* B，请返回A+B的结果(ListNode*)。
 * 测试样例：{1,2,3},{3,2,1}，返回：{4,4,4}
 *
 * @author: KangWuBin
 * @Date: 2020/1/3
 * @Time: 21:23
 */
class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}

public class Plus {
    /*可以用此法完成大数加减，乘法也可以（加减乘都是从低位到高位），除法需要从高位开始到低位*/
    public ListNode plusAB(ListNode a, ListNode b) {
        if (a == null || b == null) {
            return null;
        }
        int add = 0;
        ListNode head = new ListNode(-1);
        ListNode resultCur = head;
        ListNode curA = a;
        ListNode curB = b;
        while (curA != null || curB != null) {
            if (curA != null && curB != null) {
                resultCur.next = new ListNode((curA.val + curB.val + add) % 10);
                resultCur = resultCur.next;
                add = (curA.val + curB.val + add) / 10;
                curA = curA.next;
                curB = curB.next;
            } else if (curA != null) {
                resultCur.next = new ListNode((curA.val + add) % 10);
                resultCur = resultCur.next;
                add = (curA.val + add) / 10;
                curA = curA.next;
            } else {
                resultCur.next = new ListNode((curB.val + add) % 10);
                resultCur = resultCur.next;
                add = (curB.val + add) / 10;
                curB = curB.next;
            }
        }
        if (add > 0) {
            resultCur.next = new ListNode(add);
            resultCur = resultCur.next;
        }
        return head.next;
    }
}
