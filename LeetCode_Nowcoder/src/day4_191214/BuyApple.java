package day4_191214;

import java.util.Scanner;

/**
 * Description:
 *
 * @author: KangWuBin
 * @Date: 2019/12/15
 * @Time: 22:38
 */
public class BuyApple {
    /* 小易去附近的商店买苹果，奸诈的商贩使用了捆绑交易，只提供了 6个每袋和 8个每袋的包装(包装不可拆分)；
     * 可是小易现在只想购买恰好n个苹果，小易想尽量购买少的袋数方便携带。
     * 如果不能购买恰好n个苹果，小易将不会购买。*/
    private static void buyApple(int n) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (6 * i + 8 * j == n) {
                    if (n % 6 == 0) {
                        System.out.println(n / 6);
                        return;
                    } else {
                        System.out.println(i + j);
                        return;
                    }
                }
            }
        }
        System.out.println(-1);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int num = scanner.nextInt();
            buyApple(num);
        }
    }
}
