package BinaryTree20191118;

/**
 * Description:测试二叉树的实现方法
 *
 * @author: KangWuBin
 * @Date: 2019/11/18
 * @Time: 20:13
 */
public class TestDemo {
    private static Node root = null;

    public static void main(String[] args) {
        BinaryTree binaryTree = new BinaryTree();
        root = binaryTree.build();
        System.out.println("递归实现先序遍历");
        binaryTree.preOrderTraversal(root);
        System.out.println();
        System.out.println("非递归实现先序遍历");
        binaryTree.preOrderTraversal2(root);

        System.out.println();
        System.out.println("递归实现中序遍历");
        binaryTree.inOrderTraversal(root);
        System.out.println();
        System.out.println("非递归实现中序遍历");
        binaryTree.inOrderTraversal2(root);

        System.out.println();
        System.out.println("递归实现后序遍历");
        binaryTree.postOrderTraversal(root);
        System.out.println();
        System.out.println("非递归实现后序遍历");
        binaryTree.postOrderTraversal2(root);

        System.out.println();
        System.out.println("层序遍历");
        binaryTree.levelOrderTraversal(root);

        System.out.println();
        int size = binaryTree.getSize2(root);
        System.out.println(size);

        System.out.println(binaryTree.isCompleteTree(root));

    }
}
