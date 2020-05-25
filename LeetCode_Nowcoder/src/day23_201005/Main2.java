package day23_201005;

import java.util.Scanner;

/**
 * Description:
 *
 * @author: KangWuBin
 * @Date: 2020/1/5
 * @Time: 20:37
 */
public class Main2 {
    /* 给定一系列正整数，请按要求对数字进行分类，并输出以下5个数字：
     * A1 = 能被5整除的数字中所有偶数的和；
     * A2 = 将被5除后余1的数字按给出顺序进行交错求和，即计算n1-n2+n3-n4...；
     * A3 = 被5除后余2的数字的个数；
     * A4 = 被5除后余3的数字的平均数，精确到小数点后1位；
     * A5 = 被5除后余4的数字中最大数字
     * 输入：每个输入包含1个测试用例。每个测试用例先给出一个不超过1000的正整数N，
     * 随后给出N个不超过1000的待分类的正整数。数字间以空格分隔。
     * 输出：对给定的N个正整数，按题目要求计算A1~A5并在一行中顺序输出。数字间以空格分隔，但行末不得有多余空格。
     * 若其中某一类数字不存在，则在相应位置输出“N”。
     * */
    //输入：13 1 2 3 4 5 6 7 8 9 10 20 16 18；
    //输出：30  11  2  9.7  9；
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            int[] num = new int[n]; //n个整数
            int A1 = 0, A2 = 0, A3 = 0, A4 = 0, A5 = 0;
            int flg = 1;
            int count = 0;
            for (int i = 0; i < n; i++) {
                num[i] = scanner.nextInt();
                //A1 = 能被5整除的数字中所有偶数的和；
                if (num[i] % 5 == 0) {
                    if (num[i] % 2 == 0) {
                        A1 = A1 + num[i];
                    }
                }
                //A2 = 将被5除后余1的数字按给出顺序进行交错求和，即计算n1-n2+n3-n4...；
                if (num[i] % 5 == 1) {
                    A2 = A2 + flg * num[i];
                    flg = -flg;
                }
                //A3 = 被5除后余2的数字的个数；
                if (num[i] % 5 == 2) {
                    A3++;
                }
                //A4 = 被5除后余3的数字的平均数，精确到小数点后1位；
                if (num[i] % 5 == 3) {
                    A4 = A4 + num[i];
                    count++;
                }
                //A5 = 被5除后余4的数字中最大数字
                if (num[i] % 5 == 4) {
                    if (num[i] > A5) {
                        A5 = num[i];
                    }
                }
            }
            if (A1 != 0) {
                System.out.print(A1 + " ");
            } else {
                System.out.print("N" + " ");
            }
            if (A2 != 0) {
                System.out.print(A2 + " ");
            } else {
                System.out.print("N" + " ");
            }
            if (A3 != 0) {
                System.out.print(A3 + " ");
            } else {
                System.out.print("N" + " ");
            }
            if (A4 != 0) {
                System.out.print(A4 / count + "." + (A4 % count * 100 / count + 5) / 10 + " ");
            } else {
                System.out.print("N" + " ");
            }
            if (A5 != 0) {
                System.out.print(A5);
            } else {
                System.out.print("N");
            }
        }
    }
}
