package day28_200111;

import java.util.Scanner;

/**
 * Description:
 *
 * @author: KangWuBin
 * @Date: 2020/1/10
 * @Time: 21:35
 */
public class Main2 {
    /*密码要求:密码验证合格程序：
     * 1.长度超过8位;2.包括大小写字母.数字.其它符号,以上四种至少三种;
     * 3.不能有相同长度超2的子串重复,说明:长度超过2的子串;
     * 输入：一组或多组长度超过2的子符串。每组占一行；
     * 输出：如果符合要求输出：OK，否则输出NG；*/
    /*1.长度超过8位*/
    private static boolean checkLength(String password) {
        if (password.length() > 8) {
            return true;
        } else {
            return false;
        }
    }

    /*2.包括大小写字母.数字.其它符号,以上四种至少三种;*/
    private static boolean checkKinds(String password) {
        int numbers = 0, low = 0, cap = 0, others = 0;
        char[] chars = password.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] <= '9' && chars[i] >= '0') {
                numbers = 1;
            } else if (chars[i] >= 'a' && chars[i] <= 'z') {
                low = 1;
            } else if (chars[i] >= 'A' && chars[i] <= 'Z') {
                cap = 1;
            } else {
                others = 1;
            }
        }
        return numbers + low + cap + others >= 3;
    }

    /*3.不能有相同长度超2的子串重复*/
    private static boolean checkRepeat(String password) {
        for (int i = 0; i < password.length() - 2; i++) {
            String string = password.substring(i, i + 3);
            if (password.substring(i + 1).contains(string)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String password = scanner.nextLine();
            if (checkLength(password) && checkKinds(password) && checkRepeat(password)) {
                System.out.println("OK");
            } else {
                System.out.println("NG");
            }
        }
    }
}
