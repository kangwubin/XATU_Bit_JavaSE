package MianShi;

import java.util.Scanner;

/**
 * Description:
 *
 * @author: KangWuBin
 * @Date: 2020/3/12
 * @Time: 15:14
 */
public class Test {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            disope(n);
        }
    }

    private static void disope(int n) {
        System.out.print(n + "=");
        for (int i = 2; i < n + 1; i++) {
            while ((0 == n % i) && (i != n)) {
                n /= i;
                System.out.print(i + "*");
            }
            if (i == n) {
                System.out.print(i);
                break;
            }
        }
    }
}
