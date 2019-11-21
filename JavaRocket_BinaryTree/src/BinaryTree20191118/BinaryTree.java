package BinaryTree20191118;

import java.util.*;

/**
 * Description:二叉树的实现：核心思路要明白每次在递归的时候传入的root是不同的。
 *
 * @author: KangWuBin
 * @Date: 2019/11/18
 * @Time: 19:51
 */
class Node {
    char value;
    Node left;
    Node right;

    public Node(char value) {
        this.value = value;
    }
}

public class BinaryTree {
    public Node build() {
        Node A = new Node('A');
        Node B = new Node('B');
        Node C = new Node('C');
        Node D = new Node('D');
        Node E = new Node('E');
        Node F = new Node('F');
        Node G = new Node('G');
        Node H = new Node('H');
        A.left = B;
        B.left = D;
        B.right = E;
        E.right = H;
        A.right = C;
        C.left = F;
        C.right = G;
        return A;
    }

    // 递归实现前序遍历
    void preOrderTraversal(Node root) {
        if (root == null) {
            return;
        }
        System.out.print(root.value + " ");
        //需要理解每一次传入的root是哪个
        preOrderTraversal(root.left);
        preOrderTraversal(root.right);
    }

    //非递归实现前序遍历(难点)
    void preOrderTraversal2(Node root) {
        List<Character> list = new ArrayList<>();//oj
        if (root == null) {
            return;
        }
        Stack<Node> stack = new Stack<>();
        //1.让cur指向root
        Node cur = root;
        while (cur != null || !stack.isEmpty()) {
            while (cur != null) {
                //2.
                stack.push(cur);
                System.out.print(cur.value + " ");
                list.add(cur.value);
                cur = cur.left;
            }
            cur = stack.pop();
            cur = cur.right;
        }
//        return list;
    }

    // 中序遍历
    void inOrderTraversal(Node root) {
        if (root == null) {
            return;
        }
        inOrderTraversal(root.left);
        System.out.print(root.value + " ");
        inOrderTraversal(root.right);
    }

    //非递归实现中序遍历(难点)
    void inOrderTraversal2(Node root) {
        List<Character> list = new ArrayList<>();//oj当中写需要使用
        if (root == null) {
            return;
        }
        Stack<Node> stack = new Stack<>();
        Node cur = root;
        while (cur != null || !stack.isEmpty()) {
            while (cur != null) {
                //先将cur入栈，但不打印，然后cur一直往左走，直到cur.left为空的时候，
                //当前的栈顶元素就是cur，然后将cur出栈再打印，然后cur开始走right
                stack.push(cur);
                cur = cur.left;
            }
            cur = stack.pop();
            System.out.print(cur.value + " ");
            cur = cur.right;
        }
    }

    // 后序遍历
    void postOrderTraversal(Node root) {
        if (root == null) {
            return;
        }
        postOrderTraversal(root.left);
        postOrderTraversal(root.right);
        System.out.print(root.value + " ");
    }

    // 非递归实现后序遍历(难点)
    void postOrderTraversal2(Node root) {
        if (root == null) {
            return;
        }
        Stack<Node> stack = new Stack<>();
        Node cur = root;
        Node flg = null;//flg标记的是打印过的元素
        while (cur != null || !stack.isEmpty()) {
            //节点不为空一直压栈
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            //cur==null,cur需要拿到栈顶元素看是否有右子树
            //if(cur.right != null)
            //if(cur.right == null)
            cur = stack.peek();
            if (cur.right == null || cur.right == flg) {
                System.out.print(cur.value + " ");
                stack.pop();
                flg = cur;
                cur = null;
            } else {
                cur = cur.right;
            }
        }
    }

    // 遍历思路-求结点个数
    static int size = 0;

    int getSize1(Node root) {
        if (root == null) {
            return 0;
        }
        size++;
        getSize1(root.left);
        getSize1(root.right);
        return size;
    }

    // 子问题思路-求结点个数---面试
    int getSize2(Node root) {
        if (root == null) {
            return 0;
        }
        return getSize2(root.left) + getSize2(root.right) + 1;
    }

    // 子问题思路-求叶子结点个数
    int getLeafSize2(Node root) {
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            return 1;
        }
        return getLeafSize2(root.left) + getLeafSize2(root.right);
    }

    // 子问题思路-求第 k 层结点个数
    int getKLevelSize(Node root, int k) {
        if (root == null || k < 1) {
            return 0;
        }
        if (k == 1) {
            // k 为 1 的时候, 就一个根节点
            return 1;
        }
        // 求第 k 层节点的个数,求左子树的第 k - 1 层节点的个数 + 右子树的 k - 1 层
        return getKLevelSize(root.left, k - 1) + getKLevelSize(root.right, k - 1);
    }

    // 查找 val 所在结点，没有找到返回 null，按照根 -> 左子树 -> 右子树的顺序进行查找
    // 一旦找到，立即返回，不需要继续在其他位置查找
    Node find(Node root, int val) {
        if (root == null) {
            return null;
        }
        if (root.value == val) {
            return root;
        }
       /* if (root.left.value == val) {
            return find(root.left, val);
        }
        if (root.right.value == val) {
            return find(root.right, val);
        }*/
        Node result = find(root.left, val);
        if (result != null) {
            return result;
        }
        Node result2 = find(root.left, val);
        if (result2 != null) {
            return result2;
        }
        return null;
    }

    // 层序遍历：核心方法是借助队列来实现
    void levelOrderTraversal(Node root) {
        // 创建一个队列辅助进行遍历
        Queue<Node> queue = new LinkedList<>();
        //1.当根节点不为空的时候，就把根节点入队。
        if (root != null) {
            queue.offer(root);
        }
        while (!queue.isEmpty()) {
            //2.当队列不为空的时候，循环取队首元素. 访问这个元素.
            Node cur = queue.peek();
            // 3. 把当前这个队首元素左子树和右子树都插入队列中.
            if (cur.left != null) {
                queue.offer(cur.left);
            }
            if (cur.right != null) {
                queue.offer(cur.right);
            }
            Node output = queue.poll();
            if (output == null) {
                return;
            }
            System.out.print(output.value + " ");
        }
    }

    // 判断一棵树是不是完全二叉树(重点+++)
    //核心思路：借助队列(队列先进先出)列来完成，使用层序遍历的方式.
    boolean isCompleteTree(Node root) {
        Queue<Node> queue = new LinkedList<>();
        //1.当根节点不为空的时候，就把根节点入队。
        if (root != null) {
            queue.offer(root);
        }
        //2.当队列不为空的时候，让出队的元素为cur.
        while (!queue.isEmpty()) {
            Node cur = queue.poll();
            //3.如果cur不为空，就把cur的左子树和右子树也入队
            if (cur != null) {
                queue.offer(cur.left);
                queue.offer(cur.right);
            } else {
                break;
            }
        }
        //4.遍历队列中的元素，进行判断；
        // 完全二叉树--cur在出队的时候若遇到null，即把二叉树遍历完了，就认为是完全二叉树；
        // 如果在cur遇到null之后，而null之后还有其他元素，就不是二叉树.
        while (!queue.isEmpty()) {
            Node cur = queue.poll();
            if (cur != null) {
                return false;
            }
        }
        return true;
    }
}
