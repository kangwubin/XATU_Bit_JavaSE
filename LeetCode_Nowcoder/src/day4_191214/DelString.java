package day4_191214;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Description:
 *
 * @author: KangWuBin
 * @Date: 2019/12/15
 * @Time: 23:45
 */
public class DelString {
    /*输入两个字符串，从第一个字符串中删除第二个字符串中的所有字符。
     * 例如，输入：They are students.和"aeiou";
     * 则删除之后的第一个字符串变成"Thy r stdnts."*/
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Character> arrayList = new ArrayList<>();
        while (scanner.hasNext()) {
            String s1 = scanner.nextLine();
            String s2 = scanner.nextLine();
            for (int i = 0; i < s1.length(); i++) {
                if (!s2.contains(s1.charAt(i) + "")) {
                    arrayList.add(s1.charAt(i));
                }
            }
            for (int j = 0; j < arrayList.size(); j++) {
                System.out.print(arrayList.get(j) + "");
            }
        }
    }
}
