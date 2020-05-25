package day5_191215;

/**
 * Description:
 *
 * @author: KangWuBin
 * @Date: 2019/12/17
 * @Time: 17:18
 */

import java.util.Scanner;

public class Pocket {
    //Right solution
    static int[] weight;
    static int N;
    static int count = 0;

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        while (input.hasNext()) {
            N = input.nextInt();
            weight = new int[N + 1];
            for (int i = 1; i <= N; i++) {
                weight[i] = input.nextInt();
            }
            count(40, N);
            System.out.println(count);
        }
    }

    /**
     * 本题采用的是递归的思想：
     * 1.物品有n个，将物品逐一放入weight[]中；
     * 2.递归函数count(int s,int n):s表示物品剩余重量，n表示可选择物品个数;
     * 递归分为两步：
     * a.从后往前装，选择后使用s-weight[n],n-1进行递归，如果有解count++；无解则返回
     * b.当选择当前物品无解时就选择忽略当前物品，从n-1个物品进行删除递归；
     */
    public static void count(int s, int n) {
        //如果刚好装满
        if (s == 0) {
            count++;
            return;
        }
        //如果s<0或者n<1则表示不成立
        if (s < 0 || (s > 0 && n < 1)) {
            return;
        }
        //减去当前的物品用剩余的s，进行递归
        count(s - weight[n], n - 1);
        //如果当前物品这条路走不通，则跳过当前物品，直接n -1递归
        count(s, n - 1);
    }
}

