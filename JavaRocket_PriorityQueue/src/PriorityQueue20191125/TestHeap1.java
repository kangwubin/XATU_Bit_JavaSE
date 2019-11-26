package PriorityQueue20191125;

import java.util.Arrays;

/**
 * Description:
 *
 * @author: KangWuBin
 * @Date: 2019/11/25
 * @Time: 20:02
 */
public class TestHeap1 {

    public int[] elem;
    public int usedSize;

    public TestHeap1() {
        this.elem = new int[20];
        this.usedSize = 0;
    }

    /**
     * 一次调整
     *
     * @param
     * @param root：每次调整的这棵树的根节点下标
     */
    public void adjustDown(int root, int len) {
        int parent = root;
        int child = 2 * parent + 1;
        while (child < len) {
            //判断是否有右孩子 且谁最大
            if (child + 1 < len && elem[child] <
                    elem[child + 1]) {
                child = child + 1;
            }
            //child肯定是左右孩子的最大值下标
            if (elem[child] > elem[parent]) {
                int tmp = elem[child];
                elem[child] = elem[parent];
                elem[parent] = tmp;
                parent = child;
                child = 2 * parent + 1;
            } else {
                break;
            }
        }
    }

    public void createHeap(int[] array) {
        for (int i = 0; i < array.length; i++) {
            this.elem[i] = array[i];
            this.usedSize++;
        }
        for (int i = (this.usedSize - 1 - 1) / 2; i >= 0; i--) {
            adjustDown(i, this.usedSize);
        }
    }

    public void adjustUp(int child) {
        int parent = (child - 1) / 2;
        while (child > 0) {
            if (this.elem[child] > this.elem[parent]) {
                int tmp = elem[child];
                elem[child] = elem[parent];
                elem[parent] = tmp;
                child = parent;
                parent = (child - 1) / 2;
            } else {
                break;
            }
        }
    }

    public boolean isFull() {
        return this.usedSize == this.elem.length;
    }

    //入队
    public void pushHeap(int val) {
        //如果满了，就扩容
        if (isFull()) {
            this.elem = Arrays.copyOf
                    (this.elem, this.elem.length * 2);
        }
        //插入的元素就放在usedSize的位置，然后usedSize++
        this.elem[this.usedSize] = val;
        this.usedSize++;//11
        adjustUp(usedSize - 1);
    }

    public boolean isEmpty() {
        return this.usedSize == 0;
    }

    //出队
    public void popHeap() {
        //0、堆为空 的时候\
        if (isEmpty()) {
            return;
        }
        //1、根顶元素和最后一个元素进行交换
        int tmp = this.elem[0];
        this.elem[0] = this.elem[this.usedSize - 1];
        this.elem[this.usedSize - 1] = tmp;
        this.usedSize--;
        //2、向下调整，只需要调整0号下标这棵树
        adjustDown(0, this.usedSize);
    }

    //得到堆顶元素
    public int getPop() {
        if (isEmpty()) {
            return -1;
        }
        return this.elem[0];
    }

    //打印数据
    public void display() {
        for (int i = 0; i < this.usedSize; i++) {
            System.out.print(this.elem[i] + " ");
        }
        System.out.println();
    }

    //交换函数
    public void swap(int[] array, int x, int y) {
        int tmp = array[x];
        array[x] = array[y];
        array[y] = tmp;
    }

    //
    public void heapSort() {
        //每次调整的结束位置
        int end = this.usedSize - 1;
        while (end > 0) {
            int tmp = this.elem[0];
            this.elem[0] = this.elem[end];
            this.elem[end] = tmp;
            //end->adjustDown->len  小于
            adjustDown(0, end);
            end--;
        }
    }
}
