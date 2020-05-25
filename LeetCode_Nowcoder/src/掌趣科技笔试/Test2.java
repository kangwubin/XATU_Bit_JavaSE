package 掌趣科技笔试;

import java.util.Scanner;

/**
 * Description:
 *
 * @author: KangWuBin
 * @Date: 2020/4/5
 * @Time: 15:29
 */
public class Test2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int input = scanner.nextInt();
        System.out.println(getSum(input));
    }

    private static int getSum(int n) {
        // write code here
        if (n == 1 || n == 2) {
            return 1;
        }
        return getSum(n - 1) + getSum(n - 2);
    }
}
