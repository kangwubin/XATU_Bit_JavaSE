package day6_191216;

import java.util.Scanner;

/**
 * Description:
 *
 * @author: KangWuBin
 * @Date: 2019/12/16
 * @Time: 10:57
 */
public class Main2 {
    /* 输入n个整数，输出出现次数大于等于数组长度一半的数；
     * 输入：3 9 3 2 5 6 7 3 2 3 3 3；
     * 输出：3；*/
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            //获取字符串
            String input = scanner.nextLine();
            //以空格拆分,去空格操作
            String[] strings = input.split(" ");
            //创建新的数组，长度为去除空格后的原数组的长度
            int[] arr = new int[strings.length];
            //获取新数组的长度
            int len = arr.length;
            //遍历数组，取到所有数据
            for (int i = 0; i < arr.length; i++) {
                arr[i] = Integer.valueOf(strings[i]);
            }
            //从第一个数开始找
            int num = arr[0];
            //定义计数器，用来记录数字出现的次数
            int count = 0;
            //遍历数组，找相同值的个数
            for (int j = 1; j < len; j++) {
                if (arr[j] == num) {
                    count++;
                }
                if (count >= len / 2) {
                    break;
                } else {
                    num = arr[j];
                }
            }
            System.out.println(num);
        }
    }
}
