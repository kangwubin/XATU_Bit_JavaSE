package BinarySearchTree;

import com.sun.org.apache.bcel.internal.generic.IF_ACMPEQ;

/**
 * Description:
 *
 * @author: KangWuBin
 * @Date: 2019/12/4
 * @Time: 9:33
 */
public class BinarySearchTree {
    static class Node {
        public int val;
        public Node left;
        public Node right;

        public Node(int val) {
            this.val = val;
        }
    }

    public Node root;

    //插入操作
    public void insert(int key) {
        Node node = new Node(key);
        if (root == null) {
            root = node;
            return;
        }
        Node cur = root;
        Node parent = null;
        while (cur != null) {
            parent = cur;
            if (cur.val == key) {
                return;
            }
            if (key == 0) {
                return;
            }
            if (cur.val < key) {
                parent = cur;
                cur = cur.right;
            } else {
                parent = cur;
                cur = cur.left;
            }
        }
        if (parent.val < key) {
            parent.right = node;
        } else {
            parent.left = node;
        }
    }

    //先序遍历
    public void prevOrder(Node root) {
        if (root == null) {
            return;
        }
        System.out.print(root.val + " ");
        prevOrder(root.left);
        prevOrder(root.right);
    }

    //中序遍历
    public void inOrder(Node root) {
        if (root == null) {
            return;
        }
        inOrder(root.left);
        System.out.print(root.val + " ");
        inOrder(root.right);
    }

    //查找操作
    public Node search(int key) {
        Node cur = root;
        while (cur != null) {
            if (cur.val == key) {
                return cur;
            } else if (cur.val < key) {
                cur = cur.right;
            } else {
                cur = cur.left;
            }
        }
        return null;
    }

    //删除操作
    public void remove(int key) {
        Node cur = root;
        Node parent = null;
        while (cur != null) {
            if (cur.val == key) {
                //删除
                removeNode(parent, cur);
            } else if (cur.val > key) {
                parent = cur;
                cur = cur.left;
            } else {
                parent = cur;
                cur = cur.right;
            }
        }
    }

    /*
     * 1.parent:要删除节点的父亲节点。
     * 2.cur:要删除的节点。*/
    private void removeNode(Node parent, Node cur) {
        if (cur.left == null) {
            if (cur == root) {
                root = cur.right;
            } else if (cur == parent.left) {
                parent.left = cur.right;
            } else {
                parent.right = cur.right;
            }
        } else if (cur.right == null) {
            if (cur == root) {
                root = cur.left;
            } else if (cur == parent.left) {
                parent.left = cur.left;
            } else {
                parent.right = cur.left;
            }
        } else {
            Node targetParent = cur;
            Node target = cur.right;
            while (target.left != null) {
                targetParent = target;
                target = target.left;
            }
            cur.val = target.val;
            if (target == targetParent.left) {
                targetParent.left = target.right;
            } else {
                targetParent.right = target.right;
            }
        }
    }

}
