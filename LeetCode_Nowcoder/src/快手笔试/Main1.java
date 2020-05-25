package 快手笔试;

import java.util.Scanner;

/**
 * Description:
 *
 * @author: KangWuBin
 * @Date: 2020/3/22
 * @Time: 19:00
 */
public class Main1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        arrayFunc(n);
    }

    private static void arrayFunc(int n) {
        String[] s1 = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"};
        String[] s2 = {"A"};
        if (n == 1) {
            printArray(s2);
        } else {
            for (int i = 2; i <= n; i++) {
                s2 = Func(s2, s1[i - 1]);
            }
            printArray(s2);
        }
    }

    private static void printArray(String[] s2) {
        for (int i = 0; i < s2.length; i++) {
            if (i % 100 == 0) {
//                System.out.println();
            }
            System.out.print(s2[i]+"");
        }
    }

    private static String[] Func(String[] s1, String s2) {
        String[] strings = new String[s1.length * 2 + 1];
        for (int i = 0; i < s1.length; i++) {
            strings[i] = s1[i];
        }
        strings[s1.length] = s2;
        for (int i = 0; i < s1.length; i++) {
            strings[i + s1.length + 1] = s1[i];
        }
        return strings;
    }

}
