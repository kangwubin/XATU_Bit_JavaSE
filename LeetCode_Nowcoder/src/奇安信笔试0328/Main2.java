package 奇安信笔试0328;

import java.util.Scanner;

/**
 * Description:
 * 3,4,8,5,2,6,9,7,1
 * no
 *
 * @author: KangWuBin
 * @Date: 2020/3/28
 * @Time: 20:28
 */
public class Main2 {
    public static void main(String[] args) {
//        int[] n = {3, 4, 8, 5, 2, 6, 9, 7, 1};
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        String[] inputs = input.split("," + " ");
        int[] number = new int[inputs.length];
        for (int i = 0; i < inputs.length; i++) {
            number[i] = Integer.parseInt(inputs[i]);
        }
        String res = Main2.func(number);
        System.out.println(res);
    }

    private static String func(int[] a) {
        String str = null;
        int s1, s2, s3;
        s1 = s2 = s3 = 0;
        for (int i = 0; i < 4; i++) {
            s1 += a[i];
            s2 += a[i + 3];
            if ((i + 6) >= a.length)
                break;
            s3 += a[i + 6];
        }
        if (s1 == s2) {
            if (s1 == (s3 + a[0])) {
                str = "yes";
            }
        } else
            str = "no";
        return str;
    }

    private static void cal(int[] nums) {
        int end = nums.length / 3;
        int a1 = 0, a2 = 0, a3 = 0;
        int i = 0;
        while (i <= end) {
            a1 += nums[i];
            i++;
        }
        i--;
        while (i <= end * 2) {
            a2 += nums[i];
        }
        i--;
        while (i <= end * 3) {
            a3 += nums[i % nums.length];
            i++;
        }
        System.out.println(a1 == a2 && a2 == a3 ? "yse" : "no");
    }
}
