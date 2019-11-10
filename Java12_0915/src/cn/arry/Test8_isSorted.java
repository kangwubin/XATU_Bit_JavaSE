package cn.arry;
//给定一个整型数组, 判断是否该数组是有序的(升序)
public class Test8_isSorted {
    public static void main(String[] args){
        int[] arr={1,2,3,4};
        System.out.println(isSorted(arr));
        int[] arr1={9,5,2,7};
        System.out.println(isSorted(arr1));
    }
    //实现判断方法
    public static boolean isSorted(int[] arr){
        for (int i=0;i < arr.length-1;i++){
            if (arr[i] > arr[i+1]){
                return false;
            }
        }
        return true;
    }
}
