package cn.arry;

import java.util.Arrays;
//数组转字符串:int[] arr={1,2,3,4,5,6}-->[1,2,3,4,5,6];
public class Test2_arry {
    public static void main(String[] args){
        int[] arr={1,2,3,4,5,6};
        int[] arr1={7,8,9,10,11};
        String newArr=Arrays.toString(arr);
        System.out.println("调用系统进行转换：newArr="+newArr);
        String newArr1=toString1(arr1);
        System.out.println("自己实现的转换：newArr1="+newArr1);
    }
    //自己实现数组转字符串
    public static String toString1(int[] arr){
        String result="[";
        for (int i = 0; i < arr.length; i++) {
            // 借助 String += 进行拼接字符串
            result += arr[i];
            //
            if (i != arr.length - 1){
                result +=",";
            }
        }
        result +="]";
        return result;
    }
}
