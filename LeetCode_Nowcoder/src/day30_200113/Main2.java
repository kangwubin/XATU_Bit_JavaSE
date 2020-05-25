package day30_200113;

import java.util.Scanner;

/**
 * Description:大整数排序
 *
 * @author: KangWuBin
 * @Date: 2020/1/13
 * @Time: 21:22
 */
public class Main2 {
    /* 题目：对N个长度最长可达到1000的数进行排序。
     * 输入：输入第一行为一个整数N，(1<=N<=100)。
     *      接下来的N行每行有一个数，数的长度范围为1<=len<=1000。
     *      每个数都是一个正数，并且保证不包含前缀零。
     * 输出：可能有多组测试数据，对于每组数据，将给出的N个数从小到大进行排序，输出排序后的结果，每个数占一行。*/
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            String[] input = new String[n];
            for (int i = 0; i < n; i++) {
                input[i] = scanner.nextLine();
            }
            sort(input, 0, n - 1);
            for (String string : input) {
                System.out.println(string);
            }
        }
    }

    //将大数字弄成字符串比较
    private static int compare(String str1, String str2) {
        if (str1.length() > str2.length()) {
            return 1;
        }
        if (str1.length() < str2.length()) {
            return 2;
        } else {
            return str1.compareTo(str2);
        }
    }

    //比较函数--快速排序
    private static void sort(String[] strings, int left, int right) {
        if (left < right) {
            int i = left;
            int j = right;
            String x = strings[i];
            while (i < j) {
                while (i < j && compare(strings[j], x) >= 0) {
                    j--;
                }
                if (i < j) {
                    strings[i++] = strings[j];
                }
                while (i < j && compare(strings[i], x) < 0) {
                    i++;
                }
                if (i < j) {
                    strings[j--] = strings[i];
                }
            }
            strings[i] = x;
            sort(strings, left, i - 1);
            sort(strings, i + 1, right);
        }
    }
}
