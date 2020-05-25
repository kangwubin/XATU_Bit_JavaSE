package day17_191229;

import java.util.Scanner;

/**
 * Description:给定一个正整数N代表火车数量，0<N<10,接下来输入火车站的序列，一共N辆火车，
 * 每辆火车以数字1-9编号。要以字典序排序输出火车站的序列号；
 *
 * @author: KangWuBin
 * @Date: 2019/12/29
 * @Time: 21:48
 */
public class Main1 {    //此题恐怖
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int input = scanner.nextInt();
        int[] arr = new int[input];
        for (int i = 0; i < input; i++) {
            arr[i] = scanner.nextInt();
        }

    }
}
