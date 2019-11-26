package PriorityQueue20191125;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: GAOBO
 * Date: 2019-11-25
 * Time: 18:03
 */
public class TestDemo {

    public static void main1(String[] args) {
        //小根堆
        Queue<Integer> queue = new PriorityQueue<>();
        queue.offer(120);
        queue.offer(15);
        queue.offer(11);
        int a = queue.poll();
        System.out.println(a);
    }

    public static void main(String[] args) {
        int[] array = {13, 8, 2, 7, 10, 9, 11, 15, 12, 6};
        TestHeap1 testHeap1 = new TestHeap1();
        testHeap1.createHeap(array);
        testHeap1.display();
        //System.out.println(Arrays.toString(array));
        testHeap1.pushHeap(14);
        testHeap1.display();
        testHeap1.popHeap();
        testHeap1.display();
        int ret = testHeap1.getPop();
        System.out.println(ret);
    }
}
