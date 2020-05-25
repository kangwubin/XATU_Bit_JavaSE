package 西安葡萄城笔试;

import java.util.Scanner;

/**
 * Description:
 *
 * @author: KangWuBin
 * @Date: 2020/3/18
 * @Time: 10:42
 */
public class YangHui2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            int m = scanner.nextInt();
            System.out.println(Func(n, m));
        }
    }

    private static int Func(int n, int m) {
        if (n == m || m == 1) {
            return 1;
        } else {
            return Func(n - 1, m - 1) + Func(n - 1, m);
        }
    }
}
