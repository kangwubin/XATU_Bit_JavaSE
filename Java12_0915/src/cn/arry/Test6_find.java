package cn.arry;

//给定一个数组, 再给定一个元素, 找出该元素在数组中的位置.(顺序查找)
public class Test6_find {
    public static void main(String[] args){
        int[] arr={1,2,3,4,5,8};
        System.out.print(find(arr,8));
    }
    public static int find(int[] arr,int toFind){
        for (int i=0;i<arr.length;i++){
            if (arr[i] == toFind){
                return i;
            }
        }
        return -1;//表示没找到
    }
}
