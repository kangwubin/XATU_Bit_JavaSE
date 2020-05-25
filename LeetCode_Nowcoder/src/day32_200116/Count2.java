package day32_200116;

/**
 * Description:
 *
 * @author: KangWuBin
 * @Date: 2020/1/16
 * @Time: 19:52
 */
public class Count2 {
    /* 请编写一个方法，输出0到n(包括n)中数字2出现了几次。
     * 给定一个正整数n，请返回0到n的数字中2出现了几次。*/
    public int countNumberOf2s(int n) {
        if (n < 2) {
            return 0;
        }
        int count = 0;
        for (int m = 1; m <= n; m = m * 10) {
            int a = n / m;
            int b = n % m;
            if (a % 10 >= 3) {
                count += (a / 10 + 1) * m + (a % 10 == 2 ? b + 1 : 0);
            } else if (a % 10 == 2) {
                count += a / 10 * m + (a % 10 == 2 ? b + 1 : 0);
            } else if (a % 10 == 1 || a % 10 == 0) {
                count += a / 10 * m + (a % 10 == 2 ? b + 1 : 0);
            }
        }
        return count;
    }
}
