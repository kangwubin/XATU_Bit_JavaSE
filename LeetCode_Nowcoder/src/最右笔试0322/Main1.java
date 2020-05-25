package 最右笔试0322;

import java.util.Scanner;

/**
 * Description:
 *
 * @author: KangWuBin
 * @Date: 2020/3/22
 * @Time: 18:27
 */
public class Main1 {
    boolean isReach(int x, int y, int k) {
        int tmp = 0;
        while(x!=0) {
            tmp += x%10;
            x /= 10;
        }
        while(y!=0) {
            tmp += y%10;
            y/=10;
        }
        if( tmp <= k )
            return true;
        else
            return false;
    }

    public int call(int n, int m, int k) {
        int count = 0;
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(isReach(i+1, j+1, k)) {
                    count++;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Main1 s = new Main1();
        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            int m = scanner.nextInt();
            int k = scanner.nextInt();
            System.out.println(s.call(m,n,k));
        }
    }
}
