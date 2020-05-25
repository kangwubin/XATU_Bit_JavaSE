package day8_191219;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Description:
 *
 * @author: KangWuBin
 * @Date: 2019/12/19
 * @Time: 22:32
 */
public class Main2_2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String str = sc.nextLine();
            String[] strings = str.split(" ");
            int[] nums = new int[strings.length - 1];
            for (int i = 0; i < strings.length - 1; i++) {
                nums[i] = Integer.valueOf(strings[i]);
            }
            int k = Integer.valueOf(strings[strings.length - 1]);
            Arrays.sort(nums);
            for (int i = 0; i < k; i++) {
                System.out.print(nums[i]);
                if (i != k - 1) {
                    System.out.print(" ");
                }
            }
        }
    }
}
