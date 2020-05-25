package 西安葡萄城笔试;

import java.util.Scanner;

/**
 * Description:题目描述： 杨辉三角是我国古代一个重要的数学成就 ;
 * 1. 每个数等于它上方两数之和。
 * 2. 每行数字左右对称，由1开始逐渐变大。第 n 行的数字有 n 项。
 * 3. 请编写一个程序，按题目要求输出杨辉三角中第 n 行第 m 个数字。
 * 4. 第一行，两个数字 n 和 m ，表示需要输出的数字在杨辉三角上的位置，行列均从 1 开始，（1<=n,m<=10000），以空格分隔。
 * 5. 仅包含一个整数，即杨辉三角中第 n 行第 m 列处的数字。
 *
 * @author: KangWuBin
 * @Date: 2020/3/18
 * @Time: 9:52
 */
public class YangHui {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        int m = Integer.parseInt(scanner.nextLine());
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.printf("%5.0f", w(i - 1, j - 1));
            }
            if (i != n) {
                System.out.println();
            }
        }
    }

    private static double w(int m, int n) {
        return (q(m) / (q(n) * q(m - n)));
    }

    private static double q(int b) {
        double ans = 1;
        for (int i = b; i > 0; i--) {
            ans = ans * i;
        }
        return ans;
    }
}
