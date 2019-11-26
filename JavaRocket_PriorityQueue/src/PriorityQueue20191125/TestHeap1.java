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
    //len==usedSize
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

    //创建堆
    public void createHeap(int[] array) {
        //扩容，每增加一个元素，usedSize++
        for (int i = 0; i < array.length; i++) {
            this.elem[i] = array[i];
            this.usedSize++;
        }
        // 从最后一个非叶子节点出发, 从后往前走, 针对每个节点, 进行向下调整
        // 第一个 usedSize - 1 是为了找到最后一个元素的下标
        // 再在最后一个元素下标的基础上再 - 1 再除以 2，得到父亲节点的坐标.
        for (int i = (this.usedSize - 1 - 1) / 2; i >= 0; i--) {
            adjustDown(i, this.usedSize);
        }
    }

    //向上调整
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

    //判断满
    public boolean isFull() {
        return this.usedSize == this.elem.length;
    }

    /*入队操作步骤：
     * 1.首先按尾插方式放入数组
     * 2.比较其和其双亲的值的大小，如果双亲的值大，则满足堆的性质，插入结束
     * 3.否则，交换其和双亲位置的值，重新进行 2、3 步骤
     * 4.直到根结点*/
    public void pushHeap(int val) {
        //如果满了，就扩容
        if (isFull()) {
            this.elem = Arrays.copyOf
                    (this.elem, this.elem.length * 2);
        }
        //插入的元素就放在usedSize的位置，然后usedSize++
        this.elem[this.usedSize] = val;
        this.usedSize++;//11
        adjustUp(usedSize - 1);//传的是下标
    }

    //判断空
    public boolean isEmpty() {
        return this.usedSize == 0;
    }

    //出队:为了防止破坏堆的结构，删除时并不是直接将堆顶元素删除，
    //而是用数组的最后一个元素替换堆顶元素，然后通过向下调整方式重新调整成堆
    public void popHeap() {
        //0、堆为空的时候
        if (isEmpty()) {
            return;
        }
        //1、根顶元素和最后一个元素进行交换
        int tmp = this.elem[0];
        this.elem[0] = this.elem[this.usedSize - 1];
        this.elem[this.usedSize - 1] = tmp;
        this.usedSize--;
        //2、向下调整，只需要调整0号下标这棵树
        adjustDown(0, this.usedSize);//usedSize是usedSize--减过的值
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

    //堆排序
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
