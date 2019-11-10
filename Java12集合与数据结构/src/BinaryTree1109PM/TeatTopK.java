package BinaryTree1109PM;

import java.util.ArrayList;
import java.util.List;

/**
 * Description:
 *
 * @author: KangWuBin
 * @Date: 2019/11/10 11:07
 */
public class TeatTopK {
    // Pair 表示数对, 方便使用 优先队列 来进行管理
    // 一个普通的类, 无法直接放到优先队列中的.
    // 此时优先级如何定义的, 还不明确.
    // 可以把当前的类实现 Comparable 接口, 并实现 compareTo 方法
    // 此时优先队列就可以借助 compareTo 决定谁是优先级高, 谁是优先级低
    static class Pair {
        public int n1;
        public int n2;
        public int sum;

        public Pair(int n1, int n2) {
            this.n1 = n1;
            this.n2 = n2;
            this.sum = n1 + n2;
        }
    }

    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<List<Integer>> result = new ArrayList<>();
        if (k < 1) {
            return result;
        }
        // 创建一个优先队列, 通过这个优先队列来作为堆, 完成最终的 topk 求解
        return result;
    }
}
