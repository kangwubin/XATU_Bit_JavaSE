package day5_191215;

import java.util.Scanner;

/**
 * Description:
 *
 * @author: KangWuBin
 * @Date: 2019/12/17
 * @Time: 15:58
 */
public class Main1 {
    /* 一个神奇的口袋，总的容积是40，用这个口袋可以变出一些物品，这些物品的总体积必须是40。
     * John现在有n个想要得到的物品，每个物品的体积分别是a1，a2……an。John可以从这些物品中选择一些，
     * 如果选出的物体的总体积是40，那么利用这个神奇的口袋，John就可以得到这些物品。
     * 现在的问题是，John有多少种不同的选择物品的方式。*/
    static int num;
    static int[] capacity = new int[40];

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            num = scanner.nextInt();
            for (int i = 0; i < num; i++) {
                capacity[i] = scanner.nextInt();
            }
            System.out.println(solution(num - 1, 40));
        }
    }

    private static int solution(int x, int y) {
        if (y == 0) {
            return 1;
        }
        if (x == 0) {
            return capacity[0] == y ? 1 : 0;
        } else {
            return solution(x - 1, y) + solution(x - 1, y - capacity[x]);
        }
    }
}
