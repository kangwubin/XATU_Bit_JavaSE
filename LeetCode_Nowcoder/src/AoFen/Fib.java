package AoFen;

import java.util.Scanner;

/**
 * Description:
 *
 * @author: KangWuBin
 * @Date: 2020/3/12
 * @Time: 10:03
 */
/*
 * 非递归版的斐波那契数*/
public class Fib {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            int res = fib(n);
            System.out.println(res);
        }
    }

    private static int fib(int x) {
        int last2 = 1;
        int last1 = 1;
        int current = 0;
        for (int i = 3; i <= x; i++) {
            current = last1 + last2;
            last2 = last1;
            last1 = current;
        }
        return current;
    }
}
