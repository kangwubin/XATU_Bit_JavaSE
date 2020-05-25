package NowCoder_Array;

import java.util.Arrays;

/**
 * Description:输入一个无序整数数组，调整数组中数字的顺序， 所有偶数位于数组的前半部分，
 * 使得所有奇数位于数组的后半部分。要求时间复杂度为O(n)。
 *
 * @author: KangWuBin
 * @Date: 2019/11/14
 * @Time: 22:41
 */
public class ArrayParity {
    public static void reOrderArray(int[] array) {
        if (array == null || array.length == 0) {
            return;
        }
        int[] tmp = new int[array.length];
        int index = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] % 2 == 1) {
                tmp[index] = array[i];
                index++;
            }
        }
        for (int i = 0; i < array.length; i++) {
            if (array[i] % 2 == 0) {
                tmp[index] = array[i];
                index++;
            }
        }
        //array=tmp
        for (int i = 0; i < tmp.length; i++) {
            array[i] = tmp[i];
        }
    }

    public static void main(String[] args) {
        int[] arr = {9, 5, 2, 7, 3, 6, 8, 4, 1};
        reOrderArray(arr);
        System.out.println(Arrays.toString(arr));   //[9, 5, 7, 3, 1, 2, 6, 8, 4]
    }
}
