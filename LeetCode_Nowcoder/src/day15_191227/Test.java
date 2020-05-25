package day15_191227;

/**
 * Description:
 *
 * @author: KangWuBin
 * @Date: 2019/12/28
 * @Time: 20:28
 */
class A {
    public A(String str) {
    }
}

public class Test {
    public static void main(String[] args) {
        A classa = new A("he");
        A classb = new A("he");
        System.out.println(classa == classb);//只要new的两个对象去比较地址，输出结果肯定是false
    }
}
