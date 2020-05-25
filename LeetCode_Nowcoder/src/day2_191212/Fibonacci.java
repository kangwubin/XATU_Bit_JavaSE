package day2_191212;

import java.util.Scanner;

/**
 * Description:
 *
 * @author: KangWuBin
 * @Date: 2019/12/11
 * @Time: 9:29
 */
public class Fibonacci {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int first = 0;
        int second = 1;
        if (n == 1) {
            System.out.println("0");
            return;
        }
        while (true) {
            int tmp = first;
            first = second;
            second = tmp + second;
            if (n > first && n <= second) {
                int step = Math.min(n - first, second - n);
                System.out.println(step);
                return;
            }
        }
    }
}
