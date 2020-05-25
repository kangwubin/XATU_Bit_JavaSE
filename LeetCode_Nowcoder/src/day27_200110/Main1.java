package day27_200110;

import java.util.Scanner;

/**
 * Description:
 *
 * @author: KangWuBin
 * @Date: 2020/1/10
 * @Time: 14:40
 */
public class Main1 {
    /* 输入一个数n,然后输入n个数值各不相同,再输·入一个值x,输出这个值在这个数组中的下标(从 0开始,若不在数组中则输出-1)。
     * 输入：测试数据有多组,输入n (1<=n<=200) ,接着输入n个数,然后输入x。
     * 输出：对于每组输入,请输出结果。*/
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            int[] numbers = new int[n];
            for (int i = 0; i < n; i++) {
                numbers[i] = scanner.nextInt();
            }
            int key = scanner.nextInt();
            int ret = -1;
            for (int i = 0; i < n; i++) {
                if (key == numbers[i]) {
                    ret = i;
                    break;
                }
            }
            System.out.println(ret);
        }
    }
}
