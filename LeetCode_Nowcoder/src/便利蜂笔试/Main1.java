package 便利蜂笔试;

import java.util.Scanner;

/**
 * Description:我们有一堆商品，要装到箱子中。已知箱子的容积是3，也知道每个商品的体积。
 * 不考虑商品的形状，假设只要N个商品的体积加和，恰好是3，就可以装进箱子。
 * 而且，如果商品的体积超过了3，只要恰好是箱子体积的倍数，可以把多个箱子拼成1个大箱子，来装商品。
 * 比如：2个商品，体积加起来是6，可以用2个箱子来装载。
 * 如果加起来是7，就不行了，必须得扔掉某个商品，再继续看能不能装进去。
 * 找出一批商品，恰好装满M个箱子。你能找到的最大的M，是多少？
 * 输入：3,6,5,1,8
 * 输出：6
 *
 * @author: KangWuBin
 * @Date: 2020/3/23
 * @Time: 19:35
 */
public class Main1 {
    static int v = 3;

    public static void main(String[] args) {
        int count = 0;
        int sum = 0;
        int total = 0;
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        String[] strings = input.split(",");
        for (int i = 0; i < strings.length; i++) {
            if (Integer.parseInt(strings[i]) == v || Integer.parseInt(strings[i]) % v == 0) {
                count++;
//                System.out.println(count);
            }
            if (Integer.parseInt(strings[i]) != v || Integer.parseInt(strings[i]) % v != 0) {
                Integer add = Integer.parseInt(strings[i]) + Integer.parseInt(strings[i + 1]);
                if (add == 3 || add % 3 == 0) {
                    sum++;
                }
            }
            total = count + sum;
            System.out.println(total);
        }
    }
}
