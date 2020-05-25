package day13_191225;

import java.util.Scanner;

/**
 * Description:在屏幕上画一个正方形；
 * 输入：输入在一行中给出正方形边长N(3<=N<=20)和组成正方形边的某种字符c,间隔一个空格；
 * 输出：输出由给定字符c画出的正方形，但注意到行间距比例巨大，所以为了让结果看上去更像正方形；
 * 我们输出的行数实际上是列数的50%；
 *
 * @author: KangWuBin
 * @Date: 2019/12/25
 * @Time: 16:49
 */
public class Main1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int num = scanner.nextInt();
            String c = scanner.next();
            int row = num / 2;
            if (num % 2 != 0) {
                row = num / 2 + 1;
            }
            if (row == 2) {
                for (int i = 0; i < num; i++) {
                    System.out.print(c);
                }
                System.out.println();
                for (int i = 0; i < num; i++) {
                    System.out.print(c);
                }
            } else {
                for (int i = 0; i < num; i++) {
                    System.out.print(c);
                }
                System.out.println();
                for (int i = 0; i < row - 2; i++) {
                    System.out.print(c);
                    for (int j = 0; j < num - 2; j++) {
                        System.out.print(" ");
                    }
                    System.out.print(c);
                    System.out.println();
                }
                for (int i = 0; i < num; i++) {
                    System.out.print(c);
                }
            }
        }
    }
}
