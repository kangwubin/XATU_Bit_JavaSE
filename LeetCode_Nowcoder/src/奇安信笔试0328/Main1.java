package 奇安信笔试0328;

import java.util.Scanner;

/**
 * Description:
 *
 * @author: KangWuBin
 * @Date: 2020/3/28
 * @Time: 19:55
 */
public class Main1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int res = func(N);
        System.out.println(res);
    }

    private static int func(int number) {
        int lagNum = 0;
        if (number > 1 && number < 15) {
            if (number-- >= 1) {
                lagNum += 5;
            }
            if (number >= 2) {
                lagNum += 3;
                number -= 2;
            }
            if (number >= 5) {
                lagNum += 5;
                number -= 5;
            }
            if (number >= 2) {
                lagNum += 2;
                number -= 2;
            }
            if (number >= 3) {
                lagNum += 1;
                number -= 3;
            }
            return lagNum;
        } else {
            return 0;
        }
    }
}
