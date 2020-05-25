package 快手笔试;

import java.util.Scanner;

/**
 * Description:输入：1 22 22 33 22 12 45 44 5
 * 输出：4  7
 *
 * @author: KangWuBin
 * @Date: 2020/3/22
 * @Time: 20:16
 */
public class Main3 {

    boolean flag = false;

    public void call(int[] n) {
        for (int i = 1; i < n.length; i++) {
            int tmp = 0;
            for (int j = 0; j < i; j++) {
                if (n[j] > n[i])
                    tmp++;
            }
            if (tmp == 1) {
                System.out.print(i + " ");
                flag = true;
            }
        }
        if (!flag)
            System.out.print(-1);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Main3 s = new Main3();
        while (scanner.hasNext()) {
            int size = scanner.nextInt();
            int n[] = new int[size];
            for (int i = 0; i < size; i++)
                n[i] = scanner.nextInt();
            s.call(n);
        }
    }
}
