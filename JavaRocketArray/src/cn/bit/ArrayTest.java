package cn.bit;

public class ArrayTest {
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
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6};
        printArray(arr);
        transform(arr);
    }
}
