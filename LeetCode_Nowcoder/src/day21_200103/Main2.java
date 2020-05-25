package day21_200103;

import java.util.*;

/**
 * Description:
 * NowCoder生活在充满危险和阴谋的年代。为了生存，他首次发明了密码，用于军队的消息传递。
 * 假设你是军团中的一名军官，需要把发送来的消息破译出来、并提供给你的将军;
 * 消息加密的办法是：对消息原文中的每个字母，分别用该字母之后的第5个字母替换，
 * 其他字符不变，并且消息原文的所有字母都是大写的。密码中的字母与原文中的字母对应关系如下。
 * 密码字母：A B C D E    F G H I J K L M N O P Q R S T U V W X Y Z;
 * 原文字母：V W X Y Z    A B C D E F G H I J K L M N O P Q R S T U;
 * 输入描述:输入包括多组数据，每组数据一行，为收到的密文。密文仅有空格和大写字母组成。
 * 输出描述:对应每一组数据，输出解密后的明文。
 * 输入：HELLO WORLD；输出：CZGGJ RJMGY；
 *
 * @author: KangWuBin
 * @Date: 2020/1/2
 * @Time: 21:30
 */
public class Main2 {
    private static String GetUnderstandCode(String string) {
        Map<Character, Character> map = new HashMap<>();
        List<Character> list = new ArrayList<>();
        for (int i = 0; i < 26; i++) {
            list.add((char) (65 + i));
        }
        /* 将密文与明文之间的对应关系保存在一个Map集合里;
         * 将原字符分两部分转化，一部分 F–Z ，只需要将ASCII码对应减 5；
         * 另一部分 A–E，将ASCII码对应加21，遇到空格直接跳过，即可完成密码的解读*/
        for (int i = 0; i < list.size(); i++) {
            if (i < 5) {
                //当明文为字母表后5个字母时，密文为前5个字母
                map.put(list.get(i), (char) (list.get(i) + 21));
            } else {
                //
                map.put(list.get(i), (char) (list.get(i) - 5));
            }
        }
        char[] chars = string.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (map.containsKey(chars[i])) {
                chars[i] = map.get(chars[i]);
            }
        }
        return new String(chars);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String input = scanner.nextLine();
            System.out.println(GetUnderstandCode(input));
        }
    }

    public static void main2(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String input = scanner.nextLine();
            char[] chars = input.toCharArray();
            for (int i = 0; i < chars.length; i++) {
                char ch = chars[i];
                if ('A' <= ch) {
                    //密码字母：A B C D E   F G H I J K L M N O P Q R S T U V W X Y Z
                    //原文字母：V W X Y Z   A B C D E F G H I J K L M N O P Q R S T U
                    //比如: F -> A  => F - 5
                    //比如：B -> W  => B + 21
                    ch = (char) ('E' < ch ? (ch - 5) : (ch + 21));
                    chars[i] = ch;
                }
            }
            System.out.println(new String(chars));
        }
    }
}
