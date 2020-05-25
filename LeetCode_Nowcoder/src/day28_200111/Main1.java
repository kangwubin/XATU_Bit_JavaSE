package day28_200111;

import java.util.Scanner;

/**
 * Description:
 *
 * @author: KangWuBin
 * @Date: 2020/1/10
 * @Time: 21:34
 */
public class Main1 {
    /* 守形数是这样一种整数，它的平方的低位部分等于它本身。
     * 比如25的平方是625，低位部分是25，因此25是一个守形数。 编一个程序，判断N是否为守形数。
     * 输入：输入包括1个整数N，2<=N<100。
     * 输出：输出"Yes!”表示N是守形数；输出"No!”表示N不是守形数。*/
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            int num = n * n;
            String n1 = Integer.toString(n);
            String n2 = Integer.toString(num);
            if (n2.substring(1,n2.length()).equals(n1)){
                System.out.println("Yes!");
            }else {
                System.out.println("No!");
            }
        }
    }
}
