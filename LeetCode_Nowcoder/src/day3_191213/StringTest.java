package day3_191213;

import java.util.Scanner;

/**
 * Description:
 *
 * @author: KangWuBin
 * @Date: 2019/12/15
 * @Time: 0:01
 */
public class StringTest {
    /*读入一个字符串，输出字符串str中的连续最长的数字串；
     * 输入：abcd12345ed125ss123456789；
     * 输出：123456789；*/
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String str = scanner.nextLine();
            /*算法思想：用 max 表示经过的数字长度最大值，count表示数字计数器，当为字母时重置为0
             *end表示数字尾部，每次满足数字时，对 max 进行判断，当 max 小于count时，更新 max 和 end
             */
            int max = 0;
            int count = 0;
            int end = 0;
            for (int i = 0; i < str.length(); i++) {
                char ch = str.charAt(i);
                if (ch >= '0' && ch <= '9') {
                    count++;
                    if (max < count) {
                        max = count;
                        end = i;
                    }
                } else {
                    count = 0;
                }
            }
            System.out.println(str.substring(end - max + 1, end + 1));
        }
    }
}
