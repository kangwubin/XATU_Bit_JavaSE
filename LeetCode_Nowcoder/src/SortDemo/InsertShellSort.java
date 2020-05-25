package SortDemo;

import java.util.Arrays;

/**
 * Description:
 *
 * @author: KangWuBin
 * @Date: 2019/11/27
 * @Time: 9:07
 */
public class InsertShellSort {
    //直接插入排序
    public static void insertSort(int[] array) {
        for (int i = 1; i < array.length; i++) {
            int tmp = array[i];
            for (int j = i - 1; j >= 0; j--) {
                if (array[j] > tmp) {

                }
            }
        }
    }

    //希尔排序

    public static void main(String[] args) {
        int[] array = {9, 5, 2, 7, 3, 6, 8, 1};
        System.out.println("选择排序：" + Arrays.toString(array));
    }
}
