package day13_191225;

import java.math.BigInteger;
import java.util.Scanner;

/**
 * Description:请设计一个算法，完成两个超长整数的加法；
 * 输入：输入两个字符串数组；
 * 输出：输出相加后的结果，string类型；
 *
 * @author: KangWuBin
 * @Date: 2019/12/25
 * @Time: 16:50
 */
public class Main2 {
    /*addend:表示加数；augend表示被加数；*/
//    public static String AddLongInteger(String addend, String augend) {
//        Long A = Long.valueOf(addend);
//        Long B = Long.valueOf(augend);
//        BigInteger B = BigInteger.valueOf(Long.parseLong(augend));
//        System.out.println(B);
//        Long result = A + B;
//        return String.valueOf(result);
//    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String inputA = scanner.next();
            String inputB = scanner.next();
//            String ret = AddLongInteger(inputA, inputB);
//            System.out.println(ret);
            BigInteger addend = new BigInteger(inputA);
            BigInteger augend = new BigInteger(inputB);
            BigInteger ret = addend.add(augend);
            System.out.println(ret);
        }
    }
}
