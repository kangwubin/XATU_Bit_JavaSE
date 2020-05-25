package day29_200112;

import java.util.Scanner;

/**
 * Description:年会抽奖：排列组合问题 + 错排算法---理解困难
 *
 * @author: KangWuBin
 * @Date: 2020/1/11
 * @Time: 21:34
 */
public class Main1 {
    /* 今年公司年会的奖品特别给力，但获奖的规矩却很奇葩：
     * 1.首先，所有人员都将一张写有自己名字的字条放入抽奖箱中；
     * 2.待所有字条加入完毕，每人从箱中取一个字条；
     * 3.如果抽到的字条上写的就是自己的名字，那么“恭喜你，中奖了！”
     * 现在告诉你参加晚会的人数，请你计算有多少概率会出现无人获奖？
     * 输入：输入包含多组数据，每组数据包含一个正整数n（2≤n≤20）。
     * 输出：对应每一组数据，以“xx.xx%”的格式输出发生无人获奖的概率。*/
    private static float fib(int n) {
        if (n == 1) {
            return 0;
        }
        if (n == 2) {
            return 1;
        } else {
            return (n - 1) * (fib(n - 1) + fib(n - 2));
        }
    }

    private static float func(int n) {
        if (n == 0) {
            //0的阶乘等于1
            return 1;
        } else {
            return n * func(n - 1);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            float ret = (fib(n) / func(n)) * 100;
            System.out.println(String.format("%.2f", ret) + "%");
        }
    }
}
