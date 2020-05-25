package day6_191216;

import java.util.Scanner;

/**
 * Description:
 *
 * @author: KangWuBin
 * @Date: 2019/12/16
 * @Time: 10:57
 */
public class Main1 {
    /* A,B,C三个人是好朋友，每个人手里都有一些糖果，我们不知道他们每个人手上具体有多少个糖果，
     * 但是我们知道以下的信息：A-B,B-C,A+B,B+C,这四个数值，每个字母代表每个人所拥有的糖果数；
     * 现在需要通过这四个数值计算出每个人手里有多少个糖果，即A,B,C;
     * 这里保证最多只有一组整数A,B,C,满足所有题设条件；
     * 输入：1 -2 3 4；
     * 输出：2 1 3；*/
    private static int calculate(float A, float B, float C, int a, int b, int c, int d) {
        if ((a + b) != (c - d)) {
            return -1;
        }
        System.out.print((int) A + " " + (int) B + " " + (int) C + " ");
        return 0;
    }

    public static void main(String[] args) {
        /* A-B=n1; B-C=n2; A+B=n3; B+C=n4;
         * n1+n2=A-C; n3-n4=A-C;*/
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            int c = scanner.nextInt();
            int d = scanner.nextInt();
            float A = (a + c) / 2f;
            float B = (c - a) / 2f;
            float C = (d - b) / 2f;
            calculate(A, B, C, a, b, c, d);
        }
    }
}
