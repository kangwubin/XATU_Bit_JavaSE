package BinaryTree20191120;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Description:
 *
 * @author: KangWuBin
 * @Date: 2019/11/20
 * @Time: 10:48
 */
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

public class Solution {
    /*二叉树的层次遍历
     * 给定一个二叉树，返回其按层次遍历的节点值。 （即逐层地，从左到右访问所有节点）。
     *例如:给定二叉树: [3,9,20,null,null,15,7],
     *返回其层次遍历结果：[[3],[9,20],[15,7]]*/
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ret = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        //当根节点不为空的时候，就把根节点入队。
        if (root != null) {
            queue.offer(root);
        }
        //队列的元素就是一层数据
        while (!queue.isEmpty()) {
            int count = queue.size();
            //存放的是一层数据
            List<Integer> list = new ArrayList<>();
            while (count > 0) {
                TreeNode cur = queue.poll();
                System.out.print(cur.val + " ");
                list.add(cur.val);
                if (cur.left != null) {
                    queue.offer(cur.left);
                }
                if (cur.right != null) {
                    queue.offer(cur.right);
                }
                count--;
            }
            ret.add(list);
        }
        return ret;
    }
}
