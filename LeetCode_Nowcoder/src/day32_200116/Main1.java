package day32_200116;

import java.util.Scanner;

/**
 * Description:在霍格沃茨找零钱
 *
 * @author: KangWuBin
 * @Date: 2020/1/16
 * @Time: 19:52
 */
public class Main1 {
    /* 题目：如果你是哈利·波特迷，你会知道魔法世界有它自己的货币系统 ——
     * 就如海格告诉哈利的：“十七个银西可(Sickle)兑一个加隆(Galleon)，二十九个纳特(Knut)兑一个西可，很容易。”
     * 现在，给定哈利应付的价钱P和他实付的钱A，你的任务是写一个程序来计算他应该被找的零钱。
     * 输入：输入在1行中分别给出P和A，格式为“Galleon.Sickle.Knut”，其间用1个空格分隔。
     *      这里Galleon是[0, 10^7]]区间内的整数，Sickle是[0, 17)区间内的整数，Knut是[0, 29)区间内的整数。
     * 输出：在一行中用与输入同样的格式输出哈利应该被找的零钱。如果他没带够钱，那么输出的应该是负数。
     * 输入：10.16.27 14.1.28；输出：3.2.1；*/
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String[] str1 = scanner.next().split("\\.");
            String[] str2 = scanner.next().split("\\.");
            //统一转换：换算为最低单位数字进行比较，然后再转换位最高单位数组；
            int P = Integer.parseInt(str1[0]) * 17 * 29 + Integer.parseInt(str1[1]) * 29 + Integer.parseInt(str1[2]);
            int A = Integer.parseInt(str2[0]) * 17 * 29 + Integer.parseInt(str2[1]) * 29 + Integer.parseInt(str2[2]);
            int moneyReturn = A - P;
            int x = moneyReturn / (17 * 29);
            int y = Math.abs(moneyReturn % (17 * 29) / 29);
            int z = Math.abs(moneyReturn % (17 * 29) % 29);
            System.out.println(x + "." + y + "." + z);
        }
    }
}
