package 快手笔试;

import java.util.Scanner;

/**
 * Description:
 *
 * @author: KangWuBin
 * @Date: 2020/3/22
 * @Time: 19:42
 */
public class Main2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String string = scanner.next();
        int num = 1;
        char c = ' ';
        for (int i = 0; i < string.length(); i++) {
            char x = string.charAt(i);
            if ((x >= 'a' && x <= 'z') || (x >= 'A' && x <= 'Z')) {
                c = x;
                System.out.print(c);
            } else {
                num = Integer.parseInt(String.valueOf(x));
                for (int j = 0; j < num - 1; j++) {
                    System.out.print(c);
                }
                num = 0;
            }
        }
    }
}
