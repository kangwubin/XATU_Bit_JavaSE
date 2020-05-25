package day40_200305;

import java.util.Scanner;

/**
 * Description:将一个英文语句以单词为单位逆序排放。例如“I am a boy”，逆序排放后为“boy a am I”
 * 所有单词之间用一个空格隔开，语句中除了英文字母外，不再包含其他字符
 *
 * @author: KangWuBin
 * @Date: 2020/3/7
 * @Time: 11:18
 */
public class Main2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        String[] inputS = input.split(" ");
        for (int i = inputS.length-1; i >= 0; i--) {
            System.out.print(inputS[i] + " ");
        }
    }
}
