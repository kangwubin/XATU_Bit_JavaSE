package 华为笔试_200225;

import java.util.Scanner;

/**
 * Description:磁盘容量问题：
 * 磁盘存储的常用单位有：T,G,M；1T=1000G,1G=1000M;
 * 第一行输入n个整数，第二行输入磁盘容量的大小，对其按照从小到大的顺序输出；
 * 输入示例：第一行  3
 * 输入示例：第二行： 4M,2T,512G;
 * 输出：4M,512G,2T
 *
 * @author: KangWuBin
 * @Date: 2020/2/25
 * @Time: 9:30
 */
public class Main {
    public static void main(String[] args) {
        Scanner sca = new Scanner(System.in);
        int num = sca.nextInt();

        String cod[] = new String[num];
        for (int i = 0; i < num; i++) {
            cod[i] = sca.next();
        }

        for (int i = 1; i < cod.length - 1; i++) {
            for (int j = 1; j < cod.length - i; j++) {
                if (comper(cod[j], cod[j + 1]) == 0) {
                    String str = cod[j];
                    cod[j] = cod[j + 1];
                    cod[j + 1] = str;
                }
            }
        }

        for (int i = 0; i < num; i++) {
            System.out.print(cod[i] + " ");
        }
    }

    private static int comper(String str1, String str2) {
        char ch1, ch2;
        long num1, num2;
        ch1 = str1.charAt(str1.length() - 1);
        ch2 = str2.charAt(str2.length() - 1);

        num1 = Integer.parseInt(str1.substring(0, str1.length() - 1));
        num2 = Integer.parseInt(str2.substring(0, str2.length() - 1));

        if (ch1 == 'T') {
            num1 *= 1000000;
        }
        if (ch2 == 'T') {
            num2 *= 1000000;
        }
        if (ch1 == 'G') {
            num1 *= 1000;
        }
        if (ch2 == 'G') {
            num2 *= 1000;
        }

        if (num1 > num2) {
            return 0;
        } else
            return 1;
    }
}
