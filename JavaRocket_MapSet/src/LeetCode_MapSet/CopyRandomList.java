package LeetCode_MapSet;

import java.util.HashMap;
import java.util.Map;

/**
 * Description:
 *
 * @author: KangWuBin
 * @Date: 2019/12/3
 * @Time: 10:13
 */
class Node {
    public int val;
    public Node next;
    public Node random;

    public Node() {
    }

    public Node(int _val, Node _next, Node _random) {
        val = _val;
        next = _next;
        random = _random;
    }
}

public class CopyRandomList {
    /*2.(百度+++++)给定一个链表，每个节点包含一个额外增加的随机指针，该指针可以指向链表中的任何节点或空节点。
     *要求返回这个链表的深拷贝。
     * 输入：{"$id":"1","next":{"$id":"2","next":null,
     * "random":{"$ref":"2"},"val":2},"random":{"$ref":"2"},"val":1};
     * 解释：节点 1 的值是 1，它的下一个指针和随机指针都指向节点 2 。
     * 节点 2 的值是 2，它的下一个指针指向 null，随机指针指向它自己。
     */
    public Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }
        // 1. 先创建一个 HashMap , key 是旧的节点, value 是旧的节点对应的新的节点
        Map<Node, Node> map = new HashMap<>();
        Node cur = head;
        while (cur != null) {
            // 2. 把旧链表的节点依次以键值对的形式插入进来
            // 旧链表的节点为key，新链表的节点为val.
            Node node = new Node(cur.val, null, null);
            map.put(cur, node);
            cur = cur.next;
        }
        // 3.再次遍历旧的链表, 根据刚才得到的 hashMap
        // 就能够方便的把 next 和 random 都指到正确的位置上
        cur = head;
        while (cur != null) {
            map.get(cur).next = map.get(cur.next);
            map.get(cur).random = map.get(cur.random);
            cur = cur.next;
        }
        return map.get(head);
    }
}
