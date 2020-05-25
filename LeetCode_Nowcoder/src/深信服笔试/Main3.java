package 深信服笔试;

import java.util.Scanner;

import static java.lang.String.valueOf;

/**
 * Description:18位身份证的编码规则是：
 * 某办公系统，首次注册用户只要求输入身份证号码（假设身份证只能是数字，不考虑最后一位是X的情况），
 * 会生成系统默认密码，默认密码规则是身份证后4位按从大到小排序的4位数和年份相加之和。
 * 如：舒服身份证字符串'450205199002104760'
 * 默认密码是数字  9630（7640+1990=9630）
 * 如果身份证输入错误（长度不够、非数字），则输出0
 *
 * @author: KangWuBin
 * @Date: 2020/3/4
 * @Time: 16:42
 */
public class Main3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String idCard = scanner.nextLine();
        System.out.println(passWord(idCard));
    }

    private static int passWord(String input) {
        if (input.length() != 18) {
            return 0;
        }

        String year = input.substring(6, 10);
        int lastYear = Integer.parseInt(year);
        System.out.println(lastYear);

        String lastFour = input.substring(14, 18);
        String[] lastFour1 = lastFour.split("");

        int newLastFour = Integer.parseInt(lastFour);
//        System.out.println(newLastFour);

        int res = lastYear + newLastFour;
        return res;
    }

}
