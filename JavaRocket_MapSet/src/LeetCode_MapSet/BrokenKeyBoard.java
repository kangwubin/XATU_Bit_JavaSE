package LeetCode_MapSet;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * Description:4.旧键盘上坏了几个键，于是在敲一段文字的时候，对应的字符就不会出现。
 * 现在给出应该输入的一段文字、以及实际被输入的文字，请你列出肯定坏掉的那些键。
 *
 * @author: KangWuBin
 * @Date: 2019/12/3
 * @Time: 10:58
 */
public class BrokenKeyBoard {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String expected = scanner.nextLine();//期望的
        String actual = scanner.nextLine();//实际的
        // 都转换为大写的
        expected = expected.toUpperCase();
        actual = actual.toUpperCase();
        // 定义集合，存储真实的值
        Set<Character> setAct = new HashSet<>();
        for (char ch : actual.toCharArray()) {
            setAct.add(ch);
        }
        //setAct集合当中存放的是真实的字符
        Set<Character> setBroken = new HashSet<>();
        for (char ch : expected.toCharArray()) {
            //
            if (!setAct.contains(ch) && !setBroken.contains(ch)) {
                setBroken.add(ch);
                System.out.print(ch);
                System.out.println();
            }
        }
        System.out.println(setBroken);
    }
}
