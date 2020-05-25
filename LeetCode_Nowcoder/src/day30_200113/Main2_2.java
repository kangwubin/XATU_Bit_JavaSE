package day30_200113;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * Description:
 *
 * @author: KangWuBin
 * @Date: 2020/1/13
 * @Time: 22:54
 */
public class Main2_2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            List<BigInteger> list = new ArrayList<>();
            int n = scanner.nextInt();
            for (int i = 0; i < n; i++) {
                BigInteger number = scanner.nextBigInteger();
                list.add(number);
            }
            Collections.sort(list);
            for (int i = 0; i < list.size(); i++) {
                System.out.println(list.get(i));
            }
        }
    }
}
