package LeetCode_MapSet;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Description:经典的topK问题(+++++)
 *
 * @author: KangWuBin
 * @Date: 2019/12/3
 * @Time: 11:27
 */
public class TopKSolution {
    //找到一组数据当中前 K 个最大元素
    public static void topK(int[] array, int k) {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(k, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1 - o2;//小堆
//                return o2 - o1;//大堆
            }
        });
        for (int i = 0; i < array.length; i++) {
            if (priorityQueue.size() < k) {
                priorityQueue.add(array[i]);
            } else {
                Integer top = priorityQueue.peek();
                //大堆：top != null && top > array[i]
                if (top != null && top < array[i]) {
                    priorityQueue.poll();
                    priorityQueue.add(array[i]);
                }
            }
        }
        System.out.println(priorityQueue);
    }

    public static void main(String[] args) {
        int[] array = {9, 5, 2, 7, 3, 6, 8, 1};
        topK(array, 3);
    }
}
