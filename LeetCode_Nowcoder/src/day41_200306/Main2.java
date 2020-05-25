package day41_200306;

import java.util.Scanner;

/**
 * Description:开发一个坐标计算工具， A表示向左移动，D表示向右移动，W表示向上移动，S表示向下移动。
 * 从（0,0）点开始移动，从输入字符串里面读取一些坐标，并将最终输入结果输出到输出文件里面。
 * 输入：合法坐标为A(或者D或者W或者S) + 数字（两位以内）
 * 坐标之间以;分隔。
 * 非法坐标点需要进行丢弃。如AA10;  A1A;  $%$;  YAD; 等。
 * 下面是一个简单的例子 如：
 * A10;S20;W10;D30;X;A1A;B10A11;;A10;
 * 处理过程：
 * 起点（0,0）
 * +   A10   =  （-10,0）
 * +   S20   =  (-10,-20)
 * +   W10  =  (-10,-10)
 * +   D30  =  (20,-10)
 * +   x    =  无效
 * +   A1A   =  无效
 * +   B10A11   =  无效
 * +  一个空 不影响
 * +   A10  =  (10,-10)
 * 结果 （10， -10）
 *
 * @author: KangWuBin
 * @Date: 2020/3/7
 * @Time: 13:59
 */
public class Main2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        String[] inputs = input.split(";");
        int x = 0;//横坐标
        int y = 0;//纵坐标
        for (int i = 0; i < inputs.length; i++) {
            char[] chars = inputs[i].toCharArray();
            int step = 0;//移动距离
            for (int j = 1; j < chars.length; j++) {
                if (chars[j] > '0' && chars[j] <'9') {
                    step = step * 10 + (chars[j] - '0');
                } else {
                    break;
                }
            }
            switch (inputs[0].charAt(0)) {
                case 'A'://向左移动
                    x -= step;
                    break;
                case 'D':
                    x += step;
                    break;
                case 'W':
                    y += step;
                    break;
                case 'S':
                    y -= step;
                    break;
            }
        }
        System.out.println(x + "," + y);
    }
}
