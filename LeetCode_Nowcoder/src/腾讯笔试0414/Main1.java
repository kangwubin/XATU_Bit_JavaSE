package 腾讯笔试0414;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Description:
 *
 * @author: KangWuBin
 * @Date: 2020/4/14
 * @Time: 20:41
 */
public class Main1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int i, j, k;
        i = scanner.nextInt();
        j = scanner.nextInt();
        k = scanner.nextInt();
        try {
            saojiaoxing(i, j, k);
        } catch (IllegalArgumentException e) {
            System.out.println("不能构成三角形！");
            e.printStackTrace();
        }
    }

    private static void saojiaoxing(int a, int b, int c) throws IllegalArgumentException {
        int t;
        if (b > a) {
            t = a;
            a = b;
            b = t;
        }
        if (c > a) {
            t = a;
            a = c;
            c = t;
        }
        if (b > c) {
            t = b;
            b = c;
            c = t;
        }
        if (b + c <= a) {
            throw new IllegalArgumentException();
        } else if (a == b && b == c && a == c) {
            System.out.println("等边三角形边长为：" + a + " " + b + " " + c);
        } else if ((a == b && b == c && a != c) || (a == b && a == c && b != c) || (a != b && b == c && c == a)) {
            System.out.println("等腰三角形边长为：" + a + " " + b + " " + c);
        } else {
            System.out.println("三角形边长为：" + a + " " + b + " " + c);
        }
    }
}
