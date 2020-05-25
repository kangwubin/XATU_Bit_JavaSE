package SortDemo;

import java.util.Arrays;

/**
 * Description:
 *
 * @author: KangWuBin
 * @Date: 2019/12/2
 * @Time: 15:25
 */
public class HeapSort {

    public static void heapSort(int[] array) {
        //1.创建堆
        // 从最后一个非叶子节点, 开始出发, 从后往前依次向下调整
        for (int i = (array.length - 1 - 1) / 2; i >= 0; i--) {
            adjustDown(array, i, array.length);
        }
        //2.循环取出堆顶的最大值，放到最后面。
        int end = array.length - 1;
        while (end > 0) {
            int tmp = array[0];
            array[0] = array[end];
            array[end] = tmp;
            adjustDown(array, 0, end);
            end--;
        }
    }

    private static void adjustDown(int[] array, int root, int length) {
        int parent = root;
        int child = 2 * parent + 1;
        while (child < length) {
            if (child + 1 < length && array[child] < array[child + 1]) {
                child = child + 1;
            }
            if (array[child] > array[parent]) {
                int tmp = array[child];
                array[child] = array[parent];
                array[parent] = tmp;
            } else {
                break;
            }
            parent = child;
            child = 2 * parent + 1;
        }
    }


    public static void main(String[] args) {
        int[] array = {9, 5, 2, 7, 3, 6, 8, 1};
        heapSort(array);
        System.out.println(Arrays.toString(array));
    }
}
