package day8_191219;

import java.util.*;

/**
 * Description:
 *
 * @author: KangWuBin
 * @Date: 2019/12/18
 * @Time: 23:57
 */
public class Main2 {
    /*找出n个数里最小的K个;
     * 输入：3 9 6 8 -10 7 -11 19 30 12 23 5；
     */
    private static List<String> minK(String[] numbers, int k) {
        Queue<Integer> queue = new PriorityQueue<>();
        for (String i : numbers) {
            queue.add(Integer.valueOf(i));
        }

        List<String> list = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            list.add(String.valueOf(queue.poll()));// 取k个数加到列表中
        }
        return list;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String string = scanner.nextLine();
            int n = scanner.nextInt();
            String[] arr = string.split(" ");
            List ret = minK(arr, n);
            System.out.println(ret);
        }
    }
}
