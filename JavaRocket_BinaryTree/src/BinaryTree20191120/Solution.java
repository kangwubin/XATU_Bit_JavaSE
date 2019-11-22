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
            //queue.size()，通过计算当前队列的大小，就可以知道队列当中有没有元素
            int count = queue.size();// 1->2
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

    /*给定一个二叉树, 找到该树中两个指定节点的最近公共祖先。
     *百度百科中最近公共祖先的定义为：“对于有根树 T 的两个结点 p、q，最近公共祖先表示为一个结点 x，
     *满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）。
     *例如，给定如下二叉树:  root = [3,5,1,6,2,0,8,null,null,7,4]；
     *输入: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1；输出: 3
     *解释: 节点 5 和节点 1 的最近公共祖先是节点 3。
     *输入: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 4；输出: 5
     *解释: 节点 5 和节点 4 的最近公共祖先是节点 5。因为根据定义最近公共祖先节点可以为节点本身。。*/
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return null;
        }
        if (p == root || q == root) {
            return root;
        }
        //leftNode就是从左递归拿到的第一个p或者q的值.
        TreeNode leftNode = lowestCommonAncestor(root.left, p, q);
        TreeNode rightNode = lowestCommonAncestor(root.right, p, q);
        if (leftNode != null && rightNode != null) {
            return root;
        }
        if (leftNode != null) {
            return leftNode;
        }
        if (rightNode != null) {
            return rightNode;
        }
        return null;
    }

    /*输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的双向链表。
     *要求不能创建任何新的结点，只能调整树中结点指针的指向。
     * 二叉搜索树又称二叉排序树，它或者是一棵空树，或者具有以下性质：
     * 1.若它的左子树不为空，则左子树上所有节点的值都小于根节点的值；
     * 2.若它的右子树不为空，则右子树上所有节点的值都大于根节点的值；
     * 3.它的左右子树也分别为二叉搜索树；*/
    public TreeNode Convert(TreeNode pRootOfTree) {
        //left表示前驱，right表示后继
        //中序遍历二叉搜索树
        ConvertChild(pRootOfTree);
        TreeNode head = pRootOfTree;
        while (head != null && head.left != null) {
            head = head.left;
        }
        return head;
    }

    public TreeNode prev;

    private void ConvertChild(TreeNode root) {
        if (root == null) {
            return;
        }
        ConvertChild(root.left);//此函数结束，左树遍历完了，左树结束.
        root.left = prev;
        if (prev != null) {
            prev.right = root;
        }
        prev = root;
        ConvertChild(root.right);
    }

    /*根据一棵树的前序遍历与中序遍历构造二叉树。(重点)
     *注意:你可以假设树中没有重复的元素。
     *例如，给出前序遍历 preorder = [3,9,20,15,7];中序遍历 inorder = [9,3,15,20,7]*/
    public int preIndex = 0;//先序遍历的0号下表的元素

    //思路：1.先遍历前序；2.找到前序节点在中序当中的位置；3.一直去遍历前序.
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length == 0 || inorder.length == 0) {
            return null;
        }
        return buildTreeChild(preorder, inorder, 0, inorder.length - 1);
    }

    public TreeNode buildTreeChild(int[] preorder, int[] inorder, int inbegin, int inend) {
        if (inbegin > inend) {
            return null;
        }
        //preorder[preIndex]--先序遍历的preIndex下表设为根节点；
        TreeNode root = new TreeNode(preorder[preIndex]);
        //找到root在中序遍历数组当中的位置
        int rootIndex = findInorderIndex(inorder, inbegin, inend, preorder[preIndex]);
        if (rootIndex == -1) {
            return null;
        }
        preIndex++;
        root.left = buildTreeChild(preorder, inorder, inbegin, rootIndex - 1);
        root.right = buildTreeChild(preorder, inorder, rootIndex + 1, inend);
        return root;
    }

    //在中序遍历中，找根(root)在中序遍历中的位置
    public int findInorderIndex(int[] inorder, int inbegin, int inend, int val) {
        for (int i = inbegin; i <= inend; i++) {
            if (inorder[i] == val) {
                return i;
            }
        }
        return -1;
    }

    /*你需要采用前序遍历的方式，将一个二叉树转换成一个由括号和整数组成的字符串。
     *空节点则用一对空括号 "()" 表示。而且你需要省略所有不影响字符串与原始二叉树之间的一对一映射关系的空括号对。
     *输入:二叉树: [1,2,3,4];输出: "1(2(4))(3)";
     *解释:原本将是“1(2(4)())(3())”，在你省略所有不必要的空括号对之后，它将是“1(2(4))(3)”。
     *输入:二叉树: [1,2,3,null,4];输出: "1(2()(4))(3)"
     *解释:和第一个示例相似，除了我们不能省略第一个对括号来中断输入和输出之间的一对一映射关系。*/
    public String tree2str(TreeNode t) {
        StringBuilder sb = new StringBuilder();
        tree2strChild(t, sb);
        return sb.toString();
    }

    private void tree2strChild(TreeNode t, StringBuilder sb) {
        if (t == null) {
            return;
        }
        sb.append(t.val);
        if (t.left == null) {
            if (t.right == null) {
                return;
            } else {
                sb.append("()");
            }
        } else {
            sb.append("(");
            tree2strChild(t.left, sb);
            sb.append(")");
        }

        if (t.right == null) {
            return;
        } else {
            sb.append("(");
            tree2strChild(t.right, sb);
            sb.append(")");
        }
    }

}
