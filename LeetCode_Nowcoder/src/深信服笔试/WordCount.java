package 深信服笔试;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Scanner;

/**
 * Description:
 *
 * @author: KangWuBin
 * @Date: 2020/3/4
 * @Time: 17:08
 */
public class WordCount {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        count(input);
    }

    public static void count(String input) {
        String[] words = input.split(" ");
        HashMap<String, Integer> counter = new HashMap<>();
        int illegalCounter = 0;
        for (String word : words) {
            word = word.replaceAll("[,:?!]", " ");
            if (word.matches(".*\\d.*")) {
                illegalCounter++;
            } else {
                Integer count = counter.getOrDefault(word, 0);
                counter.put(word, count + 1);
            }
        }

        ArrayList<String> sorted = new ArrayList<>(counter.keySet());
        Collections.sort(sorted);

        System.out.println("非法单词 " + illegalCounter);
        for (String word : sorted) {
            System.out.println(word + " " + counter.get(word));
        }
    }
}
