package 三七互娱笔试;

/**
 * Description:
 *
 * @author: KangWuBin
 * @Date: 2020/3/25
 * @Time: 18:58
 */
public class TestLast {
    public static void main(String[] args) {
        int a = 2147483647;
        if (a * 2 < 0 == true) {
            System.out.println(1);
        }
        if (a / 2 > 0 == true) {
            System.out.println(2);
        }
        if (a + 1 < a == true) {
            System.out.println(3);
        }
        if (a + 1 > a == true) {
            System.out.println(4);
        }
    }
}
