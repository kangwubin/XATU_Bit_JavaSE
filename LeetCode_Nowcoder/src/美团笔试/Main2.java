package 美团笔试;

import java.util.Scanner;

/**
 * Description:
 *
 * @author: KangWuBin
 * @Date: 2020/3/12
 * @Time: 19:39
 */
public class Main2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            int m = scanner.nextInt();
            int[] nums = new int[n];
            for (int i = 0; i < n; i++) {
                nums[i] = scanner.nextInt();
            }
            int count = 0;
            for (int i = 0; i < n; i++) {
                int res = nums[i] | m;
                if (res == nums[i]) {
                    count++;
                    System.out.print(nums[i]);
                    break;
                } else {
                    count = 0;
                }
            }
        }
    }
}
