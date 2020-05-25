package day30_200113;

import java.util.Scanner;

/**
 * Description:奇偶校验
 *
 * @author: KangWuBin
 * @Date: 2020/1/13
 * @Time: 21:19
 */
public class Main1 {
    /* 题目：输入一个字符串，然后对每个字符进行奇校验，最后输出校验后的二进制数(如'3’，输出：10110011)。
     * 输入：输入包括一个字符串，字符串长度不超过100。
     * 输出：可能有多组测试数据，对于每组数据，对于字符串中的每一个字符，输出按题目进行奇偶校验后的数，每个字符校验的结果占一行。*/
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String a = scanner.nextLine();
            char[] chars = a.toCharArray();
            for (int i = 0; i < chars.length; i++) {
                int n = chars[i];
                StringBuffer stringBuffer = new StringBuffer();

                while (n > 0) {
                    int b = n % 2;
                    stringBuffer.append(b);
                    n = n / 2;
                }

                int bit = stringBuffer.length();
                int count = 0;
                for (int j = 0; j < bit; j++) {
                    if (stringBuffer.charAt(j) == '1') {
                        count++;
                    }
                }
                for (int k = bit; k < 7; k++) {
                    stringBuffer.append(0);
                }
                if (count % 2 == 0) {
                    stringBuffer.append(1);
                } else {
                    stringBuffer.append(0);
                }

                stringBuffer = stringBuffer.reverse();
                System.out.println(stringBuffer.toString());
            }
        }
    }
}
