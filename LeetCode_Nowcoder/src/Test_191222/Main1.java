package Test_191222;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Description:给定一个数组arr，其中只有有两个数字出现了奇数次，其它数字都出现了偶数次，
 * 按照从小到大的顺序输出这两个数；
 *
 * @author: KangWuBin
 * @Date: 2019/12/22
 * @Time: 9:22
 */
public class Main1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int input = scanner.nextInt();
            int[] arr = new int[input];
            for (int i = 0; i < input; i++) {
                arr[i] = scanner.nextInt();
            }
            String string = arr + "";
            int count = 0;
            StringBuffer stringBuffer = new StringBuffer();
            for (int i = 0; i < string.length(); i++) {
                char[] chars = string.toCharArray();
                if (chars[i] == chars[i + 1]) {
                    count++;
                    continue;
                }
            }
        }
    }
}

