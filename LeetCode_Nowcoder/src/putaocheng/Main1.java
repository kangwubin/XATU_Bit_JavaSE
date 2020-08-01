package putaocheng;

/**
 * Description:
 *
 * @author: KangWuBin
 * @Date: 2020/8/1
 * @Time: 17:39
 */
public class Main1 {
    public static void main(String[] args) {
        int i, j, k;
        for (i = 0; i < 4; i++) {
            for (j = 0; j < 3 - 1; j++) {
                System.out.print(" ");
            }
            for (k = 0; k < 2 * i + 1; k++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
