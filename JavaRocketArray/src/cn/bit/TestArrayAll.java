package cn.bit;

import java.util.Arrays;

public class TestArrayAll {
    //写一个方法, 将数组中的每个元素都 * 2
    public static void printArray(int[] array){
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i]+" ");
        }
        System.out.println();
    }
    public static void transform(int[] arr){
        for (int i = 0; i < arr.length; i++) {
            arr[i] = arr[i] * 2;
            System.out.print(arr[i]+" ");
        }
    }

    //实现自己版本的copyArray
    public static void copyArray(int[] array1,int[] array2){
        for (int i = 0; i < array1.length; i++) {
            array2[i] = array1[i];
        }
    }

    //自己实现toString方法
    public static String toString(int[] array){
        String result = "[";
        for (int i = 0; i < array.length; i++) {
            result = result + array[i];
            if (i != array.length-1){
                result = result + ",";
            }
        }
        return result + "]";
    }

    //给定一个整型数组, 找到其中的最大元素
    public static int maxNum(int[] array){
        int max = array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i] > max){
                max = array[i];
            }
        }
        return max;
    }

    //给定一个整型数组, 找最小元素
    public static int minNum(int[] array1){
        int min = array1[0];
        for (int i = 1; i < array1.length; i++) {
            if (array1[i] < min){
                min = array1[i];
            }
        }
        return min;
    }

    //给定一个整型数组, 求平均值
    public static double average(int[] array2){
        double avg = 0.0;
        int sum = 0;
        for (int i = 0; i < array2.length; i++) {
            sum += array2[i];
        }
        avg = (double) sum / (double) array2.length;
        return avg;
    }
    //for-each求数组的平均值
    public static double avg(int[] arr) {
        int sum = 0;
        for (int x : arr) {
            sum += x;
        }
        return (double)sum / (double)arr.length;
    }

    //数组的逆置
    public static void reverse(int[] array3){
       int left = 0;
       int right = array3.length - 1;
       while (left < right){
        int tmp = array3[left];
        array3[left] = array3[right];
        array3[right] = tmp;
        left++;
        right--;
       }
    }

    //将数组中的所有奇数放在偶数后面
    public static void transformJO(int[] array4){
        int left = 0;
        int right = array4.length - 1;
        while (left != right){
            while (left < right && array4[left] % 2 == 0){
                left++;
            }   //碰到奇数
            while (left < right && array4[right] % 2 != 0){
               right--;
            }   //碰到偶数
            //交换
            if (left != right){
                int tmp = array4[left];
                array4[left] = array4[right];
                array4[right] = tmp;
            }
        }
    }

    //查找数组中指定元素(二分查找)
    public static int binarySearch(int[] array, int toFind){
        int left = 0;
        int right = array.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (toFind < array[mid]) {
            // 去左侧区间找
                right = mid - 1;
            } else if (toFind > array[mid]) {
            // 去右侧区间找
                left = mid + 1;
            } else {
            // 相等, 说明找到了
                return mid;
            }
        }
        // 循环结束, 说明没找到
        return -1;
    }
    //递归实现二分查找
    public static int binarySearch2(int[] array,int left,int right,int key){
        if(left > right) {
            return -1;
        }
        int mid = (left+right)/2;
        if(array[mid] == key) {
            return mid;
        }else if(array[mid] > key){
            right = mid-1;
            return binarySearch2(array,left,right,key);
        }else {
            left = mid+1;
            return binarySearch2(array,left,right,key);
        }
    }

    //冒泡排序
    public static void bubbleSort1(int[] array5){
        //趟数
        for (int i = 0; i < array5.length; i++) {
            //每一趟的次数
            for (int current = array5.length-1; current > i;current--){
                if (array5[current - 1] > array5[current]){
                    int tmp = array5[current - 1];
                    array5[current - 1] = array5[current];
                    array5[current] = tmp;
                }
            }
        }
    }
    //冒泡排序优化
    public static void bubbleSort(int[] array5){
        boolean flg = false;
        //趟数
        for (int i = 0; i < array5.length; i++) {
            flg = false;
            //每一趟的次数
            for (int current = array5.length-1; current > i;current--){
                if (array5[current - 1] > array5[current]){
                    int tmp = array5[current - 1];
                    array5[current - 1] = array5[current];
                    array5[current] = tmp;
                    flg = true;
                }
            }
            if (!flg){         //flg = false;
                break;
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7,8,9};
        printArray(arr);
//        transform(arr);
        int[] arr2 = new int[arr.length];
        copyArray(arr,arr2);
        System.out.println("copyArray的arr给arr2:" + Arrays.toString(arr2));
        System.out.println("实现toString:" + toString(arr));
        System.out.println("最大值：" + maxNum(arr));
        System.out.println("最小值：" + minNum(arr));
        System.out.println("平均值：" + average(arr));
        System.out.println("平均值：" + avg(arr));
        reverse(arr);
        System.out.println("数组逆置：" + Arrays.toString(arr));
        transformJO(arr);
        System.out.println("偶数在前奇数在后：" + Arrays.toString(arr));
        System.out.println("二分查找：" + binarySearch(arr,4));
        System.out.println("java源代码二分查找：" + Arrays.binarySearch(arr,4));
        System.out.println(Arrays.binarySearch(arr,2,6,7));
        System.out.println("递归实现二分查找："+binarySearch2(arr,0,arr.length-1,7));
        bubbleSort(arr);
        System.out.println("冒泡排序：" + Arrays.toString(arr));
    }
}
