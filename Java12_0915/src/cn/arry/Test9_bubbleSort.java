package cn.arry;

import java.util.Arrays;

//给定一个数组, 让数组升序 (降序) 排序.
//冒泡排序：每次尝试找到当前待排序区间中最小(或最大)的元素, 放到数组最前面(或最后面).
public class Test9_bubbleSort {
    public static void main(String[] args){
        int[] arr={9,5,2,7};
        bubbleSort(arr);
        System.out.println(Arrays.toString(arr));
    }
    public static void bubbleSort(int[] arr){
        // [0, bound) 构成了一个前闭后开区间, 表示已排序区间
        // [bound, length) 构成了一个前闭后开区间, 表示待排序区间
        // 每循环一次, 就找到一个合适大小的元素, 已排序区间就增大1
        for (int bound=0;bound<arr.length;bound++){   //第一重循环：负责找N次
            for (int cur=arr.length-1;cur>bound;cur--){     //找到当前带排序区间中的最小值
                if (arr[cur-1]>arr[cur]){   //不符合顺序要求，交换
                    int tmp=arr[cur-1];
                    arr[cur-1]=arr[cur];
                    arr[cur]=tmp;
                }
            }
        }
    }
}
