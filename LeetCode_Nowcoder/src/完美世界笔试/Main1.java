package 完美世界笔试;

import java.util.Scanner;

/**
 * Description:
 *
 * @author: KangWuBin
 * @Date: 2020/3/17
 * @Time: 18:42
 */
public class Main1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            String[] proxy = new String[n];

            for (int i = 0; i < n; i++) {
                proxy[i] = scanner.next();
            }

            int m = scanner.nextInt();
            String[] server = new String[m];
            for (int i = 0; i < m; i++) {
                server[i] = scanner.next();
            }

            int[][] ip = new int[m][n];
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (server[i].equals(proxy[j])) {
                        ip[i][j] = 1;
                    }
                }
            }
            int count = 0;
            int i = m - 1;
            int j = n - 1;
            while (i > 0 && j > 0) {
                if (ip[i - 1][j] > ip[i][j - 1]) {
                    count += ip[i][j - 1];
                    j--;
                } else {
                    count += ip[i - 1][j];
                    i--;
                }
            }
            if (i == 0) {
                System.out.println(count);
            } else {
                System.out.println(-1);
            }
        }
    }
}
