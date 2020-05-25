package day8_191219;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * Description:
 *
 * @author: KangWuBin
 * @Date: 2019/12/19
 * @Time: 22:36
 */
public class Main1 {
    /* 有一个数组a[N]顺序存放0~N-1，要求每隔两个数删掉一个数，
     * 到末尾时循环至开头继续进行，求最后一个被删掉的数的原始下标位置。
     * 以8个数(N=7)为例:｛0，1，2，3，4，5，6，7｝，
     * 0->1->2(删除)->3->4->5(删除)->6->7->0(删除),
     * 如此循环直到最后一个数被删除。*/
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int num = scanner.nextInt();
            Queue<Integer> list = new LinkedList<>();
            for (int i = 0; i < num; i++) {
                list.offer(i);
            }
            while (list.size() != 1) {
                for (int j = 0; j < 2; j++) {
//                    list.poll();
                    list.offer(list.poll());
                }
                list.poll();
            }
            System.out.println(list.poll());
        }
    }
}
