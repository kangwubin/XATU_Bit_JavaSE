package SortDemo;

import java.util.Arrays;

/**
 * Description:
 *
 * @author: KangWuBin
 * @Date: 2019/12/2
 * @Time: 15:26
 */
public class MergeSort {
    public static void mergeSort(int[] array) {
        mergeSortHelp(array, 0, array.length - 1);
    }

    /*归并排序递归思路--找递归结束的条件--先分解(把整个数组一分为二)--再合并*/
    private static void mergeSortHelp(int[] array, int low, int high) {
        //递归结束的终止条件
        if (low == high) {
            return;
        }
        //将原有数组进行分解
        int mid = (low + high) / 2;
        mergeSortHelp(array, low, mid);
        mergeSortHelp(array, mid + 1, high);
        //合并数组
        merge(array, low, mid, high);
    }

    //合并数组
    private static void merge(int[] array, int low, int mid, int high) {
        //第一个归并段的开始
        int s1 = low;
        //第二个归并段的开始
        int s2 = mid + 1;
        //新数组的长度为原有数组的长度
        int len = high - low + 1;
        int[] tmp = new int[len];
        int tmpIndex = 0;
        //合并的条件
        while (s1 <= mid && s2 <= high) {
            if (array[s1] <= array[s2]) {
                tmp[tmpIndex++] = array[s1++];
            } else {
                tmp[tmpIndex++] = array[s2++];
            }
        }//这个循环结束的条件有两个，要么s1的数据没合并完，要么s2的数据没合并完
        while (s1 <= mid) {
            tmp[tmpIndex++] = array[s1++];
        }
        while (s2 <= high) {
            tmp[tmpIndex++] = array[s2++];
        }
        //合并操作，将tmp数组当中元素复制到array数组
        for (int i = 0; i < tmp.length; i++) {
            array[i + low] = tmp[i];
        }
    }

    public static void main(String[] args) {
        int[] array = {9, 5, 2, 7, 3, 6, 8, 1};
        mergeSort(array);
        System.out.println(Arrays.toString(array));
    }
}
