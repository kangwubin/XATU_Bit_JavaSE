package Solution;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Description:
 *
 * @author: KangWuBin
 * @Date: 2019/11/6 11:01
 */
public class Solution {
    /**
     * leetcode:编写一个函数，其作用是将输入的字符串反转过来。输入字符串以字符数组 char[] 的形式给出。
     * 不要给另外的数组分配额外的空间，你必须原地修改输入数组、使用 O(1) 的额外空间解决这一问题。
     */
    public static void reverseString(char[] s) {
        int left = 0;
        int right = s.length - 1;
        if (s == null || s.length > right) {
            return;
        }
        while (left < right) {
            char c = s[left];
            s[left] = s[right];
            s[right] = c;
            left++;
            right--;
        }
        System.out.println(s);
    }

    /*
    * 给定两个字符串形式的非负整数 num1 和num2 ，计算它们的和。
    * num1 和num2 的长度都小于 5100.
    * num1 和num2 都只包含数字 0-9.
    * num1 和num2 都不包含任何前导零。
    你不能使用任何內建 BigInteger 库， 也不能直接将输入的字符串转换为整数形式。
    * */
    public String addStrings(String num1, String num2) {
        if (num1 == null && num2 == null) {
            return null;
        }
        if (num1 == null) {
            return num2;
        }
        if (num2 == null) {
            return num1;
        }
        StringBuilder sb = new StringBuilder("");
        int i = num1.length() - 1;
        int j = num2.length() - 1;
        int tmp = 0;
        while (i > 0 || j > 0) {

        }
        return num1;
    }

    /*
    * 给定两个字符串, A 和 B。A 的旋转操作就是将 A 最左边的字符移动到最右边。 
     例如, 若 A = 'abcde'，在移动一次之后结果就是'bcdea' 。
     如果在若干次旋转操作之后，A 能变成B，那么返回True.*/
    public boolean rotateString(String A, String B) {
        if (A == null && B == null) {
            return true;
        }
        if (A == null || B == null) {
            return false;
        }
        char[] chars = A.toCharArray();
        int left = 0;
        int right = A.length() - 1;
        while (left < right) {
            if (A.equals(B)) {
                return true;
            }
            char tmp = chars[left];
            chars[right - 1] = chars[right];
            chars[left] = chars[right - 1];
            chars[right] = tmp;
            left++;
            right--;
        }
        return false;
    }

    /*
     * 给定字符类型的数组chas，请在单词间做逆序调整。只要做到单词的顺序逆序即可，对空格的位置没有要求。
     * 输入一行只含字母和空格的字符串，代表chas.输入：i am a student
     * 输出一行字符串，代表逆转顺序后的字符串。输出：i ma a tneduts*/
    public static void main1(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        char[] res = str.toCharArray();
        int i = 0;
        int j = 0;
        int len = str.length();
        while (j <= len) {
            if (j == len || res[j] == ' ') {
                int s = i, e = j - 1;
                while (s < e) {
                    char t = res[s];
                    res[s] = res[e];
                    res[e] = t;
                    s++;
                    e--;
                }
                i = j + 1;
            }
            j++;
        }
        System.out.println(String.valueOf(res));
    }

    public static void main2(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        String[] str1 = str.split(" ");
        StringBuilder sb = new StringBuilder();
        for (String str2 : str1) {
            sb.append(new StringBuilder(str2).reverse().append(" "));
        }
        System.out.println(sb.toString());
    }

    /*
    * 输入一串字符，请编写一个字符串压缩程序，将字符串中连续出现的重复字母进行压缩，并输出压缩后的字符串。
      例如：aac 压缩为 1ac;xxxxyyyyyyzbbb 压缩为 3x5yz2b*/
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        char[] chars = str.toCharArray();

    }

    public static void main3(String[] args) {
        char[] chars = {'h', 'e', 'l', 'l', 'o'};
        reverseString(chars);
    }
}
