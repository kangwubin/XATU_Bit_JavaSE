package cn.arry;

import java.util.Arrays;

//数组数字排列:给定一个整型数组, 将所有的偶数放在前半部分, 将所有的奇数放在数组后半部分
public class Test11_NumArrange {
    public static void main(String[] args) {
        int[] arr={1,2,3,4,5,6,7,8};
        NumArrange(arr);
        System.out.println(Arrays.toString(arr));
    }
    //设定两个下标分别指向第一个元素和最后一个元素.
    //用前一个下标从左往右找到第一个奇数, 用后一个下标从右往左找到第一个偶数, 然后交换两个位置的元素.
    public static void NumArrange(int[] arr){
        int left=0;
        int right=arr.length-1;
        while (left < right){
            // 该循环结束, left 就指向了一个偶数
            while (left < right && arr[left] % 2 == 0){
                left++;
//                System.out.println("奇数为："+arr[left]);
            }
            //
            while (left < right && arr[right] % 2 != 0){
                right--;
            }
            int tmp=arr[right];
            arr[right]=arr[left];
            arr[left]=tmp;

        }
    }
}
