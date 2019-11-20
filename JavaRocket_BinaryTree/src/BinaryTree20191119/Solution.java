package BinaryTree20191119;

import java.util.ArrayList;
import java.util.List;

/**
 * Description:
 *
 * @author: KangWuBin
 * @Date: 2019/11/19
 * @Time: 9:21
 */
class TreeNode {
    Integer val;
    TreeNode left;
    TreeNode right;

    TreeNode(Integer x) {
        val = x;
    }
}

public class Solution {
    //给定一个二叉树，返回它的前序遍历。
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (root == null) {
            return list;
        }
        list.add(root.val);
        list.addAll(preorderTraversal(root.left));
        list.addAll(preorderTraversal(root.right));
        return list;
    }

    //给定一个二叉树，返回它的中序遍历。
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

    //给定一个二叉树，返回它的后序遍历。
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (root == null) {
            return list;
        }
        list.addAll(postorderTraversal(root.left));
        list.addAll(postorderTraversal(root.right));
        list.add(root.val);
        return list;
    }

    /* 给定两个二叉树，编写一个函数来检验它们是否相同。
     如果两个树在结构上相同，并且节点具有相同的值，则认为它们是相同的。*/
    public boolean isSameTree(TreeNode p, TreeNode q) {
        //思路：判定两个数相同 => 比较根节点是否相同 + 比较左子树是否相同 + 比较右子树是否相同
        // 1. 如果两棵树都是空树,直接返回 true
        if (p == null && q == null) {
            return true;
        }
        // 2. 如果两棵树一个为空一个不为空, 直接返回 false
        if (p == null || q == null) {
            return false;
        }
        // 3. 如果都不为空树
        // a) 比较一下根节点的值是否相同. 如果不相同, 就直接返回 false
        if (p.val != q.val) {
            return false;
        }
        // b) 递归比较左子树和递归比较右子树看看是不是也相同.
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }

    /* 给定两个非空二叉树 s 和 t，检验 s 中是否包含和 t 具有相同结构和节点值的子树。
       s 的一个子树包括 s 的一个节点和这个节点的所有子孙。s 也可以看做它自身的一棵子树。*/
    public boolean isSubtree(TreeNode s, TreeNode t) {
        //思路：比较s是否包含t => s和t是不是相等 + s.left是不是包含t + s.right是不是包含t;
        // 1. 如果两个树都是空树, 直接是 true
        if (s == null && t == null) {
            return true;
        }
        // 2. 如果两个树一个是空, 一个不是空, 返回false.
        if (s == null || t == null) {
            return false;
        }
        // 3. 如果两个数都非空
        //  a)比较根节点的值是不是相等, 如果相等的话,比较一下 s 和 t 是不是相同的树, 如果是相同的树 就认为是包含的.
        if (isSameTree(s, t)) {
            return true;
        }
        if (isSubtree(s.left, t)) {
            return true;
        }
        if (isSubtree(s.right, t)) {
            return true;
        }
        return false;
    }

    /*给定一个二叉树，找出其最大深度。二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。
    说明: 叶子节点是指没有子节点的节点。
    示例：给定二叉树 [3,9,20,null,null,15,7]，返回它的最大深度 3 。*/
    public int maxDepth(TreeNode root) {
        //思路：root的深度 = 1 + 左子树的深度 和 右子树深度的最大值.
        // 1. 如果是空树, 深度就是 0
        if (root == null) {
            return 0;
        }
        // 2. 如果只有一个根节点, 没有左右子树, 深度就是 1
        if (root.left == null && root.right == null) {
            return 1;
        }
        // 3. 1 + max(左子树的深度, 右子树的深度)
        int leftLen = maxDepth(root.left);
        int rightLen = maxDepth(root.right);
        return 1 + (leftLen > rightLen ? leftLen : rightLen);
    }

    /* 给定一个二叉树，判断它是否是高度平衡的二叉树。
     本题中，一棵高度平衡二叉树定义为：一个二叉树每个节点的左右两个子树的高度差的绝对值不超过1。*/
    public boolean isBalanced(TreeNode root) {
        // 1. 如果是空树, 就算平衡
        if (root == null) {
            return true;
        }
        // 2. 如果没有子树, 也算平衡
        if (root.left == null && root.right == null) {
            return true;
        }
        // 3. 求一下左右子树的高度, 判断一下差值是否 <= 1
        int leftHight = maxDepth(root.left);
        int rightHight = maxDepth(root.right);
        if (leftHight - rightHight > 1) {
            return false;
        }
        if (rightHight - leftHight > 1) {
            return false;
        }
        // 4. 递归判定左子树和右子树是不是也是平衡的.
        return isBalanced(root.left) && isBalanced(root.right);
    }

    /*给定一个二叉树，检查它是否是镜像对称的。
    例如，二叉树 [1,2,2,3,4,4,3] 是对称的。*/
    public boolean isSymmetric(TreeNode root) {
        //思路：把判断对称转换成判定左右子树是否是镜像关系
        if (root == null) {
            return true;
        }
        return isMirror(root.left, root.right);
    }

    //判断是不是镜像
    private boolean isMirror(TreeNode leftTree, TreeNode rightTree) {
        // 1. 如果两个树都是空树, 应算镜像
        if (leftTree == null && rightTree == null) {
            return true;
        }
        // 2. 如果两个树一个空一个非空, 就不算镜像
        if (leftTree == null && rightTree != null) {
            return false;
        }
        if (leftTree != null && rightTree == null) {
            return false;
        }
        // 3. 如果两个树都不为空.
        // a) 比较根节点是不是相同, 不相同就不是镜像.
        // b) 递归比较子树, t1.left 和 t2.right ,t1.right 和 t2.left 是不是镜像.
        return (leftTree.val == rightTree.val)
                && isMirror(leftTree.left, rightTree.right)
                && isMirror(leftTree.right, rightTree.left);
    }

}
