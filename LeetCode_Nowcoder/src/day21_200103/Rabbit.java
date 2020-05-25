package day21_200103;

import java.util.Scanner;

/**
 * Description:
 * 有一只兔子，从出生后第3个月起每月都生一只兔子，小兔子长到第三个月后每个月又生一只兔子，
 * 假如兔子都不死，问每个月的兔子总数为多少？
 *
 * @author: KangWuBin
 * @Date: 2020/1/2
 * @Time: 20:53
 */
public class Rabbit {
    private static int getTotalCount1(int monthCount) {
        if (monthCount == 1 || monthCount == 2) {
            return 1;
        }
        //第一个月是1只
        int first = 1;
        //第二个月还是1只
        int second = 1;
        int sum = 0;
        //从第三个月开始算起
        for (int i = 2; i < monthCount; i++) {
            sum = first + second;
            first = second;
            second = sum;
        }
        return sum;
    }

    private static int getTotalCount(int monthCount) {
        if (monthCount == 1 || monthCount == 2) {
            return 1;
        }
        return getTotalCount(monthCount - 1) + getTotalCount(monthCount - 2);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int input = scanner.nextInt();
            int ret = getTotalCount(input);
            System.out.println(ret);
        }
    }
}
