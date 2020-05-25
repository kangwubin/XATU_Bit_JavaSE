package 美团笔试;

import java.util.Scanner;

/**
 * Description:
 *
 * @author: KangWuBin
 * @Date: 2020/3/12
 * @Time: 19:31
 */
public class Main3 {
    static int count = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        int l = scanner.nextInt();
        int r = scanner.nextInt();
        int[] arr = new int[n];
        dfs(arr, 0, l, r, k);
        System.out.println(count);
    }


    private static void dfs(int[] arr, int i, int l, int r, int k) {
        if (i == arr.length) {
            count++;
            return;
        }
        for (int x = l; x <= r; x++) {
            if (x % k == 0) {
                arr[i] = x;
                dfs(arr, i + 1, l, r, k);
            }
        }
    }
}
