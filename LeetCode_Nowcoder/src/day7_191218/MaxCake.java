package day7_191218;

import java.util.Scanner;

/**
 * Description:
 *
 * @author: KangWuBin
 * @Date: 2019/12/18
 * @Time: 0:11
 */
public class MaxCake {
    /* 题目：二货小易有一个W*H的网格盒子，网格的行编号为0~H-1，网格的列编号为0~W-1。
     * 每个格子至多可以放一块蛋糕，任意两块蛋糕的欧几里得距离不能等于2。
     * 对于两个格子坐标(x1,y1),(x2,y2)的欧几里得距离为:
     * ( (x1-x2) * (x1-x2) + (y1-y2) * (y1-y2) ) 的算术平方根小易想知道最多可以放多少块蛋糕在网格盒子里；
     * 输入描述：每组数组包含网格长宽W,H，用空格分割.(1 ≤ W、H ≤ 1000)；
     * 输出描述：输出一个最多可以放的蛋糕数；
     * 输入：3 2；输出：4；*/
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            /* 将计算分为row0+row1和row2+row3；
             * 使用行计算出一共有多少个row01,然后使用(row / 4) * 2计算，
             * 最后在加上余出的几行((row % 4) <= 2 ? (row % 4) : 2);最后的结果就是每列中有多少row01；
             * row23和row01的计算方式一样。
             * 最后计算出一共有多少个4行，因为每4行就有(row01 + row23) * 2个蛋糕，
             * 所以一共有(col / 4) * (row01 + row23) * 2；
             * 最后的最后将行余出的进行单独处理就可以了
             */
            int row = scanner.nextInt();
            int col = scanner.nextInt();
            int row0_1 = (row / 4) * 2 + ((row % 4) <= 2 ? (row % 4) : 2);
        }
    }
}
