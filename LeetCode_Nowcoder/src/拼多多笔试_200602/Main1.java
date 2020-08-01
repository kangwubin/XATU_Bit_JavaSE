package 拼多多笔试_200602;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Description:
 *
 * @author: KangWuBin
 * @Date: 2020/6/2
 * @Time: 19:30
 */
public class Main1 {
    private static int fun(Integer num1, Integer num2) {
        Integer num = 0;
        for (long i = 1; i < 1000; i++) {
            if (i % num1 == 0) {
                continue;
            } else {
                num++;
                if (num == num2)
                    return (int) i;
            }
        }
        return num;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Integer length = scanner.nextInt();
        List<Integer> list = new ArrayList<>();
        for (Integer i = 0; i < length; i++) {
            Integer num1, num2;
            num1 = scanner.nextInt();
            num2 = scanner.nextInt();
            list.add(fun(num1, num2));
        }

        for (Integer i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
    }
}