package LeetCode_BinaryTree;


import java.util.*;

/**
 * Description:
 *
 * @author: KangWuBin
 * @Date: 2019/11/25
 * @Time: 15:55
 */
class Node {
    char value;
    Node left;
    Node right;

    public Node(char value) {
        this.value = value;
    }
}

public class Implement_BinaryTree {
    //1.非递归实现前序遍历(难点++)--栈
    void preOrderTraversal2(Node root) {
        List<Character> list = new ArrayList<>();
        if (root == null) {
            return;
        }
        Stack<Node> stack = new Stack<>();
        Node cur = root;
        while (cur != null || !stack.isEmpty()) {
            while (cur != null) {
                stack.push(cur);
                System.out.println(cur.value + " ");
                list.add(cur.value);
                cur = cur.left;
            }
            cur = stack.pop();
            cur = cur.right;
        }
    }

    //2.非递归实现中序遍历(难点++)--栈
    void inOrderTraversal2(Node root) {
        if (root == null) {
            return;
        }
        Stack<Node> stack = new Stack<>();
        Node cur = root;
        while (cur != null || !stack.isEmpty()) {
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            cur = stack.pop();
            System.out.println(cur.value + " ");
        }
    }

    // 非递归实现后序遍历(难点++++)--栈
    void postOrderTraversal2(Node root) {
        if (root == null) {
            return;
        }
        Stack<Node> stack = new Stack<>();
        Node cur = root;
        Node flg = null;
        while (cur != null || !stack.isEmpty()) {
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            cur = stack.peek();
            if (cur.right == null || cur.right == flg) {
                System.out.println(cur.value + " ");
                stack.pop();
                flg = cur;
                cur = null;
            } else {
                cur = cur.right;
            }
        }
    }

    // 层序遍历：核心方法是借助队列来实现
    void levelOrderTraversal(Node root) {
        Queue<Node> queue = new LinkedList<>();
        if (root != null) {
            queue.offer(root);
        }
        while (!queue.isEmpty()) {
            Node cur = queue.peek();
            if (cur.left != null) {
                queue.offer(cur.left);
            }
            if (cur.right != null) {
                queue.offer(cur.right);
            }
            Node output = queue.poll();
            if (output != null) {
                System.out.println(output.value + " ");
            }
        }
    }

    // 判断一棵树是不是完全二叉树(重点+++)
    //核心思路：借助队列(队列先进先出)列来完成，使用层序遍历的方式.
    boolean isCompleteTree(Node root) {
        Queue<Node> queue = new LinkedList<>();
        if (root != null) {
            queue.offer(root);
        }
        while (!queue.isEmpty()) {
            Node cur = queue.poll();
            if (cur != null) {
                queue.offer(cur.left);
                queue.offer(cur.right);
            } else {
                break;
            }
        }
        while (!queue.isEmpty()) {
            Node cur = queue.poll();
            if (cur != null) {
                return false;
            }
        }
        return true;
    }
}
