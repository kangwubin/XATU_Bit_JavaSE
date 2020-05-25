package day9_191220;

import java.util.Scanner;

/**
 * Description:
 *
 * @author: KangWuBin
 * @Date: 2019/12/20
 * @Time: 18:30
 */
public class Main2 {
    /* 输入一个整数，将这个整数以字符串的形式逆序输出，程序不考虑负数情况；
     * 若数字含有0，则逆序形式也含有0，如输入100，则输出为001；*/
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int input = scanner.nextInt();
            String s = input + "";
            StringBuffer stringBuffer = new StringBuffer(s);
            System.out.println(stringBuffer.reverse());
        }
    }
}
