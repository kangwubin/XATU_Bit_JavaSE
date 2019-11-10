package cn.Array;

import java.util.Arrays;
//逆序排序
public class Test1Reverse {
    //设定两个下标, 分别指向第一个元素和最后一个元素. 交换两个位置的元素.
    //然后让前一个下标自增, 后一个下标自减, 循环继续即可.
    public static void main(String[] args) {
        int[] arr={2,6,4,8};
        reverse(arr);
        System.out.println(Arrays.toString(arr));
    }
    //逆序方法
    public static void reverse(int[] arr){
        int left = 0;   //左下标
        int right = arr.length - 1;
        while (left < right){
            int tmp = arr[left];
            arr[left] = arr[right];
            arr[right] = tmp;
            left++;
            right--;
        }
    }
}
