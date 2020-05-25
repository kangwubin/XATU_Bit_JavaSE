package day26_200109;

import java.util.Scanner;

/**
 * Description:
 *
 * @author: KangWuBin
 * @Date: 2020/1/9
 * @Time: 21:24
 */
public class Main1 {
    /*对于给定的正整数 n，计算其十进制形式下所有位置数字之和，并计算其平方的各位数字之和。
     * 输入：每行输入数据包括一个正整数n(0<n<40000)；
     * 输出：对于每个输入数据，计算其各位数字之和，以及其平方值的数字之和，输出在一行中，之间用一个空格分隔，但行末不要有空格。*/
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int n1 = scanner.nextInt();
            int n2 = n1 * n1;
            System.out.print(add(n1));
            System.out.print(" " + add(n2));
        }
    }

    private static int add(int a) {
        int sum = 0;
        while (a != 0) {
            sum = sum + a % 10;
            a = a / 10;
        }
        return sum;
    }
}
