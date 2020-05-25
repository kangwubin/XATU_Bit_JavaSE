package 笔试360;

import java.util.Scanner;

/**
 * Description:
 *
 * @author: KangWuBin
 * @Date: 2020/3/27
 * @Time: 21:02
 */
public class Main2 {
    int A = 1;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int R = n * 1;
        int C = n * 1;
        int L = n * 1;
        int v = R * C * L;
        n = (R - 2) * (C - 1) * (L - 2);
        if (v == n) {
            int res = v;
            System.out.println(res);
        }
    }
}
