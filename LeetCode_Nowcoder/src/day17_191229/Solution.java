package day17_191229;

/**
 * Description:操作给定的二叉树，将其变换为源二叉树的镜像；
 *
 * @author: KangWuBin
 * @Date: 2019/12/29
 * @Time: 21:47
 */
class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;
    }
}

public class Solution {
    public void Mirror(TreeNode root) {
        if (root == null) {
            return;
        }
        if (root.left == null && root.right == null) {
            return;
        }
        TreeNode tmp = null;
        tmp = root.right;
        root.right = root.left;
        root.left = tmp;
        if (root.left != null) {
            Mirror(root.left);
        }
        if (root.right != null) {
            Mirror(root.right);
        }
    }
}
