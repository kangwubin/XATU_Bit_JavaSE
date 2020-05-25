package day27_200110;

import java.util.Scanner;

/**
 * Description:
 *
 * @author: KangWuBin
 * @Date: 2020/1/10
 * @Time: 14:40
 */
public class Main2 {
    /*ip地址的每段可以看成是一个0-255的整数，把每段拆分成一个二进制形式组合起来，然后把这个二进制数转变成一个长整数。
     * 举例：一个ip地址为10.0.3.193;
     * 每段数字:         10             0            3           193
     * 相对应的二进制数:  00001010      00000000     00000011   11000001
     * 组合起来即为：00001010 00000000 00000011 11000001,转换为10进制数就是：167773121，
     * 即该IP地址转换后的数字就是它了。
     * 输入：10.0.3.193         167969729
     * 输出：167773121          10.3.3.193*/
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String Ip = scanner.next();
            String num = scanner.next();
            System.out.println(IpToNum(Ip));
            System.out.println(NumToIp(num));
        }
    }

    //将IP转成数字
    private static long IpToNum(String ip) {
        String[] ip_num = ip.split("\\.");
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < ip_num.length; i++) {
            String tmp = Long.toBinaryString(Long.parseLong(ip_num[i]));
            while (tmp.length() != 8 && i != 0) {
                tmp = "0" + tmp;
            }
            stringBuilder.append(tmp);
        }
        return Long.parseLong(stringBuilder.toString(), 2);
    }

    //将数字转成IP
    private static String NumToIp(String num) {
        long number = Long.parseLong(num);
        String ip = Long.toBinaryString(number);
        StringBuilder stringBuilder = new StringBuilder();
        while (ip.length() % 8 != 0) {
            ip = "0" + ip;
        }
        for (int i = 0; i < ip.length(); i = i + 8) {
            String tmp = ip.substring(i, i + 8);
            stringBuilder.append(Long.parseLong(tmp, 2) + ".");
        }
        return stringBuilder.toString().substring(0, stringBuilder.toString().length() - 1);
    }
}
