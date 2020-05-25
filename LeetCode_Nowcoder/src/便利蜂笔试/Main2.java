package 便利蜂笔试;

import java.util.Scanner;

/**
 * Description:检查单向链表是否存在环，若存在环则返回环的长度，否则返回0。
 * 要求：算法实现尽可能做到时间、空间复杂度最优。
 *
 * @author: KangWuBin
 * @Date: 2020/3/23
 * @Time: 19:06
 */
public class Main2 {
    public void count(int[][] n) {
        int count = 0;
        int start_node;
        int tmp;
        for (int i = 0; i < n.length; i++) {
            start_node = n[i][0];
            tmp = 0;
            int next = n[i][1];
            count = 0;
            while (tmp < n.length) {
                count++;
                if (next == start_node)
                    break;
                next = n[next - 1][1];
                tmp++;
            }
            if (next == start_node) {
                System.out.println(count);

                return;
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Main2 s = new Main2();
        int n[][] = {
                {1, 2},
                {2, 3},
                {3, 4},
                {4, 5},
                {5, 3}
        };
        s.count(n);
    }
}


