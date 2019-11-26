package Sort20191126;

import java.util.Arrays;

/**
 * Description:
 *
 * @author: KangWuBin
 * @Date: 2019/11/26
 * @Time: 10:19
 */
public class SortDemo {
    /* 1.直接插入排序：每次选择无序区间的第一个元素，在有序区间内选择合适的位置插入.
     * 最坏情况下：时间复杂度为O(n^2)---无序的时候；
     * 最好情况下：时间复杂度为O(n)---有序的时候；
     * 注意：越有序排序速度越快；
     * 稳定性：稳定排序；*/
    public static void insertSort(int[] array) {
        for (int i = 1; i < array.length; i++) {
            int tmp = array[i];
            int j = i - 1;
            for (; j >= 0; j--) {
                //如果 array[j] >= tmp，就是不稳定排序.
                if (array[j] > tmp) {
                    array[j + 1] = array[j];
                } else {
                    break;
                }
            }
            array[j + 1] = tmp;
        }
    }

    /*
     * 2.希尔排序：希尔排序法的基本思想是：先选定一个整数，把待排序文件中所有记录分成个组，
     * 所有距离为的记录分在同一组内，并对每一组内的记录进行排序。
     * 然后取重复上述分组和排序的工作。当到达=1时，所有记录在统一组内排好序
     * 最坏情况下：时间复杂度O(n^1.5);
     * 最好情况下：时间复杂度O(n);
     * 稳定性：不稳定；*/
    public static void shellSort(int[] array) {
        //定义增量数组
        int[] drr = {5, 3, 1};
        for (int i = 0; i < drr.length; i++) {
            shell(array, drr[i]);
        }
    }

    //gap->组数  进行组内直接插入排序
    private static void shell(int[] array, int gap) {
        for (int i = gap; i < array.length; i += 1) {
            int tmp = array[i];
            int j = i - gap;
            for (; j >= 0; j -= gap) {
                //如果 array[j] >= tmp，就是不稳定排序.
                if (array[j] > tmp) {
                    array[j + gap] = array[j];
                } else {
                    break;
                }
            }
            array[j + gap] = tmp;
        }
    }

    /*3.选择排序：每一次从无序区间选出最大（或最小）的一个元素，
     *存放在无序区间的最后（或最前），直到全部待排序的数据元素排完。
     * 时间复杂度为;O(n^2)；
     * 排序稳定性：不稳定；
     * */
    public static void selectSort(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = i + 1; j < array.length; j++) {
                if (array[j] < array[i]) {
                    int tmp = array[j];
                    array[j] = array[i];
                    array[i] = tmp;
                }
            }
        }
    }

    /*4.堆排序：基本原理也是选择排序，只是不在使用遍历的方式查找无序区间的最大的数，
     *而是通过堆来选择无序区间的最大的数；
     *注意：排升序要建大堆；排降序要建小堆；
     *时间复杂度：O(n * log(n))；
     *排序稳定性：不稳定；*/
    //向下调整
    private static void adjustDown(int[] array, int root, int len) {
        int parent = root;
        int child = 2 * parent + 1;
        while (child < len) {
            if (child + 1 < len && array[child] < array[child + 1]) {
                child = child + 1;
            }
            if (array[child] > array[parent]) {
                int tmp = array[child];
                array[child] = array[parent];
                array[parent] = tmp;
                parent = child;
                child = 2 * parent + 1;
            } else {
                break;
            }
        }
    }

    //堆排序
    public static void heapSort(int[] array) {
        for (int i = (array.length - 1 - 1) / 2; i >= 0; i--) {
            adjustDown(array, i, array.length);
        }
        int end = array.length - 1;
        while (end > 0) {
            int tmp = array[0];
            array[0] = array[end];
            array[end] = tmp;
            adjustDown(array, 0, end);
            end--;
        }
    }


    public static void main(String[] args) {
        int[] array = {13, 8, 2, 7, 10};
        insertSort(array);
        System.out.println("直接插入排序：" + Arrays.toString(array));
        shellSort(array);
        System.out.println("希尔排序：" + Arrays.toString(array));
        selectSort(array);
        System.out.println("选择排序：" + Arrays.toString(array));
        heapSort(array);
        System.out.println("堆排序：" + Arrays.toString(array));
    }
}
