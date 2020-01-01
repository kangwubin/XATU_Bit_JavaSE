package BinarySearchTree;

/**
 * Description:
 *
 * @author: KangWuBin
 * @Date: 2019/12/4
 * @Time: 9:52
 */
public class Test {
    public static void main(String[] args) {
        BinarySearchTree binarySearchTree = new BinarySearchTree();
        int[] array = {9, 5, 2, 7, 3, 6, 8, 1};
        for (int i = 0; i < array.length; i++) {
            binarySearchTree.insert(array[i]);
        }
        binarySearchTree.prevOrder(binarySearchTree.root);
        System.out.println();
        binarySearchTree.inOrder(binarySearchTree.root);
        System.out.println();
        BinarySearchTree.Node ret = binarySearchTree.search(6);
        System.out.println(ret.val);
        binarySearchTree.remove(1);
        binarySearchTree.inOrder(binarySearchTree.root);
    }
}
