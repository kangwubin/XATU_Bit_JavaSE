package Sort20191126;

import java.util.Arrays;
import java.util.Random;
import java.util.Stack;

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
    public static void insertSort1(int[] array) {
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

    /* 3.选择排序：每一次从无序区间选出最大（或最小）的一个元素，
     * 存放在无序区间的最后（或最前），直到全部待排序的数据元素排完。
     * 时间复杂度为;O(n^2)；
     * 排序稳定性：不稳定；
     * */
    public static void selectSort(int[] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = i + 1; j < array.length; j++) {
                if (array[j] < array[i]) {
                    int tmp = array[j];
                    array[j] = array[i];
                    array[i] = tmp;
                }
            }
        }
    }

    /*4.堆排序(+++++)：基本原理也是选择排序，只是不在使用遍历的方式查找无序区间的最大的数，
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
        //创建堆
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

    /*5.(1)冒泡排序(+++++)：在无序区间，通过相邻数的比较，
     *将最大的数冒泡到无序区间的最后，持续这个过程，直到数组整体有序。
     * (2)时间复杂度：O(n^2);
     * (3)空间复杂度：O(1);
     * (4)稳定排序；
     * (5)对于有序的情况下进行的比较的优化操作：
     * 例：1  2   3   4   5   6;设置一个标记，看是否发生交换。
     * */
    public static void bubbleSort(int[] array) {
        boolean flg = false;
        //i代表趟数
        for (int i = 0; i < array.length - 1; i++) {
            flg = false;
            //j代表数组的下标,array.length - 1  每一趟比较4次；
            // array.length - 1 - i，每趟比较的次数在减少
            for (int j = 0; j < array.length - 1 - i; j++) {
                if (array[j] > array[j + 1]) {
                    int tmp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = tmp;
                    flg = true; // 只要发生交换，就将flg置位true。
                }
            }
            //(!flg)--->flg为false,(!flg)为true，说明没有发生交换。
            if (!flg) {
                break;
            }
        }
    }

    /*6.快速排序:(1)从待排序区间选择一个数，作为基准值(pivot)，一般将0号下标的元素作为基准值；
     *(2)Partition: 遍历整个待排序区间，将比基准值小的（可以包含相等的）放到基准值的左边，
     * 将比基准值大的（可以包含相等的）放到基准值的右边；
     *(3)采用分治思想，对左右两个小区间按照同样的方式处理，直到小区间的长度 == 1，代表已经有序，
     * 或者小区间的长度 == 0，代表没有数据*;
     * (4)时间复杂度：O(n * log(n))；
     * (5)空间复杂度：O(log(n))；
     * (6)最坏情况：有序的时候--O(n^2)*/
    public static int partition(int[] array, int low, int high) {
        int tmp = array[low];
        while (low < high) {
            while (low < high && array[high] >= tmp) {
                high--;
            }
            array[low] = array[high];
          /*  if (low >= high) {
                break;
            } else {
                array[low] = array[high];
            }*/

            while (low < high && array[low] <= tmp) {
                low++;
            }
            /*if (low >= high) {
                break;
            } else {
                array[high] = array[low];
            }*/
            array[high] = array[low];
        }
        array[low] = tmp;
        return low;
    }

    public static void quick(int[] array, int low, int high) {
        //第二步优化：对于有限数据的优化
        if (high - low + 1 <= 100) {
            insertSort(array, low, high);
            return;
        }
        //第一步优化：采用三数取中法对快排进行优化
        threeNumMid(array, low, high);
        int par = partition(array, low, high);
//        System.out.println("low:" + low + ";high:" + high);
        //1.左边有两个以上的数据
        if (par > low + 1) {
            quick(array, low, par - 1);
        }
        //2.右边有两个以上的数据
        if (par < high - 1) {
            quick(array, par + 1, high);
        }
    }

    public static void quickSort(int[] array) {
        quick(array, 0, array.length - 1);
    }

    //===========================分割线上面为快速排序========================================
    //交换函数
    public static void swap(int[] array, int i, int j) {
        int tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
    }

    //快排的优化操作：--因为待排序可能在某一趟之后是有序的.--->三数取中法
    //三个数中找中位数
    public static void threeNumMid(int[] array, int low, int high) {
        //array[low]   array[high]    array[mid]
        //array[mid] <= array[low] <= array[high]
        int mid = (low + high) / 2;
        if (array[mid] > array[low]) {
            swap(array, low, mid);  //  7   2     5
        }
        if (array[mid] > array[high]) {
            swap(array, high, mid); //  5   2    7
        }
        if (array[low] > array[high]) {
            swap(array, low, high); // 5   2    7
        }
    }

    public static void insertSort(int[] array, int low, int high) {
        for (int i = low + 1; i <= high; i++) {
            int tmp = array[i];
            int j = i - 1;
            for (; j >= low; j--) {
                //如果加== 他就是一个不稳定的排序
                if (array[j] > tmp) {
                    array[j + 1] = array[j];
                } else {
                    break;
                }
            }
            array[j + 1] = tmp;
        }
    }

    /*7.非递归版的快排---思想：使用栈；*/
    public static void quickSort1(int[] array) {
        Stack<Integer> stack = new Stack<>();
        int low = 0;
        int high = array.length - 1;
        int par = partition(array, low, high);
        if (par > low + 1) {
            stack.push(low);
            stack.push(par - 1);
        }
        if (par < high - 1) {
            stack.push(par + 1);
            stack.push(high);
        }
        while (!stack.isEmpty()) {
            //1.取出数对
            high = stack.pop();
            low = stack.pop();
            //2.找par
            par = partition(array, low, high);
            if (par > low + 1) {
                stack.push(low);
                stack.push(par - 1);
            }
            if (par < high - 1) {
                stack.push(par + 1);
                stack.push(high);
            }
        }
    }

    //检测快排的优化
    public static void main1(String[] args) {
        Random random = new Random();
        int[] array = new int[10000];
        for (int i = 0; i < array.length; i++) {
            array[i] = random.nextInt(10000);
        }
        //计算时间
        long time1 = System.currentTimeMillis();
        quickSort(array);
        long time2 = System.currentTimeMillis();
        System.out.println(time2 - time1);
        System.out.println(Arrays.toString(array));
    }

    public static void main(String[] args) {
        int[] array = {8, 9, 4, 10, 7, 11, 12, 13, 16};
        insertSort1(array);
        System.out.println("直接插入排序：" + Arrays.toString(array));
        shellSort(array);
        System.out.println("希尔排序：" + Arrays.toString(array));
        selectSort(array);
        System.out.println("选择排序：" + Arrays.toString(array));
        heapSort(array);
        System.out.println("堆排序：" + Arrays.toString(array));
        bubbleSort(array);
        System.out.println("冒泡排序：" + Arrays.toString(array));
        quickSort(array);
        System.out.println("递归快速排序：" + Arrays.toString(array));
        quickSort1(array);
        System.out.println("非递归快速排序：" + Arrays.toString(array));
    }
}
