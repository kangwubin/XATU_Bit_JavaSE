package day40_200305;

import java.util.Scanner;

/**
 * Description:输入两个字符串，从第一字符串中删除第二个字符串中所有的字符。
 * 例如，输入”They are students.”和”aeiou”，则删除之后的第一个字符串变成”Thy r stdnts.”
 *
 * @author: KangWuBin
 * @Date: 2020/3/7
 * @Time: 11:17
 */
public class Main1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String inputA = scanner.nextLine();
        String inputB = scanner.nextLine();
        char[] charsA = inputA.toCharArray();
        for (int i = 0; i < charsA.length; i++) {
            if (!inputB.contains(String.valueOf(charsA[i]))) {
                System.out.print(charsA[i]);
            }
        }
    }
}
