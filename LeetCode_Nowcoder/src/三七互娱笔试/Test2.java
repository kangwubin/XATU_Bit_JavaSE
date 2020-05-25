package 三七互娱笔试;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * Description:
 *
 * @author: KangWuBin
 * @Date: 2020/3/25
 * @Time: 17:43
 */
public class Test2 {
    public static void main(String[] args) {
        Queue<String> products = new ArrayDeque<String>();
        products.add("p1");
        products.add("p2");
        products.add("p3");
        System.out.print(products.peek());
        System.out.print(products.poll());
        System.out.print(" ");
        products.forEach(s -> System.out.print(s));
    }
}
