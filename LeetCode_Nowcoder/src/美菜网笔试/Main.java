package 美菜网笔试;

import java.util.*;

/**
 * Description:
 *
 * @author: KangWuBin
 * @Date: 2020/3/25
 * @Time: 20:08
 */
public class Main {
    static int maxSatisfied(int[] customers, int[] grumpy, int x) {
        if (x > customers.length) {
            return 0;
        }
        int num = 0;
        int maxCount = 0;
        int nowCount = 0;
        int before = 0;
        for (int i = 0; i < customers.length; i++) {
            if (grumpy[i] == before) {
                nowCount += customers[i];
            } else {
                before = grumpy[i];
                if (maxCount < nowCount) {
                    maxCount = nowCount;
                }
                nowCount = 0;
            }

            if (grumpy[i] == 1) {
                num += customers[i];
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int res;

        int _customers_size = 0;
        _customers_size = Integer.parseInt(in.nextLine().trim());
        int[] _customers = new int[_customers_size];
        int _customers_item;
        for (int _customers_i = 0; _customers_i < _customers_size; _customers_i++) {
            _customers_item = Integer.parseInt(in.nextLine().trim());
            _customers[_customers_i] = _customers_item;
        }

        int _grumpy_size = 0;
        _grumpy_size = Integer.parseInt(in.nextLine().trim());
        int[] _grumpy = new int[_grumpy_size];
        int _grumpy_item;
        for (int _grumpy_i = 0; _grumpy_i < _grumpy_size; _grumpy_i++) {
            _grumpy_item = Integer.parseInt(in.nextLine().trim());
            _grumpy[_grumpy_i] = _grumpy_item;
        }

        int _x;
        _x = Integer.parseInt(in.nextLine().trim());

        res = maxSatisfied(_customers, _grumpy, _x);
        System.out.println(String.valueOf(res));

    }
}
