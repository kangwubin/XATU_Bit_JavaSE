package day24_201006;

import java.util.Scanner;

/**
 * Description:
 *
 * @author: KangWuBin
 * @Date: 2020/1/6
 * @Time: 17:52
 */
public class Main2 {
    /* 老师想知道从某某同学当中，分数最高的是多少，现在请你编程模拟老师的询问。当然，老师有时候需要更新某位同学的成绩.
     * 输入描述:输入包括多组测试数据。
     * 每组输入第一行是两个正整数N和M（0 < N <= 30000,0 < M < 5000）,分别代表学生的数目和操作的数目。
     * 学生ID编号从1编到N。
     * 第二行包含N个整数，代表这N个学生的初始成绩，其中第i个数代表ID为i的学生的成绩
     * 接下来又M行，每一行有一个字符C（只取‘Q’或‘U’），和两个正整数A,B,当 C 为 ’Q’的时候, 表示这是一条询问操作，
     * 他询问ID从A到B（包括A,B）的学生当中，成绩最高的是多少;
     * 当 C 为 ‘U’ 的时候，表示这是一条更新操作，要求把ID为A的学生的成绩更改为B;
     * 输出描述:对于每一次询问操作，在一行里面输出最高成绩.*/
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n, m = 0;
        String s = "";
        int index = 0;
        int score = 0;
        while (scanner.hasNext()) {
            n = scanner.nextInt();
            m = scanner.nextInt();
            int[] stu = new int[n];
            for (int i = 0; i < n; i++) {
                stu[i] = scanner.nextInt();
            }
            for (int i = 0; scanner.hasNext() && i < m; i++) {
                s = scanner.next();
                index = scanner.nextInt();
                score = scanner.nextInt();
                if (s.equals("Q")) {
                    int begin = Math.min(index, score);
                    int end = Math.max(index, score);
                    int max = stu[begin - 1];
                    for (int j = begin; j < end; j++) {
                        max = Math.max(max, stu[j]);
                    }
                    System.out.println(max);
                } else if (s.equals("U")) {
                    stu[index - 1] = score;
                }
            }
        }
    }
}
