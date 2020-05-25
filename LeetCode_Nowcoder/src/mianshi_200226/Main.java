package mianshi_200226;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Description:这里给你出一道简单的算法题:
 * ”把一个数分解成任意几个数之和“,
 * 请通过编写代码(语言不限),试着把一个数的所有和式分解的结果全部输出出来,
 * 例如:4的结果有,(***************************)
 *
 * @author: KangWuBin
 * @Date: 2020/2/26
 *
 * @Time: 20:32
 */
/*
 * 此类问题可以看做是排列组合问题，难点在于去重；
 * 以4为例：4=1+1+1+1；4=1+1+2；4=1+3；4=2+1+1;4=2+2;4=3+1;
 * 在以上示例中存在重复的情况，用list的remove方法进行去重*/
public class Main {
    public static void main(String[] args) {
        List<Integer> integerList = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        Main.function(n, integerList, 1);
    }

    private static void print(List<Integer> list) {
//        System.out.println("遍历List...");
        for (Integer key : list) {
            System.out.print(key + "+");
        }
    }

    /* num:代表输入的需要拆分的数；
     * list:当n被初第一次拆开的时候，list是空的
     * first：表示在遍历的时候当前组合的第一个数字*/
    private static void function(int num, List<Integer> list, int first) {
        if (num == 1) {
            print(list);
            System.out.println(1);
        } else {
            //取输入数字的平均值
            for (int i = first; i <= num / 2; i++) {
                list.add(i);
                function(num - i, list, i);
                list.remove(list.size() - 1);
            }
            print(list);
            System.out.println(num);
        }
    }
}
