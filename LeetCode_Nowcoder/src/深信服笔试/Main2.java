package 深信服笔试;

import java.util.*;

/**
 * Description:
 *
 * @author: KangWuBin
 * @Date: 2020/3/4
 * @Time: 16:09
 */
public class Main2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        String[] strings = input.split(" ");
        Map<String, Integer> map = new HashMap<>();
        for (String key : strings) {
            if (!map.containsKey(key)) {
                map.put(key, 1);
            } else {
                map.put(key, map.get(key) + 1);
            }
        }
        Set<String> keySet = map.keySet();
        Iterator<String> iterable = keySet.iterator();
        while (iterable.hasNext()) {
            String key = iterable.next();
            Integer value = map.get(key);
            System.out.println(key + " " + value);
        }
    }
}
