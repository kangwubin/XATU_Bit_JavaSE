package Test_191222;

import java.util.Scanner;

/**
 * Description:给定一个可能含有重复值的数组 arr，
 * 找到每一个 i 位置左边和右边离 i 位置最近且值比 arr[i] 小的位置。返回所有位置相应的信息。
 *
 * @author: KangWuBin
 * @Date: 2019/12/22
 * @Time: 9:22
 */
public class Main2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int input = sc.nextInt();
        int[] arr = new int[input];
        for (int i = 0; i < input; i++) {
            arr[i] = sc.nextInt();
        }
        int left;
        int right;
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < input; i++) {
            left = -1;
            right = -1;
            for (int j = i - 1; j > -1; j--) {
                if (arr[j] < arr[i]) {
                    left = j;
                    break;
                }
            }
            for (int j = i + 1; j < input; j++) {
                if (arr[j] < arr[i]) {
                    right = j;
                    break;
                }
            }
            stringBuffer.append(left + " " + right + "\n");
        }
        System.out.print(stringBuffer.toString());
    }
}

