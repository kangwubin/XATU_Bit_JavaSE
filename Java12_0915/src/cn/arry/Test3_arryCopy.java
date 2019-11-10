package cn.arry;

import java.util.Arrays;

//数组拷贝
public class Test3_arryCopy {
    public static void main(String[] args){
        //调用自己完成的拷贝函数
        int[] arr={1,2,3,4,5,6};
        int[] newaArr=copy(arr);
        System.out.println(Arrays.toString(newaArr));
        //调用系统的数组拷贝
        int[] arr1={2,4,6,8};
        int[] newArr1=Arrays.copyOf(arr1,arr1.length);
        System.out.println(Arrays.toString(newArr1));
    }
    public static int[] copy(int[] arr){
        int[] result=new int[arr.length];
        for (int i=0;i<arr.length;i++){
            result[i]=arr[i];
        }
        return result;
    }
}
