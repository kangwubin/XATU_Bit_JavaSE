package putaocheng;

/**
 * Description:
 *
 * @author: KangWuBin
 * @Date: 2020/8/1
 * @Time: 17:15
 */
public class Main {
    public static void main(String[] args) {
        for (int i = 1; i <= 4; i++) {
            //打印空格
            for (int j = 0; j <= i; j++) {
                System.out.print(" ");
            }
            //打印*
            for (int x = 1; x <= 7 - 2 * (i - 1); x++) {
                System.out.print("*");
            }

            System.out.println();
        }
        func(4);
//        func1(3);
    }

//    public static void func1(int n) {
//        for (int i = 1; i <= n; i++) {
//            //打印空格
//            for (int j = 0; j <= i; j++) {
//                System.out.print(" ");
//            }
//            //打印*
//            for (int x = 1; x <= n - 2 * (i - 1); x++) {
//                System.out.print("*");
//            }
//            System.out.println();
//        }
//    }

    public static void func(int n) {
        int i = 0, j = 0;
        for (i = 0; i < n; i++) {
            for (j = 0; j < n - i; j++) {
                System.out.print("* ");
            }
            System.out.println();
            for (int m = 0; m <= i; m++) {
                System.out.print(" ");
            }
        }
    }

}
