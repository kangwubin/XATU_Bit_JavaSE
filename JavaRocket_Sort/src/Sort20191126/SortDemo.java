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
     * 空间复杂度：O(1);
     * 注意：越有序排序速度越快；
     * 稳定性：稳定排序；
     * 2.两个重要特点：
     *(1)如果当前这个序列很短，那么插入排序很高效；
     *(2)如果当前这个序列，基本有序，那么插入排序效率也很高.*/
    public static void insertSort1(int[] array) {
        // bound 变量来把整个数组分成两个区间
        // [0, bound) 已排序区间
        // [bound, size) 待排序区间
        for (int bound = 1; bound < array.length; bound++) {
            // bound 下标对应的元素就是待插入元素.
            // 把这个元素放到前面的有序顺序表中的合适位置
            int tmp = array[bound];
            int cur = bound - 1;
            //cur--从后往前循环，每次往前走一步
            //>=才能满足将元素放在0号下标。
            for (; cur >= 0; cur--) {
                //如果array[cur] >= tmp，就是不稳定排序.
                if (array[cur] > tmp) {
                    //搬运元素
                    array[cur + 1] = array[cur];
                } else {
                    break;
                }
            }
            array[cur + 1] = tmp;
        }
    }

    /*
     * 2.希尔排序：希尔排序法的基本思想是：先选定一个整数，把待排序文件中所有记录分成个组，
     * 所有距离为的记录分在同一组内，并对每一组内的记录进行排序。
     * 然后取重复上述分组和排序的工作。当到达=1时，所有记录在统一组内排好序
     * 最坏情况下：时间复杂度O(n^1.5);
     * 最好情况下：时间复杂度O(n);
     * 稳定性：不稳定；
     * 空间复杂度：O(1);*/
    public static void shellSort(int[] array) {
        //计算增量的经典算法
        int gap = array.length;
        while (gap > 1) {
            shell(array, gap);
            gap = gap / 2;
        }
        shell(array, 1);
    }

    //gap->组数  进行组内直接插入排序
    private static void shell(int[] array, int gap) {
        for (int bound = 1; bound < array.length; bound++) {
            int tmp = array[bound];
            int cur = bound - gap;
            // 同组之内的相邻元素之间下标差了 gap
            for (; cur >= 0; cur -= gap) {
                if (array[cur] > tmp) {
                    array[cur + gap] = array[cur];
                } else {
                    break;
                }
            }
            array[cur + gap] = tmp;
        }
    }

    /* 3.选择排序：每一次从无序区间选出最大（或最小）的一个元素，
     * 存放在无序区间的最后（或最前），直到全部待排序的数据元素排完。
     * 时间复杂度为;O(n^2)；
     * 排序稳定性：不稳定；
     * 空间复杂度：O(1);
     * */
    public static void selectSort(int[] array) {
        // [0, bound) 已排序区间
        // [bound, size) 待排序区间
        for (int bound = 0; bound < array.length; bound++) {
            //使用打擂台的方式找到待排序区间中的最小值
            //bound位置的元素就是擂台。
            for (int cur = bound + 1; cur < array.length; cur++) {
                if (array[cur] < array[bound]) {
                    int tmp = array[cur];
                    array[cur] = array[bound];
                    array[bound] = tmp;
                }
            }
        }
    }

    /*4.堆排序(+++++)：基本原理也是选择排序，只是不在使用遍历的方式查找无序区间的最大的数，
     *而是通过堆来选择无序区间的最大的数；
     *注意：排升序要建大堆；排降序要建小堆；
     *时间复杂度：O(n * log(n))；
     *空间复杂度：O(1);
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
                //建立大堆
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

    //堆排序
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
            // 第一个参数是数组
            // 第二个参数是从哪个位置进行向下调整
            // 第三个参数是数组中的有效元素的个数
            adjustDown(array, 0, end);
            end--;
        }
    }

    /*5.(1)冒泡排序(+++++)：一种交换排序，思想是两两比较相邻记录的关键字，如果反序则交换，直到没有反序记录为止.
     *在无序区间，通过相邻数的比较，将最大的数冒泡到无序区间的最后，持续这个过程，直到数组整体有序。
     * (2)时间复杂度：O(n^2);
     * (3)空间复杂度：O(1);
     * (4)稳定排序；
     * (5)对于有序的情况下进行的比较的优化操作：
     * 例：1  2   3   4   5   6;设置一个标记(flg)，看是否发生交换。
     * */
    public static void bubbleSort(int[] array) {
        boolean flg = false;
        //i代表趟数
        for (int i = 0; i < array.length - 1; i++) {
            //j代表数组的下标，每次都从0开始,array.length - 1  每一趟比较4次；
            // array.length - 1 - i，每趟比较的次数在减少.(已经优化.)
            for (int j = 0; j < array.length - 1 - i; j++) {
                //相邻元素进行比较
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
    //partition函数用于第一次划分，将整个数组划分为2段.
    public static int partition(int[] array, int low, int high) {
        //取基准值，在赋值的时候不用care基准值在哪，tmp已经记录了基准值.
        int tmp = array[low];
        while (low < high) {
            while (low < high && array[high] >= tmp) {
                high--;
            }
            array[low] = array[high];
          /*  if (low >= high) {
                array[low] = tmp;
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
        //high和low相遇时，将tmp的值给low.
        array[low] = tmp;
        return low;
    }

    //用于实现递归调用的函数.
    public static void quick(int[] array, int low, int high) {
        //第二步优化：对于有限数据的优化
        if (high - low + 1 <= 100) {
            insertSort(array, low, high);
            return;
        }
        //第一步优化：采用三数取中法对快排进行优化
        threeNumMid(array, low, high);
        //par--通过找基准值的方式将数组分为2段.
        int par = partition(array, low, high);
//        System.out.println("low:" + low + ";high:" + high);
        //1.左边有两个以上的数据；因为 low = 0；
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

    //快排优化：如果需要排序的数字已经比较有序，则用直接插入排序可以优化快速排序.
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

    /*6.2.非递归版的快排(+++++)---思想：使用栈；*/
    public static void quickSort1(int[] array) {
        Stack<Integer> stack = new Stack<>();
        int low = 0;
        int high = array.length - 1;
        int par = partition(array, low, high);
        //1.左边有两个以上的数据；因为 low = 0；
        if (par > low + 1) {
            stack.push(low);
            stack.push(par - 1);
        }
        //2.右边有两个以上的数据
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

    /*7.递归归并排序：将已有序的子序列合并，得到完全有序的序列；
     *即先使每个子序列有序，再使子序列段间有序。
     *若将两个有序表合并成一个有序表，称为二路归并.*/
    public static void mergeSort(int[] array) {
        mergeSortHelp(array, 0, array.length - 1);
    }

    private static void mergeSortHelp(int[] array, int low, int high) {
        //递归的终止条件
        if (low == high) {
            return;
        }
        // 使用类似后序遍历的方式.
        // 先把当前的待排序区间拆成两半,
        // 递归的对这两个子区间进行归并排序, 保证两个区间有序之后
        // 再进行合并
        int mid = (low + high) / 2;
        mergeSortHelp(array, low, mid);
        mergeSortHelp(array, mid + 1, high);
        //合并
        merge(array, low, mid, high);
    }

    //合并数组
    private static void merge(int[] array, int low, int mid, int high) {
        //s1第一个归并段的开始，s2第二个归并段的开始
        int s1 = low;
        int s2 = mid + 1;
        //数组长度
        int len = high - low + 1;
        // 创建一段临时空间辅助进行归并
        // 这个临时空间的长度应该是两个待归并区间的长度之和
        int[] tmp = new int[len];
        // 这个变量保存着当前 tmpIndex 中的末尾元素的下标
        int tmpIndex = 0;
        while (s1 <= mid && s2 <= high) {
            //array[s1] < array[s2]就是不稳定的排序
            if (array[s1] <= array[s2]) {
                tmp[tmpIndex] = array[s1];
                tmpIndex++;
                s1++;
            } else {
                tmp[tmpIndex] = array[s2];
                tmpIndex++;
                s2++;
            }
        }
        // 上面的循环结束之后, 两个区间至少有一个是遍历完了的.
        // 就把剩下的区间的内容直接拷贝到 output 中即可.
        while (s1 <= mid) {
            tmp[tmpIndex] = array[s1];
            tmpIndex++;
            s1++;
        }
        while (s2 <= high) {
            tmp[tmpIndex] = array[s2];
            tmpIndex++;
            s2++;
        }
        //合并---最后一步, 把 tmp 中的元素拷贝回原来的区间
        for (int j = 0; j < tmp.length; j++) {
            array[low + j] = tmp[j];
        }
    }

    /*7.2非递归版的归并排序.*/
    public static void mergeSort1(int[] array) {
        //gap--表示一组有几个数据
        for (int gap = 1; gap < array.length; gap *= 2) {
            merge1(array, gap);
        }
    }

    private static void merge1(int[] array, int gap) {
        int[] tmp = new int[array.length];
        //记录tmp数组的下标位置
        int tmpIndex = 0;
        int s1 = 0;
        int e1 = s1 + gap - 1;
        int s2 = e1 + 1;
        int e2 = s2 + gap - 1 >=
                array.length ? array.length - 1 : s2 + gap - 1;
        //当有两个归并段的时候
        while (s2 < array.length) {
            while (s1 <= e1 && s2 <= e2) {
                if (array[s1] <= array[s2]) {
                    tmp[tmpIndex++] = array[s1++];
                } else {
                    tmp[tmpIndex++] = array[s2++];
                }
            }
            while (s1 <= e1) {
                tmp[tmpIndex++] = array[s1++];
            }
            while (s2 <= e2) {
                tmp[tmpIndex++] = array[s2++];
            }
            //重新确定s1  e1  s2  e2 的位置
            s1 = e2 + 1;
            e1 = s1 + gap - 1;
            s2 = e1 + 1;
            e2 = s2 + gap - 1 >=
                    array.length ? array.length - 1 : s2 + gap - 1;
        }
        //判断s1是否有数据-》上面第一个循环进不来
        while (s1 <= array.length - 1) {
            tmp[tmpIndex++] = array[s1++];
        }
        //拷贝tmp到array
        for (int j = 0; j < tmp.length; j++) {
            array[j] = tmp[j];
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
        int[] array = {9, 5, 2, 7, 3, 6, 8, 1};
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
        mergeSort(array);
        System.out.println("递归版归并排序：" + Arrays.toString(array));
        mergeSort1(array);
        System.out.println("非递归版归并排序：" + Arrays.toString(array));
    }
}
