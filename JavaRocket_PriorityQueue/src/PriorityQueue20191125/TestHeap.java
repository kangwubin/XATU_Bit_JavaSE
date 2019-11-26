package PriorityQueue20191125;

import java.util.Arrays;

/**
 * Description:
 *
 * @author: KangWuBin
 * @Date: 2019/11/25
 * @Time: 19:27
 */
public class TestHeap {
    //向下调整
    public void adjustDown(int[] array, int root) {
        //root为树的根节点，即是数组中下标为0号下标的元素
        int parent = root;
        //根据root的下标，计算child的下标
        /*已知双亲(parent)的下标，则：
         *左孩子(left)下标 = 2 * parent + 1;
         *右孩子(right)下标 = 2 * parent + 2*/
        int child = 2 * parent + 1;
        int size = array.length;
        while (child < size) {
            // child 本来是左子树的下标, 再 + 1 就是右子树下标
            // 在找左子树和右子树谁大
            if (child + 1 < size
                    && array[child + 1] > array[child]) {
                child = child + 1;
            }
            // if 之后 child 不知道它是左还是右了, 而一定是左右中的最大值
            if (array[child] > array[parent]) {
                // 不符合大堆的特性, 交换 child 和 parent 的位置
                swap(array, child, parent);
            } else {
                // 如果发现满足堆的特性, 调整就结束了
                break;
            }
            parent = child;
            child = 2 * parent + 1;
        }
    }

    //向上调整
    public void adjustUp(int[] array, int child) {
        int parent = (child - 1) / 2;
        while (child > 0) {
            if (array[parent] >= array[child]) {
                break;
            }
            swap(array, child, parent);
            child = parent;
            parent = (child - 1) / 2;
        }
    }

    //交换函数
    public void swap(int[] array, int x, int y) {
        int tmp = array[x];
        array[x] = array[y];
        array[y] = tmp;
    }

    // 要把 [0, size) 范围中的元素建成堆
    public void createHeap(int[] array, int size) {
        // 从最后一个非叶子节点出发, 从后往前走, 针对每个节点, 进行向下调整
        // 第一个 size - 1 是为了找到最后一个元素的下标
        // 再在最后一个元素下标的基础上再 - 1 再除以 2
        for (int i = (size - 1 - 1) / 2; i >= 0; i--) {
            adjustDown(array, i);
        }
    }
}
