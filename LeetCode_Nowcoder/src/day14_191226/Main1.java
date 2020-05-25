package day14_191226;

import java.util.Scanner;

/**
 * Description:给定数字0-9若干个。你可以任意顺序排列这些数字，但必须全部使用。
 * 目标是使得最后得到的数尽可能小(注意0不能做首位);
 *
 * @author: KangWuBin
 * @Date: 2019/12/26
 * @Time: 23:29
 */
public class Main1 {
    public static void main(String[] args) {
        /* 思路：利用数组a[0],..a[9]储存0...9数字出现的次数；
         * 首先组成的数字首位不能为零，同时要求数字最小，即输出最小的非零数，同时将该数的次数减一
         * 输出所有的“0”。
         * 从1开始从小到大按其次数输出所有数字；
         * 输入：2 2 0 0 0 3 0 0 1 0；
         * 输出：10015558*/
        Scanner scanner = new Scanner(System.in);
        int[] num = new int[10];
        //读取数字0-9的个数
        for (int i = 0; i < num.length; i++) {
            num[i] = scanner.nextInt();
        }
        //输出0除外的最小的数字
        for (int i = 1; i < num.length; i++) {
            if (num[i] != 0) {
                System.out.print(i);
                num[i]--;
                break;
            }
        }
        //从小到大从0开始输出
        for (int i = 0; i < num.length; i++) {
            while (num[i] > 0) {
                System.out.print(i);
                num[i]--;
            }
        }
        System.out.println();
    }
}
