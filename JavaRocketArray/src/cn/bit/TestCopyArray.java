package cn.bit;

import java.util.Arrays;

public class TestCopyArray {
    //实现自己版本的copyArray
    public static void copyArray(int[] array1,int[] array2){
        for (int i = 0; i < array1.length; i++) {
            array2[i] = array1[i];
        }
    }
    public static void main(String[] args) {
        int[] array1 = {1,2,3,4,5};
        int[] array2 = new int[array1.length];
        copyArray(array1,array2);
        System.out.println(Arrays.toString(array2));
    }
}
