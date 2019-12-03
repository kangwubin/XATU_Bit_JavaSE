package LeetCode_MapSet;

import java.util.*;

/**
 * Description:
 *
 * @author: KangWuBin
 * @Date: 2019/12/3
 * @Time: 11:31
 */
public class TopKFrequentWord {
    /*给一非空的单词列表，返回前 k 个出现次数最多的单词。
     *返回的答案应该按单词出现频率由高到低排序。如果不同的单词有相同出现频率，按字母顺序排序.*/
    public static List<String> topKFrequent(String[] words, int k) {
        List<String> ret = new ArrayList<>();
        Map<String, Integer> map = new HashMap<>();
        for (String s : words) {
            if (map.get(s) == null) {
                map.put(s, 1);
            } else {
                map.put(s, map.get(s) + 1);
            }
        }
        PriorityQueue<Map.Entry<String, Integer>> minHeap =
                new PriorityQueue<>(k, new Comparator<Map.Entry<String, Integer>>() {

                    @Override
                    public int compare(Map.Entry<String, Integer> o1,
                                       Map.Entry<String, Integer> o2) {
                        if (o1.getValue().equals(o2.getValue())) {
                            //o1.getKey()  o2.getKey()
                            //单词的频率相同，按照字母的顺序排序
                            return o2.getKey().compareTo(o1.getKey());
                        }
                        return o1.getValue() - o2.getValue();
                    }
                });
        //遍历的是map
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            if (minHeap.size() < k) {
                minHeap.add(entry);
            } else {
                Map.Entry<String, Integer> top = minHeap.peek();
                if (top != null && top.getValue().equals(entry.getValue())) {
                    //val的值相同，需要比较key的值
                    //频率相同的单词--字母小的放进来
                    if (top.getKey().compareTo(entry.getKey()) > 0) {
                        minHeap.poll();
                        minHeap.add(entry);
                    }
                } else {
                    if (top != null && top.getValue() < entry.getValue()) {
                        minHeap.poll();
                        minHeap.add(entry);
                    }
                }
            }
        }
        for (int i = 0; i < k; i++) {
            String tmp = minHeap.poll().getKey();
            //每次往0号位置放，相当于头插法
            ret.add(0, tmp);
        }
        return ret;
    }

    public static void main(String[] args) {
        String[] words = {"i", "love", "leetcode", "i", "love", "coding"};
        List<String> list = topKFrequent(words, 2);
        System.out.println(list);
    }
}
