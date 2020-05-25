package 笔试360;

/**
 * Description:
 *
 * @author: KangWuBin
 * @Date: 2020/3/27
 * @Time: 21:01
 */
public class Main1 {
    int cal(int N, int[] nums) {
        int count = 0;
        int all1 = 0;
        int all2 = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1 || nums[i] == 2) {
                count++;
                all1 += count;
            } else
                count = 0;
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) {
                all2 += count;
                count++;
            } else {
                count = 0;
            }
        }
        return (all1 + all2) / 2;
    }

    public static void main(String[] args) {
        int[] n = {1, 2, 1};
        System.out.print(new Main1().cal(3, n));
    }
}
