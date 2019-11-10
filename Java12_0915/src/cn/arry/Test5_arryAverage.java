package cn.arry;

//求数组中元素的平均值
public class Test5_arryAverage {
    public static void main(String[] args){
        int[] arr={1,2,3,4,5,6};
        System.out.print(average(arr));
    }
    public static double average(int[] arr){
        int add=0;
        for (int x : arr
             ) {
            add+=x;
        }
        return add / arr.length;
    }
}
