package 中金所技术笔试0415;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 * Description:
 *
 * @author: KangWuBin
 * @Date: 2020/4/15
 * @Time: 10:54
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Integer> integerArrayList = new ArrayList<>();
        while (scanner.hasNext()) {
            integerArrayList.add(scanner.nextInt());
        }
        Collections.sort(integerArrayList);
        System.out.println(integerArrayList.get(integerArrayList.size() / 2 - 1));
    }
}
