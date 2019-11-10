package StringTest;
import java.util.Scanner;

/**
 * Description:
 *
 * @author: KangWuBin
 * @Date: 2019/11/5
 */
public class StringTest {
    //给定字符串一个字符串, 判断其是否全部由数字所组成
    public static boolean isNumber(String str) {
        //toCharArray
        char[] chars = str.toCharArray();
        //遍历数组
        for (int i = 0; i < chars.length; i++) {
            if (chars[0] < '0' && chars[i] > '9') {
                return false;
            }
        }
        return true;
    }

    //字符串逆置
    public static String reverse(String str) {
        if (str == null || str.length() < 0) {
            return null;
        }
        char[] chars = str.toCharArray();
        int left = 0;
        int right = chars.length - 1;
        while (left < right) {
            char tmp = chars[left];
            chars[left] = chars[right];
            chars[right] = tmp;
            left++;
            right--;
        }
        String str1 = new String(chars);
        return str1;
    }

    public static void main1(String[] args) {
        String str = "1234567a";
//        boolean flg = isNumber(str);
//        System.out.println(flg);
        reverse(str);
        System.out.println(reverse(str));
    }

    /**
     * 给一个字符类型的数组chas和一个整数size，请把大小为size的左半区整体右移到右半区，右半区整体移动到左边。
     * 输入两行，第一行一个整数，代表size,第二行一个字符串，-------(重点)
     * 输入：3  abcdefg   输出：defgabc
     */
    public static String reverseWord(String str, int start, int end) {
        char[] ch = str.toCharArray();
        while (start < end) {
            char tmp = ch[start];
            ch[start] = ch[end];
            ch[end] = tmp;
            start++;
            end--;
        }
//        return new String(ch);
        return String.copyValueOf(ch);
    }

    public static void main2(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int size = scanner.nextInt();
        String str = scanner.next();
        //3  abcdefg
        str = reverseWord(str, 0, size - 1);    //cba
        str = reverseWord(str, size, str.length() - 1);     //gfed
        str = reverseWord(str, 0, str.length() - 1);  //defgabc
        System.out.println(str);
    }

    /*
     * 不借用任何字符串库函数实现无冗余地接受两个字符串，然后把它们无冗余的连接起来。
     * 输入：abc def     输出：abcdef
     * */
    public static String strReceive(String str) {
        String[] strings = str.split(" ");
        StringBuilder sb = new StringBuilder();
        for (String s : strings) {
            sb.append(s);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        System.out.println(strReceive(str));
    }

}
