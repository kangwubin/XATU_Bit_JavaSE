package cn.arry;

//查找数组中指定元素（二分查找--常见面试题：前提是数组有序）
//以升序数组为例, 二分查找的思路是先取中间位置的元素, 看要找的值比中间元素大还是小.
// 如果小, 就去左边找; 否则就去右边找.

public class Test7_binarySearch {
    public static void main(String[] args){
        int[] arr={1,2,3,4,5,6};
        System.out.print(binarySearch(arr,4));
    }
    public static int binarySearch(int[] arr,int toFind){
        int left=0;
        int right=arr.length-1;
        while (left <= right){
            int mid=(left+right)/2;
            if (toFind < arr[mid]){
                //在左侧找
                right=mid-1;
            }else if (toFind > arr[mid]){
                //在右侧找
                left=mid+1;
            }else {
                return mid;
            }
        }
        return -1;//没有找到
    }
}
