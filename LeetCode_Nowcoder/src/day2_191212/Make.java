package day2_191212;

import java.util.HashSet;
import java.util.Scanner;

/**
 * Description:
 *
 * @author: KangWuBin
 * @Date: 2019/12/11
 * @Time: 9:41
 */
public class Make {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        HashSet<String> hashSet = new HashSet<>();
        while (scanner.hasNext()) {
            hashSet.add(scanner.next());
        }
        int count = hashSet.size();
        System.out.println(count);
    }
}
