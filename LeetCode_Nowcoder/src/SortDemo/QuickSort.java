package SortDemo;

import java.util.Arrays;

/**
 * Description:
 *
 * @author: KangWuBin
 * @Date: 2019/12/2
 * @Time: 15:26
 */
public class QuickSort {
    //找基准值
    public static int partition(int[] array, int low, int high) {
        int tmp = array[low];
        while (low < high) {
            while (low < high && array[high] >= tmp) {
                high--;
            }
            array[low] = array[high];
            while (low < high && array[low] <= tmp) {
                low++;
            }
            array[high] = array[low];
        }
        array[low] = tmp;
        return low;
    }

    public static void quickSort(int[] array) {
        quick(array, 0, array.length - 1);
    }

    private static void quick(int[] array, int low, int high) {
        //对于par两边的值分别递归遍历
        int par = partition(array, low, high);
        if (par > low + 1) {
            quick(array, low, high);
        }
        if (par < high - 1) {
            quick(array, par + 1, high);
        }
    }

    public static void main(String[] args) {
        int[] array = {100,77,2,83,10,6,52,60};
        quickSort(array);
        System.out.println(Arrays.toString(array));
    }
}
