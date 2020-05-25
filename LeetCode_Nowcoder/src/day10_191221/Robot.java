package day10_191221;

import java.util.Scanner;

/**
 * Description:有一个X * Y的网格，一个机器人只能走格点且只能向右或向下走，要从左上角走到右下角；
 * 请设计一个算法，计算机器人有多少种走法；
 * 给定两个整型数int x,int y,请返回机器人的走法数目。保证x+y<=12;
 * 测试样例，输入2,2;返回2；
 *
 * @author: KangWuBin
 * @Date: 2019/12/20
 * @Time: 22:54
 */
public class Robot {
    private static int countWays(int x, int y) {
        /* 思路：每一步都只能往下或者右走，所以每一步都只有两个方法，所以用递归很方便；
         * 而且题目上约束x+y<=12，不必担心递归的深度。
         * 递归的结束条件，就是当他走的只剩一行或一列时就只有一种方法可走，此时返回1；
         * 其余的时候不是往下走，就是往右走，因此递归（x-1,y）和（x，y-1）就可以。*/
        if (x == 1 || y == 1) {
            return 1;
        }
        return countWays(x - 1, y) + countWays(x, y - 1);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int input1 = scanner.nextInt();
            int input2 = scanner.nextInt();
            int ret = countWays(input1, input2);
            System.out.println(ret);
        }
    }
}
