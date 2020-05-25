package day15_191227;

import java.util.Scanner;

/**
 * Description:请编写一个函数，将两个数字相加，不得使用+或其他算数运算符。
 * 给定两个int A和 B。请返回 A+B 的值；
 *
 * @author: KangWuBin
 * @Date: 2019/12/28
 * @Time: 20:28
 */
public class Main1 {
    private static int add1(int A, int B) {
        return A + B;
    }

    /*
     *两个数异或：相当于每一位相加，而不考虑进位；
     *两个数相与，并左移一位：相当于求得进位；
     *将两个新得到的数进行add操作，得到的结果和原本两个数相加相同，
     *这样会把num2变得越来越小，直到为0是，则两个数的和直接就变成num1.
     */
    private static int addAB(int A, int B) {
        // 面试重要
        int sum, carry;
        do {
            sum = A ^ B;
            carry = (A & B) << 1;
            A = sum;
            B = carry;
        } while (B != 0);
        return A;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int inputA = scanner.nextInt();
            int inputB = scanner.nextInt();
            int ret1 = add1(inputA, inputB);
            int ret = addAB(inputA, inputB);
            System.out.println(ret);
        }
    }
}
