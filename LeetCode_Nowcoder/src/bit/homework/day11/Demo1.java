package bit.homework.day11;

/**
 * Description:
 *
 * @author: KangWuBin
 * @Date: 2020/2/9
 * @Time: 12:35
 */
public class Demo1 {
    public static void main(String[] args) {
        int num = 10;
        System.out.println(test(num));
    }

    private static int test(int b) {
        try {
            b += 10;
            return b;
        } catch (RuntimeException e) {
        } catch (Exception e2) {
        } finally {
            b += 10;
            return b;
        }
    }
}
