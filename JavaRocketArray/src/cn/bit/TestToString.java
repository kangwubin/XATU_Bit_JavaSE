package cn.bit;

public class TestToString {
    //自己实现toString方法
    public static String toString(int[] array){
        String result = "[";
        for (int i = 0; i < array.length; i++) {
            result = result + array[i];
            if (i != array.length-1){
                result = result + ",";
            }
        }
        return result + "]";
    }
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6};
        System.out.println(toString(arr));
    }
}
