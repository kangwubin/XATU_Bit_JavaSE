package day23_201005;

/**
 * Description:
 * 实现一个二叉树，检查是否平衡，平衡的定义如下：对于树中的任意一个节点，其两颗子树的高度差不超过1；
 * 给定指向树根节点的指针TreeNode* root,请返回一个bool，代表这棵树是否平衡；
 *
 * @author: KangWuBin
 * @Date: 2020/1/4
 * @Time: 22:58
 */
class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;
    }
}

public class Balance {
    private boolean isBalance(TreeNode root) {
        if (root == null) {
            return true;
        }
        int left = TreeDepth(root.left);
        int right = TreeDepth(root.right);
        if (left - right < -1 || left - right > 1) {
            return false;
        }
        return isBalance(root.left) && isBalance(root.right);
    }

    private int TreeDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = TreeDepth(root.left);
        int right = TreeDepth(root.right);
        return (left > right) ? (left + 1) : (right + 1);
    }
}
