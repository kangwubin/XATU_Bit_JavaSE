package BinaryTree1109PM;

import java.util.PriorityQueue;

/**
 * Description:
 *
 * @author: KangWuBin
 * @Date: 2019/11/10 10:50
 */
public class TestPriorityQueue {
    public static void main(String[] args) {
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        queue.offer(1);
        queue.offer(5);
        queue.offer(2);
        queue.offer(3);
        queue.offer(4);
        while (!queue.isEmpty()) {
            Integer cur = queue.poll();
            System.out.print(cur + " ");
        }
    }
}
