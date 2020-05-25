package day17_191229;

/**
 * Description:
 *
 * @author: KangWuBin
 * @Date: 2019/12/29
 * @Time: 21:34
 */
public class Test9 {
    public String name = "abc";

    public static void main(String[] args) {
        Test9 test = new Test9();
        Test9 test9 = new Test9();
        //false,true
        /* Object中equals方法在没有重写equals方法时，是直接用 == 判断的；
         * String 中重写了equals方法；*/
        System.out.println(test.equals(test9) + "," + test.name.equals(test9.name));
    }
}
