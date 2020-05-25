package AoFen;

/**
 * Description:
 *
 * @author: KangWuBin
 * @Date: 2020/3/12
 * @Time: 10:13
 */
/*
 * 合并两个有序数组*/
public class Test2 {
    public static void main(String[] args) {
        int[] arr1 = {1, 3, 5, 7, 9};
        int[] arr2 = {0, 2, 4, 6, 8};
        merge(arr1, arr1.length, arr2, arr2.length);
    }

    private static void merge(int[] arr1, int length1, int[] arr2, int length2) {
        int[] newArray = new int[length1 + length2];
        int i = 0;
        int j = 0;
        int count = 0;
        while (i < length1 && j < length2) {
            if (arr1[i] < arr2[j]) {
                newArray[count++] = arr1[i++];
            } else {
                newArray[count++] = arr2[j++];
            }
        }
        if (i >= length1) {
            while (j < length2) {
                newArray[count++] = arr2[j++];
            }
        }
        if (j <= length2) {
            while (i < length1) {
                newArray[count++] = arr1[i++];
            }
        }
        for (int k = 0; k < newArray.length; k++) {
            System.out.print(newArray[k] + " ");
        }
    }
}
