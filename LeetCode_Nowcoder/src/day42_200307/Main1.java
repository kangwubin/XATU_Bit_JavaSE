package day42_200307;

import java.util.Scanner;

/**
 * Description:根据输入的日期，计算是这一年的第几天。。
 * 详细描述：输入某年某月某日，判断这一天是这一年的第几天？
 * 输入：2012   12     31
 * 输出：366
 *
 * @author: KangWuBin
 * @Date: 2020/3/7
 * @Time: 22:31
 */
public class Main1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int year = scanner.nextInt();
            int month = scanner.nextInt();
            int day = scanner.nextInt();
            int Day = outDay(year, month, day);
            System.out.println(Day);
        }
    }

    private static int outDay(int year, int month, int day) {
        int[] Day = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        if (year <= 0 || month <= 0 || month > 12 || day <= 0) {
            return -1;
        }
        if (year % 4 == 0 && year % 100 != 0 || year % 400 == 0) {
            Day[1] = 29;
        }
        int total = 0;
        for (int i = 0; i < month - 1; i++) {
            total = total + Day[i];
        }
        return total + day;
    }
}
