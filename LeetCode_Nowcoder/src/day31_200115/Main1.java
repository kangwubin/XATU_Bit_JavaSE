package day31_200115;

import java.util.Scanner;

/**
 * Description:
 *
 * @author: KangWuBin
 * @Date: 2020/1/14
 * @Time: 22:38
 */
public class Main1 {
    /*题目：给定一句英语，要求你编写程序，将句中所有单词的顺序颠倒输出。
     * 输入：测试输入包含一个测试用例，在一行内给出总长度不超过80的字符串。
     *      字符串由若干单词和若干空格组成，其中单词是由英文字母（大小写有区分）组成的字符串，
     *      单词之间用1个空格分开，输入保证句子末尾没有多余的空格。
     * 输出：每个测试用例的输出占一行，输出倒序后的句子。*/
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String input = scanner.nextLine();
            String[] strings = input.split(" ");
            for (int i = strings.length - 1; i >= 0; i--) {
                System.out.print(strings[i] + " ");
            }
        }
    }
}
