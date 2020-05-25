package day14_191226;

import java.util.Scanner;

/**
 * Description:任何一个整数 m 的立方都可以写成 m 个连续奇数之和。
 * 1^3=1；2^3 =3+5;  3^3=7+9+11;  4^3=13+15+17+19;
 *
 * @author: KangWuBin
 * @Date: 2019/12/26
 * @Time: 22:46
 */
public class Main2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int num = scanner.nextInt();
            int n = num * num - num + 1;
            StringBuffer stringBuffer = new StringBuffer();
            for (int i = n; i <= n + 2 * (num - 1); i++) {
                if (i != n + 2 * (num - 1)) {
                    stringBuffer.append(i + "+");
                    i++;
                } else {
                    stringBuffer.append(i);
                    i++;
                }
            }
            System.out.println(stringBuffer);
        }
    }

    //在线OJ跑不过
    private static String GetSequeOddNum2(int m) {
        int a = m * m - m + 1;
        int ret = a;
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(a);
        for (int i = 1; i < m; i++) {
            a = a + 2 * i;
            stringBuffer = stringBuffer.append("+").append(a);
        }
        return stringBuffer.toString();
    }

    public static void main2(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int num = scanner.nextInt();
            String result = GetSequeOddNum2(num);
            System.out.println(result);
        }
    }

    /* 由例子1~4给出的结论猜测 n3 = (n*(n-1)+1) + (n*(n-1)+2 +1) + ... + (n*(n+1)-2 + 1 )(共n项，等差数列，差为2);
     * 而又等差数列的性质知：
     * (n*(n-1)+1) + (n*(n-1)+2 +1) + ... + (n*(n+1)-2 + 1 )
     * = （(n*(n-1)+1) + (n*(n+1)-2 + 1 )）* n/2
     * = (n2 - n + 1  +  n2 + n -1)*n/2 = n3   成立*/
    public static void main1(String[] args) {
        //在线OJ跑不过
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        String res = "";
        //输出结果
        for (int j = n * (n - 1) / 2; j < n * (n + 1) / 2; j++) {
            if (j != n * (n + 1) / 2 - 1) {
                res += (j * 2 + 1) + "+";
            } else {
                res += (j * 2 + 1);
            }
        }
        System.out.println(res);
    }

}
