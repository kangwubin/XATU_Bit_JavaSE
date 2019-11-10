package cn.arry;
//检验二分查找的速度
public class Test7_makeArray {
    static int count=0;
    public static void main(String[] args) {
        int[] arr=makeBigArray();
        int result=binarySearch(arr,9999);
        System.out.println("result="+result+";count="+count);
    }
    //创建一个大数组
    public static int[] makeBigArray(){
        int[] arr=new int[10000];
        for (int i=0;i < arr.length;i++){
            arr[i]=i;
        }
        return arr;
    }
    //二分查找的算法实现
    public static int binarySearch(int[] arr,int toFind){
        int left = 0;
        int right = arr.length-1;
        while (left <= right){
            count++;    //记录循环执行次数
            int mid = (left + right)/2;
            if (toFind < arr[mid]){
                //在左侧找
                right = mid - 1;
            }else if (toFind > arr[mid]){
                //在右侧找
                left= mid + 1;
            }else {
                //相等，说明找到了
                return mid;
            }
        }
        return -1;   //表示没有找到
    }
}
