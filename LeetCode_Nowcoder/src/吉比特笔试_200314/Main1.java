package 吉比特笔试_200314;

import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * Description:
 *
 * @author: KangWuBin
 * @Date: 2020/3/14
 * @Time: 15:50
 */
public class Main1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()){
            System.out.println(help(scanner.nextLine()));
        }
    }

    private static String help(String s) {
        String s1 = s.toLowerCase();
        Set<Character> list = new LinkedHashSet<>();
        char[] cs = s1.toCharArray();
        for (char c : cs) {
            list.add(c);
        }
        StringBuilder sb = new StringBuilder();
        for (char c : list) {
            sb.append(c);
        }
        return sb.toString();
    }
}
