package BinaryTree20191120;

import java.util.Scanner;

/**
 * Description:
 *
 * @author: KangWuBin
 * @Date: 2019/11/20
 * @Time: 11:49
 */
class Node {
    char value;
    Node left;
    Node right;

    public Node(char value) {
        this.value = value;
    }
}

/*叉树的构建及遍历：
 *编一个程序，读入用户输入的一串先序遍历字符串，根据此字符串建立一个二叉树（以指针方式存储）。
 *例如如下的先序遍历字符串： ABC##DE#G##F### 其中“#”表示的是空格，空格字符代表空树。
 *建立起此二叉树以后，再对二叉树进行中序遍历，输出遍历结果。
 *输入：输入包括1行字符串，长度不超过100。
 *输出：可能有多组测试数据，对于每组数据，输出将输入字符串建立二叉树后中序遍历的序列，
 *每个字符后面都有一个空格。每个输出结果占一行。
 *输入：abc##de#g##f###；输出：c b e g d f a */
public class Main {
    public static int i = 0;//i是个坑

    public static Node buildTree(String str) {
        Node root = null;
        if (str.charAt(i) != '#') {
            root = new Node(str.charAt(i));
            i++;
            root.left = buildTree(str);
            root.right = buildTree(str);
        } else {
            i++;
        }
        return root;
    }


    public static void inOrderTraversal(Node root) {
        if (root == null) {
            return;
        }
        inOrderTraversal(root.left);
        System.out.print(root.value + " ");
        inOrderTraversal(root.right);
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String str = scan.nextLine();
        Node root = buildTree(str);
        inOrderTraversal(root);
    }

}
