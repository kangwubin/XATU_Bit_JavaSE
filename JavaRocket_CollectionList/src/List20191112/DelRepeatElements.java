package List20191112;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Description:输入两个字符串，从第一字符串中删除第二个字符串中所有的字符。
 * 例如，输入”They are students.”和”aeiou”，则删除之后的第一个字符串变成”Thy r stdnts.”
 *
 * @author: KangWuBin
 * @Date: 2019/11/12
 * @Time: 15:29
 */
public class DelRepeatElements {
    public static void main1(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str1;
        String str2;
        List<Character> characterList = new ArrayList<>();
        while (scanner.hasNext()) {
            str1 = scanner.nextLine();
            str2 = scanner.nextLine();
            if (str1.equals("")) {
                return;
            }
            if (str2.equals("")) {
                return;
            }
            //如果str包含在str1中
            for (int i = 0; i < str1.length(); i++) {
                if (!(str2.contains(str1.charAt(i) + ""))) {
                    characterList.add(str1.charAt(i));
                }
            }
            for (int j = 0; j < characterList.size(); j++) {
                System.out.print(characterList.get(j));
            }
        }
    }

    public static List<Character> searchNotRepeatChar(String str1, String str2) {
        if (str1.equals("")) {
            return new ArrayList<>();
        }
        if (str2.equals("")) {
            return new ArrayList<>();
        }
        List<Character> characterList = new ArrayList<>();
        for (int i = 0; i < str1.length(); i++) {
            //contains---传一个字符串
            if (!(str2.contains(str1.charAt(i) + ""))) { //str1.charAt(i) + ""---转成String
                characterList.add(str1.charAt(i));
            }
        }
        return characterList;
    }

    public static void main(String[] args) {
        List<Character> characters = searchNotRepeatChar("welcome to bit", "come");
        System.out.println(characters);
    }
}
