package day20_200102;

import java.util.Arrays;

/**
 * Description:
 *
 * @author: KangWuBin
 * @Date: 2020/1/2
 * @Time: 17:46
 */
public class Gift {
    public static int getValue(int[] gifts, int n) {
        /* 思想：某个红包金额，超过红包总数的一半，；
         * 所以当我们把红包金额从小到大排列时，这个红包金额必然是中位数（位于从小到大排序的数列的最中间位置的数），
         * 所以可以依次将金额值与中位数比较，如果相等，计数加一，问题即可解决。问题的关键在于是否能想到中位数的妙用。*/
        Arrays.sort(gifts);
        int count = 0;
        for (int i = 0; i < gifts.length; i++) {
            if (gifts[i] == gifts[n / 2]) {
                count++;
            }
        }
        if (count > n / 2) {
            return gifts[n / 2];
        }
        return 0;
    }

    public static void main(String[] args) {
        int[] gifts = {1, 2, 3, 2, 2};
        int ret = getValue(gifts, 5);
        System.out.println(ret);
    }
}
