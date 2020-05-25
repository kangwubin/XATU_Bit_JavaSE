package day16_191228;

import java.util.Scanner;

/**
 * Description:读入N名学生的成绩，将获得某一给定分数的学生人数输出；
 * 输入:
 * 第一行:N
 * 第二行:N名学生成绩，相邻两数字之间用一个空格间隔
 * 第三行:给定分数
 * 读到 N=0 时，结束输入,N<=1000
 *
 * @author: KangWuBin
 * @Date: 2019/12/28
 * @Time: 22:34
 */
public class Main2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int N = scanner.nextInt();//输入的人数
            if (N == 0) {
                return;
            }
            int[] array = new int[N];//保存N个人的分数
            for (int i = 0; i < array.length; i++) {
                array[i] = scanner.nextInt();
            }
            int aimScore = scanner.nextInt();// 目标分数 输出击中目标分数的个数
            int count = 0;
            for (int i = 0; i < array.length; i++) {
                if (aimScore == array[i]) {
                    count++;
                }
            }
            System.out.println(count);
        }
    }
}
