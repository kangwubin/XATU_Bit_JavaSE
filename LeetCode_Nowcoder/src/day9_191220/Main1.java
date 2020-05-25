package day9_191220;

import java.util.Scanner;

/**
 * Description:
 *
 * @author: KangWuBin
 * @Date: 2019/12/20
 * @Time: 18:29
 */
public class Main1 {
    /* 输入一个正整数n,求n!(即阶乘)末尾有多少个0？
     * 比如：n = 10;n! = 3628800,所以答案为2；*/
    private static long func(long n) {
        if (n == 1) {
            return 1;
        }
        return n * func(n - 1);
    }

    private static long func2(long x) {
        long ret = func(x);
        String s = ret + "";
        int len = s.length();
        int count = 0;
        for (int i = 0; i < len; i++) {
            char c = s.charAt(len - 1 - i);
            if (c != '0') {
                break;
            } else {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int input = scanner.nextInt();
            long num = func2(input);
            System.out.print(num);
        }
    }
}
