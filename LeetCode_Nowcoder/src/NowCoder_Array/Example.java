package NowCoder_Array;

/**
 * Description:
 *
 * @author: KangWuBin
 * @Date: 2019/11/14
 * @Time: 17:25
 */
public class Example {
    String str = new String("good");
    char[] ch = {'a', 'b', 'c'};

    public static void main(String args[]) {
        Example ex = new Example();
        ex.change(ex.str, ex.ch);
        System.out.print(ex.str + " and ");//good and
        System.out.print(ex.ch);//gbc
    }

    public void change(String str, char ch[]) {
        //引用类型变量，传递的是地址，属于引用传递。
        str = "test ok";
        ch[0] = 'g';
    }
}
