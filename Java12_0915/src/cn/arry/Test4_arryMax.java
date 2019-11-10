package cn.arry;

//给定一个整型数组, 找到其中的最大元素 (找最小元素同理)
public class Test4_arryMax {
    public static void main(String[] args){
        int[] arr={1,2,3,4,5,6};
        System.out.print(max(arr));
    }
    public static int max(int[] arr){
        int max=arr[0];
        for (int i=0;i<arr.length;i++) {
            if (arr[i] > max) {
                max=arr[i];
            }
        }
        return max;
    }
}
