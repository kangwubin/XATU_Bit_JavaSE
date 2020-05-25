package 中金所技术笔试0415;

/**
 * Description:
 *
 * @author: KangWuBin
 * @Date: 2020/4/15
 * @Time: 10:50
 */

public class Joseph {
    public int getResult(int n, int m) {
        // write code here
        if (n < 0 || m < 0) {
            return -1;
        }
        int last = 0;
        for (int i = 2; i <= n; i++) {
            last = (last + m) % i;
        }
        return (last + 1);
    }
}
