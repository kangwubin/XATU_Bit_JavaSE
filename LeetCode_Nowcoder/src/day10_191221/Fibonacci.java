package day10_191221;

import java.util.Scanner;

/**
 * Description:Fibonacci数是这样定义的：F[0]=0,F[1]=1,for each i>=2:F[i] = F[i-1]+F[i-2];
 * 因此，Fibonacci数列就形如：0，1,1，2,3,5,8,13，....;在Fibonacci数列中的数我们成为Fibonacci数；
 * 给你一个N，你想让其变成一个Fibonacci数，每一步你可以把当前数字X变为X-1或者X+1；
 * 现在给你一个数N求最少需要多少步可以变为Fibonacci数；
 *
 * @author: KangWuBin
 * @Date: 2019/12/20
 * @Time: 22:00
 */
public class Fibonacci {
    /* 解题思路：1.先计算N的 Fibonacci 值；*/
    private static int fib(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1 || n == 2) {
            return 1;
        }
        return fib(n - 1) + fib(n - 2);
    }

    /* 2.用 flg1与 flg2作为和给定值X比较的两边的值；
     * 3.给定一个死循环，用i变量的值来计算i每次(+1)后的 Fibonacci 值；
     * 4.如果fib(i)的值大于给定x的值，则让 flg2 = fib(i);
     * 5.如果fib(i)的值小于给定x的值，就让 flg1 = flg2 ,每次更新 flg1 的值；
     * 6.最后给定 x 与 flg1 做差的值与 flg2 与给定 x 做差的值比较，谁小返回谁； */
    private static int func(int x) {
        int left = 0;
        int right = 0;
        for (int i = 0; ; i++) {
            right = fib(i);
            if (right > x) {
                break;
            }
            left = right;
        }
        return x - left < right - x ? x - left : right - x;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int input = scanner.nextInt();
            int ret = func(input);
            System.out.println(ret);
        }
    }
}
