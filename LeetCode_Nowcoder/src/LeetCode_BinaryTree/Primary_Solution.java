package LeetCode_BinaryTree;

import java.util.ArrayList;
import java.util.List;

/**
 * Description:二叉树初级面试题
 *
 * @author: KangWuBin
 * @Date: 2019/11/25
 * @Time: 15:18
 */
class TreeNode {
    Integer val;
    TreeNode left;
    TreeNode right;

    TreeNode(Integer x) {
        val = x;
    }
}

public class Primary_Solution {
    //1.给定一个二叉树，返回它的前序遍历。---根-左-右
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (root == null) {
            return list;
        }
        list.add(root.val);
        preorderTraversal(root.left);
        preorderTraversal(root.right);
        return list;
    }

    //2.给定一个二叉树，返回它的中序遍历。--左-根-右
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (root == null) {
            return list;
        }
        list.addAll(inorderTraversal(root.left));
        list.add(root.val);
        list.addAll(inorderTraversal(root.right));
        return list;
    }

    //3.给定一个二叉树，返回它的后序遍历。--左-右-根
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        list.addAll(postorderTraversal(root.left));
        list.addAll(postorderTraversal(root.right));
        list.add(root.val);
        return list;
    }

    /*4.给定两个二叉树，编写一个函数来检验它们是否相同。
    如果两个树在结构上相同，并且节点具有相同的值，则认为它们是相同的。*/
    public boolean isSameTree(TreeNode p, TreeNode q) {
        //思路：判定两个数相同 => 比较根节点是否相同 + 比较左子树是否相同 + 比较右子树是否相同
        if (p == null && q == null) {
            return true;
        }
        if (p == null || q == null) {
            return false;
        }
        if (p.val != (q.val)) {
            return false;
        }
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }

    /*5.给定两个非空二叉树 s 和 t，检验 s 中是否包含和 t 具有相同结构和节点值的子树。
      s 的一个子树包括 s 的一个节点和这个节点的所有子孙。s 也可以看做它自身的一棵子树。*/
    public boolean isSubtree(TreeNode s, TreeNode t) {
        //思路：比较s是否包含t => s和t是不是相等 + s.left是不是包含t + s.right是不是包含t;
        if (s == null && t == null) {
            return true;
        }
        if (s == null || t == null) {
            return false;
        }
        if (isSameTree(s, t)) {
            return true;
        }
        return isSubtree(s.left, t) && isSubtree(s.right, t);
    }

    /*6.给定一个二叉树，找出其最大深度。二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。
     *说明: 叶子节点是指没有子节点的节点。
     *示例：给定二叉树 [3,9,20,null,null,15,7]，返回它的最大深度 3 。*/
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            return 1;
        }
        int leftHight = maxDepth(root.left);
        int rightHight = maxDepth(root.right);
        return 1 + (leftHight > rightHight ? leftHight : rightHight);
    }

    /*7.给定一个二叉树，判断它是否是高度平衡的二叉树。
     *本题中，一棵高度平衡二叉树定义为：一个二叉树每个节点的左右两个子树的高度差的绝对值不超过1。*/
    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }
        if (root.left == null && root.right == null) {
            return true;
        }
        int leftHight = maxDepth(root.left);
        int rightHight = maxDepth(root.right);
        if (leftHight - rightHight > 1) {
            return false;
        }
        if (rightHight - leftHight > 1) {
            return false;
        }
        return isBalanced(root.left) && isBalanced(root.right);
    }

    /*8.给定一个二叉树，检查它是否是镜像对称的。
     *例如，二叉树 [1,2,2,3,4,4,3] 是对称的。*/
    public boolean isSymmetric(TreeNode root) {
        //思路：把判断对称转换成判定左右子树是否是镜像关系
        if (root == null) {
            return true;
        }
        return isMirror(root.left, root.right);
    }

    private boolean isMirror(TreeNode leftTree, TreeNode rightTree) {
        if (leftTree == null && rightTree == null) {
            return true;
        }
        if (leftTree == null || rightTree == null) {
            return false;
        }
        if (leftTree.val == rightTree.val) {
            return isMirror(leftTree.left, rightTree.right) &&
                    isMirror(leftTree.right, rightTree.left);
        }
        return false;
    }
}


