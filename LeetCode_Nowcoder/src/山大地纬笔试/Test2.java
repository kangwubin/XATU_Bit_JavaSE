package 山大地纬笔试;

/**
 * Description:
 *
 * @author: KangWuBin
 * @Date: 2020/3/17
 * @Time: 21:16
 */
public class Test2 {
    int[] a = {1, 2, 3, 4, 5};

    public static void main(String[] args) {
        Test2 test2 = new Test2();
        test2.out();
    }

    private void out() {
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + "");
        }
    }
}
