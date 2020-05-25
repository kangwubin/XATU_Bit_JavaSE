package day14_191226;

/**
 * Description:
 *
 * @author: KangWuBin
 * @Date: 2019/12/26
 * @Time: 22:38
 */
public class Test1 {
    public static void main(String[] args) {
        System.out.println("value = " + switchit(4));
    }

    private static int switchit(int x) {
        int j = 1;
        switch (x) {
            case 1:
                j++;
            case 2:
                j++;
            case 3:
                j++;
            case 4:
                j++;
            case 5:
                j++;
            default:
                j++;
        }
        return j + x;
    }
}
