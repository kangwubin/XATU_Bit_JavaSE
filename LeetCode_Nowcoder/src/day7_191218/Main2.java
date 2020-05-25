package day7_191218;

import java.util.Scanner;

/**
 * Description:
 *
 * @author: KangWuBin
 * @Date: 2019/12/18
 * @Time: 0:17
 */
public class Main2 {
    /* 正整数A和正整数B的最小公倍数是指能被A和B整除的最小的正整数值，设计一个算法，求输入A和B的最小公倍数。
     * 输入：5  7；输出：35； */
    private static int solution(int a, int b) {
        int max;
        if (a >= b) {
            max = a;
        } else {
            max = b;
        }
        for (int i = max; i < a * b; i++) {
            if (i % a == 0 && i % b == 0) {
                return i;
            }
        }
        return a * b;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int A = scanner.nextInt();
            int B = scanner.nextInt();
            System.out.println(solution(A, B));
        }
    }
}
